package com.FIT5120.OnBoardingBackend.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenUVFeignConfiguration {


    @Value("${openuv.api-key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("x-access-token", apiKey);
        };
    }


}
