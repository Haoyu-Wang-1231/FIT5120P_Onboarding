package com.FIT5120.OnBoardingBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.FIT5120.OnBoardingBackend.mapper")
@SpringBootApplication
public class OnBoardingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnBoardingBackendApplication.class, args);
	}

}
