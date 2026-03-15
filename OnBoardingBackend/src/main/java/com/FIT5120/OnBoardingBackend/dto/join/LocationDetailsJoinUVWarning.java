package com.FIT5120.OnBoardingBackend.dto.join;

import lombok.Data;

import java.util.Date;

@Data
public class LocationDetailsJoinUVWarning {

    private Integer locationId;
    private Date locationDate;
    private Integer uvId;
    private Double uvIndex;

    private String uvLevel; // high, very height
    private Integer timeToDamage; // to minutes without protection, decimal to present; such as 22
    private String description;
}
