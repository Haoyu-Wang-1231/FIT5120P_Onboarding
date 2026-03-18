package com.FIT5120.OnBoardingBackend.client;


import com.FIT5120.OnBoardingBackend.config.OpenUVFeignConfiguration;
import com.FIT5120.OnBoardingBackend.dto.clientResponse.OpenuvResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.HttpExchange;

@FeignClient(name="openuvClient", url= "https://api.openuv.io", configuration = OpenUVFeignConfiguration.class)
public interface OpenUvFeignClient {


//    https://api.openuv.io/api/v1/uv?lat=-34.04&lng=151.1&alt=0


    @GetMapping("/api/v1/uv")
    OpenuvResponse getuv(
        @RequestParam("lat") Double lat,
        @RequestParam("lng") Double lng
    );


}
