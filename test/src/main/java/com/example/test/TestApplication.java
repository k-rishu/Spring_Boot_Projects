package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TestApplication {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(TestApplication.class);

		int temp = context.getBean(BusinessCalculationService.class).calculateMax();

		System.out.println(temp);


	}

}
