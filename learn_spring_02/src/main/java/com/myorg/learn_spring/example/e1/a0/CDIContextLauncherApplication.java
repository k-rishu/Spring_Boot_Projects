package com.myorg.learn_spring.example.e1.a0;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class BusinessService{
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }
    @Autowired
    public void setDataService(DataService dataService) {
        System.out.println("Setter injection is performed...");
        this.dataService = dataService;
    }

}
@Component
class DataService{

}


@Configuration
@ComponentScan //when left unspecified it will scan the same package for components.
public class CDIContextLauncherApplication {

    public static void main(String[] args){

        var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(
                System.out::println
        );
    }
}
