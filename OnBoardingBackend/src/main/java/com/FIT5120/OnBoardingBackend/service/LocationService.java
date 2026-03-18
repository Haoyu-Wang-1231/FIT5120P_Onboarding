package com.FIT5120.OnBoardingBackend.service;


import com.FIT5120.OnBoardingBackend.client.OpenUvFeignClient;
import com.FIT5120.OnBoardingBackend.dto.clientResponse.OpenuvResponse;
import com.FIT5120.OnBoardingBackend.dto.response.LocationSummaryResponse;
import com.FIT5120.OnBoardingBackend.entity.entity.Clothing;
import com.FIT5120.OnBoardingBackend.entity.entity.Location;
import com.FIT5120.OnBoardingBackend.entity.entity.UVWarning;
import com.FIT5120.OnBoardingBackend.entity.model.ClothingItemModel;
import com.FIT5120.OnBoardingBackend.entity.model.Recommendation;
import com.FIT5120.OnBoardingBackend.exception.ResourceNotFoundException;
import com.FIT5120.OnBoardingBackend.mapper.LocationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class LocationService {

    @Autowired
    private OpenUvFeignClient openUvFeignClient;

    @Autowired
    private LocationMapper locationMapper;


    private Location getLocationByCoordinate(Double longitude, Double latitude){
        return locationMapper.selectLocationByDetails(longitude, latitude);
    }

    private Location getLocationByName(String name){
        return locationMapper.selectLocationByName(name);
    }

    private List<ClothingItemModel> getClothingList(Integer uvId){
        List<Clothing> clothingList = locationMapper.getClothes(uvId);

        return clothingList.stream()
                .map(c -> new ClothingItemModel(
                        c.getClothName(),
                        c.getDescription(),
                        c.getTag()))
                .toList();
    }


    private Recommendation setupRecommendation(List<ClothingItemModel> clothingList, List<String> protectionDescriptions){
        Recommendation recommendation = new Recommendation();
        recommendation.setClothing(clothingList);
        recommendation.setProtectionTips(protectionDescriptions);

        return recommendation;
    }

    private LocationSummaryResponse setupLocationSummaryResponse(String address, Double currentUvIndex, Double uvMax,Integer uvId, Recommendation recommendation){
        LocationSummaryResponse lsr = new LocationSummaryResponse();
        lsr.setLocationName(address);

        UVWarning uvWarning = locationMapper.getUVWarningDetails(uvId);

        lsr.setUvMax(uvMax);
        lsr.setCurrentUvIndex(currentUvIndex);
        lsr.setUvLevel(uvWarning.getUvLevel());
        lsr.setDescription(uvWarning.getDescription());
        lsr.setRecommendation(recommendation);

        return lsr;
    }

    private Integer convertToUvId(Double uvIndex){
        Integer uvId = (int) Math.floor(uvIndex);

        if(uvId > 12){
            uvId = 12;
        }else if(uvId < 1){
            uvId = 1;
        }
        return uvId;
    }



    public LocationSummaryResponse getUvDetailsByAddressName(String name){
        Location location = getLocationByName(name);

        if(location == null){
            log.info("location not existed.");
            throw new ResourceNotFoundException("No such location.");
        }

        OpenuvResponse or =  openUvFeignClient.getuv(location.getLatitude(), location.getLongitude());
        if(or == null){
            log.info("problem at API calling process.");
            throw new ResourceNotFoundException("problem at API calling process.");
        }
        Double currentUvIndex = or.getResult().getUv();

        Integer uvId = convertToUvId(currentUvIndex);

        log.info("CurrentUVIndexInteger is: {}", uvId);

        List<ClothingItemModel> clothingList = getClothingList(uvId);
        List<String> protectionDescriptionList = locationMapper.protectionTipsDescription(uvId);

        Recommendation recommendation = setupRecommendation(clothingList, protectionDescriptionList);

        return setupLocationSummaryResponse(location.getAddress(),
                currentUvIndex,
                or.getResult().getUvMax(),
                uvId,
                recommendation
            );
    }

    public LocationSummaryResponse getLocationDetails(Double longitude, Double latitude){

        Location location = getLocationByCoordinate(longitude, latitude);

        if(location == null){
            log.info("location not existed.");
            throw new ResourceNotFoundException("No such location.");
        }

        OpenuvResponse or =  openUvFeignClient.getuv(latitude, longitude);
        if(or == null){
            log.info("problem at API calling process.");
            throw new ResourceNotFoundException("problem at API calling process.");
        }
        Double currentUvIndex = or.getResult().getUv();

        Integer uvId = convertToUvId(currentUvIndex);

        log.info("CurrentUVIndexInteger is: {}", uvId);

        List<ClothingItemModel> clothingList = getClothingList(uvId);
        List<String> protectionDescriptionList = locationMapper.protectionTipsDescription(uvId);

        Recommendation recommendation = setupRecommendation(clothingList, protectionDescriptionList);

        return setupLocationSummaryResponse(location.getAddress(),
                currentUvIndex,
                or.getResult().getUvMax(),
                uvId,
                recommendation
        );
    }

}
