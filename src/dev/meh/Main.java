package dev.meh;

import dev.meh.Events.EventManager;
import dev.meh.Events.GreetPlayer;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        EventManager.getInstance().registerListener(new GreetPlayer());

        game.mainLoop();

        

    }
}
