package com.myorg.learn_spring.example.a1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class Business{
    Dependency1 dependency1;
    Dependency2 dependency2;

    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
};
@Component
class Dependency1{

};
@Component
class Dependency2{

};

@Configuration
@ComponentScan //when left unspecified it will scan the same package for components.
public class DepInjectionLauncherApplication {

    public static void main(String[] args){

        var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(
                System.out::println
        );
        System.out.println(context.getBean(Business.class));
//        context.getBean(Business.class);
    }
}
