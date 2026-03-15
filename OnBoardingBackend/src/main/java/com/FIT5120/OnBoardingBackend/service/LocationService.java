package com.FIT5120.OnBoardingBackend.service;


import com.FIT5120.OnBoardingBackend.dto.join.LocationDetailsJoinUVWarning;
import com.FIT5120.OnBoardingBackend.dto.request.LocationRequest;
import com.FIT5120.OnBoardingBackend.dto.response.LocationSummaryResponse;
import com.FIT5120.OnBoardingBackend.entity.entity.Clothing;
import com.FIT5120.OnBoardingBackend.entity.entity.Location;
import com.FIT5120.OnBoardingBackend.entity.entity.LocationTimeDetails;
import com.FIT5120.OnBoardingBackend.entity.model.ClothingItemModel;
import com.FIT5120.OnBoardingBackend.entity.model.Recommendation;
import com.FIT5120.OnBoardingBackend.mapper.LocationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class LocationService {


    private final LocationMapper locationMapper;


    public LocationService(LocationMapper locationMapper){
        this.locationMapper = locationMapper;
    }

    private Location getLocationByCoordinate(Double longitude, Double latitude){
        return locationMapper.selectLocationByDetails(longitude, latitude);
    }

    private Location getLocationByName(String name){
        String lowercaseName = name.toLowerCase();

        return locationMapper.selectLocationByName(lowercaseName);
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

    private LocationSummaryResponse setupLocationSummaryResponse(String address, Double uvIndex, String uvLevel, String description, Recommendation recommendation){
        LocationSummaryResponse lsr = new LocationSummaryResponse();
        lsr.setLocationName(address);
        lsr.setCurrentUvIndex(uvIndex);
        lsr.setUvLevel(uvLevel);
        lsr.setDescription(description);

        lsr.setRecommendation(recommendation);

        return lsr;
    }


    public LocationSummaryResponse getUvDetailsByAddressName(String name){
        System.out.println("getUvDetailsByAddressName");
        Location location = getLocationByName(name);

        if(location == null){
            log.info("location not existed.");
            return null;
        }

        LocalDate targetDate = LocalDate.now().withYear(2024);
        LocationDetailsJoinUVWarning locationDetailsJoinUVWarning = locationMapper.getLocationDetails(location.getLocationId(), targetDate);
        if(locationDetailsJoinUVWarning == null){
            log.info("no such uv warning details.");
            return null;
        }
        log.info(locationDetailsJoinUVWarning.toString());

        List<ClothingItemModel> ClothingList = getClothingList(locationDetailsJoinUVWarning.getUvId());

        List<String> protectionDescription = locationMapper.protectionTipsDescription(locationDetailsJoinUVWarning.getUvId());

        Recommendation recommendation = setupRecommendation(ClothingList, protectionDescription);

        return setupLocationSummaryResponse(location.getAddress(),
                locationDetailsJoinUVWarning.getUvIndex(),
                locationDetailsJoinUVWarning.getUvLevel(),
                locationDetailsJoinUVWarning.getDescription(),
                recommendation
                );
    }


    public LocationSummaryResponse getLocationDetails(Double longitude, Double latitude){

        Location location = getLocationByCoordinate(longitude, latitude);
        if(location == null){
            System.out.println("no such location.");
            return null;
        }
        log.info(location.toString());
        LocalDate targetDate = LocalDate.now().withYear(2024);

        LocationDetailsJoinUVWarning locationDetailsJoinUVWarning =  locationMapper.getLocationDetails(location.getLocationId(), targetDate);
        if(locationDetailsJoinUVWarning == null){
            log.info("no such uv warning details.");
            return null;
        }

        log.info(locationDetailsJoinUVWarning.toString());

        List<ClothingItemModel> ClothingList = getClothingList(locationDetailsJoinUVWarning.getUvId());

        List<String> protectionDescription = locationMapper.protectionTipsDescription(locationDetailsJoinUVWarning.getUvId());

        Recommendation recommendation = setupRecommendation(ClothingList, protectionDescription);


        return setupLocationSummaryResponse(location.getAddress(),
                locationDetailsJoinUVWarning.getUvIndex(),
                locationDetailsJoinUVWarning.getUvLevel(),
                locationDetailsJoinUVWarning.getDescription(),
                recommendation
        );
    }

}
