package com.FIT5120.OnBoardingBackend.mapper;

import com.FIT5120.OnBoardingBackend.dto.join.LocationDetailsJoinUVWarning;
import com.FIT5120.OnBoardingBackend.entity.entity.Clothing;
import com.FIT5120.OnBoardingBackend.entity.entity.Location;
import com.FIT5120.OnBoardingBackend.entity.entity.LocationTimeDetails;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface LocationMapper {

    Location selectLocationByName(@Param("address") String Name);

    Location selectLocationByDetails(@Param("longitude") Double longitude,
                                     @Param("latitude") Double latitude);

    LocationDetailsJoinUVWarning getLocationDetails(@Param("locationId") Integer id,
                                                    @Param("locationDate") LocalDate locationDate);

    List<Clothing> getClothes(@Param("uvId") Integer uvId);

    List<String> protectionTipsDescription(@Param("uvId") Integer uvId);

}
