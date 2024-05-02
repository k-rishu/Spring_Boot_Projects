package com.myorg.learn_spring.example.b1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Lazy
class ClassA{

}

@Component
@Lazy
class ClassB{
     private ClassA classA;
     public ClassB(ClassA classA){
         System.out.println("Some Initialization logic");
         this.classA = classA;
     }
    public void doSomething() {
        System.out.println("doing something...");
    }
}


@Configuration
@ComponentScan //when left unspecified it will scan the same package for components.
public class LazyInitilizationLauncherApplication {

    public static void main(String[] args){

        var context = new AnnotationConfigApplicationContext(LazyInitilizationLauncherApplication.class);

        System.out.println("Initilization of contex is completed");

        context.getBean(ClassB.class).doSomething();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(
                System.out::println
        );
    }
}
