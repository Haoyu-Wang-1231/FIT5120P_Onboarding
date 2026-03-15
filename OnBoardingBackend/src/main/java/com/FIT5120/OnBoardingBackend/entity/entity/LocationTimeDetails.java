package com.FIT5120.OnBoardingBackend.entity.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LocationTimeDetails {

    private Integer locationId;
    private Date locationDate;
    private Integer uvId;
    private Double uvIndex;

}
