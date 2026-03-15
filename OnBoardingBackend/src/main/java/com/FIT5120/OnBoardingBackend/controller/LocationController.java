package com.FIT5120.OnBoardingBackend.controller;

import com.FIT5120.OnBoardingBackend.dto.request.LocationNameRequest;
import com.FIT5120.OnBoardingBackend.dto.request.LocationRequest;
import com.FIT5120.OnBoardingBackend.dto.response.LocationSummaryResponse;
import com.FIT5120.OnBoardingBackend.entity.entity.Location;
import com.FIT5120.OnBoardingBackend.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        LocationSummaryResponse lsr;


        try{
            lsr = locationService.getUvDetailsByAddressName(request.getAddress());

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

        return ResponseEntity.ok(lsr);
    }


    @PostMapping("/getUVDetailByLocationCoordinate")
    public ResponseEntity<LocationSummaryResponse> getLocation(@RequestBody LocationRequest request){
        LocationSummaryResponse lsr;

        try{
            lsr = locationService.getLocationDetails(request.getLongitude(), request.getLatitude());

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

        return ResponseEntity.ok(lsr);
    }






}
