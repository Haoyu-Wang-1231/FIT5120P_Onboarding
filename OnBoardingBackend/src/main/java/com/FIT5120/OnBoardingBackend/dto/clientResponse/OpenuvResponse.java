package com.FIT5120.OnBoardingBackend.dto.clientResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenuvResponse {

    private Result result;

    @Data
    public static class Result{
        private Double uv;

        @JsonProperty("uv_max")
        private Double uvMax;
    }


}
