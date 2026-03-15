package com.FIT5120.OnBoardingBackend.entity.model;

import com.FIT5120.OnBoardingBackend.entity.entity.Clothing;
import com.FIT5120.OnBoardingBackend.entity.entity.ProtectionTip;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recommendation {

    private List<ClothingItemModel> clothing;
    private List<String> protectionTips;
}
