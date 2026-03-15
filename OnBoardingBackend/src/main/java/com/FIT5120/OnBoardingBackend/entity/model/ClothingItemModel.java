package com.FIT5120.OnBoardingBackend.entity.model;

import lombok.Data;

@Data
public class ClothingItemModel {

    public ClothingItemModel(String item, String description, String tag){
        this.item = item;
        this.description = description;
        this.tag = tag;
    }


    private String item;
    private String description;
    private String tag;



}
