package com.FIT5120.OnBoardingBackend.controller;

import com.FIT5120.OnBoardingBackend.dto.request.LocationNameRequest;
import com.FIT5120.OnBoardingBackend.dto.request.LocationRequest;
import com.FIT5120.OnBoardingBackend.dto.response.LocationSummaryResponse;
import com.FIT5120.OnBoardingBackend.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1")
public class LocationController {

    private final LocationService locationService;


    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping("/hello")
    public String welcome(){
        return "OK";
    }

//    @GetMapping("/getLocation")
//    public Location getLocation1(@RequestParam(value = "cityId", defaultValue = "1") Long id){
//
//
//        return locationService.getLocation(id);
//    }

    @PostMapping("/getUVDetailByLocationName")
    public ResponseEntity<LocationSummaryResponse> getUVDetailsByLocationName(@RequestBody LocationNameRequest request){
        LocationSummaryResponse response= locationService.getUvDetailsByAddressName(request.getAddress());

        return ResponseEntity.ok(response);
    }


    @PostMapping("/getUVDetailByLocationCoordinate")
    public ResponseEntity<LocationSummaryResponse> getLocation(@RequestBody LocationRequest request){
        LocationSummaryResponse response = locationService.getLocationDetails(request.getLongitude(), request.getLatitude());

        return ResponseEntity.ok(response);
    }






}
