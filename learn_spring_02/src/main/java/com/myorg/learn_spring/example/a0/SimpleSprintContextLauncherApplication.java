package com.myorg.learn_spring.example.a0;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan //when left unspecified it will scan the same package for components.
public class SimpleSprintContextLauncherApplication {

    public static void main(String[] args){

        var context = new AnnotationConfigApplicationContext(SimpleSprintContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(
                System.out::println
        );
    }
}
