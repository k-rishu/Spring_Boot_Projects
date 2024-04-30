package com.myorg.learn_spring.game;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//class GamingConfiguration {
//
//    @Bean
//    public GamingConsole game(){
//        return new PackManGame();
//    }
//
//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        return new GameRunner(game);
//    }
//}
@Configuration
@ComponentScan("com.myorg.learn_spring.game")
public class App03GamingSpringBeans {


//    @Bean
//    public GamingConsole game(){
//        return new PackManGame();
//    }


//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        return new GameRunner(game);
//    }


    public static void main(String[] args){
//
        var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class);

        context.getBean(GamingConsole.class).up();

        context.getBean(GameRunner.class).run();
    }
}
