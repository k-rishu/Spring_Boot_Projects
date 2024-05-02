package com.myorg.learn_spring.example.d1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencits are ready!");
    }
    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Clean up the database");
    }
}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("some Logic for someDependency");
    }
}
@Configuration
@ComponentScan //when left unspecified it will scan the same package for components.
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] args){
        try (
            var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class);

        ){}

    }
}
