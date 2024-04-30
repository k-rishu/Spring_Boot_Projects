package com.myorg.learn_spring.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GamingConsole game;

    public GameRunner(GamingConsole marioGame) {
        this.game = marioGame;
    }

    public void run() {
        System.out.println("Running Game" + game);
        game.up();
        game.down();
        game.right();
        game.left();
    }
}
