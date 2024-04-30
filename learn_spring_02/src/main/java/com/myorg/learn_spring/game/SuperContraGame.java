package com.myorg.learn_spring.game;

public class SuperContraGame implements GamingConsole{

    @Override
    public void down() {
        System.out.println("Sit..");
    }

    @Override
    public void left() {
        System.out.println("Go Back");
    }

    @Override
    public void right() {
        System.out.println("Shoot A bullet.");
    }

    @Override
    public void up() {
        System.out.println("Jump ");
    }
}
