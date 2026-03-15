package com.FIT5120.OnBoardingBackend;

import com.FIT5120.OnBoardingBackend.entity.entity.Location;
import com.FIT5120.OnBoardingBackend.mapper.LocationMapper;
import com.FIT5120.OnBoardingBackend.service.LocationService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnBoardingBackendApplicationTests {

	@Resource
	private LocationService ls;

	@Resource
	private  LocationMapper locationMapper;


	@Test
	@Disabled
	void contextLoads() {
//		Location location = new Location();
//		location.setId("1");
//		location.setAddress("Clayton");
//		location.setLongitude(100.222F);
//		location.setLatitude(10.33F);
//
//		int insert = locationMapper.insertLocation(location);
//		System.out.println("insert= " + insert);

	}


	@Test
	void simpleTests(){

	}




}
