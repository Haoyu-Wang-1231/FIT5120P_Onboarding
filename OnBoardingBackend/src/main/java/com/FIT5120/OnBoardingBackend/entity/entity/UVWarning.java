package com.FIT5120.OnBoardingBackend.entity.entity;

import lombok.Data;

@Data
public class UVWarning {

    private Integer uvId;
    private String uvLevel; // high, very height
    private Integer timeToDamage; // to minutes without protection, decimal to present; such as 22
    private String description; // how it might impact human's skin and healthy.

}
