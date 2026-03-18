package com.FIT5120.OnBoardingBackend.dto.response;

import com.FIT5120.OnBoardingBackend.entity.model.Recommendation;
import lombok.Data;


@Data
public class LocationSummaryResponse {

    private String locationName;
    private Double currentUvIndex;
    private Double uvMax;
    private String uvLevel;
    private String description;
    private Recommendation recommendation;
    //cloth Information


}
