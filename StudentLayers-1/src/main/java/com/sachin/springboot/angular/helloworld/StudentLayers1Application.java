package com.sachin.springboot.angular.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sachin.springboot.angular")
public class StudentLayers1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentLayers1Application.class, args);
	}

}
