package com.example.test;


import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    DataService dataService;

    public BusinessCalculationService(DataService dataService) {this.dataService = dataService;}

    public int calculateMax(){
//        int [] testData = dataService.retriveData();
        return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }

}
