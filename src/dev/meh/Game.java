package dev.meh;

import dev.meh.Events.EventManager;
import dev.meh.Events.PlayerChatEvent;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private static boolean gameOn = false;
    private static List<Player> players;

    public Game() {
        players = new ArrayList<>();
        // add players when they join the server, world.
        players.add(new Player("Skipboi"));
        players.add(new Player("Ethernal"));
        players.add(new Player("xattas"));
        players.add(new Player("joe"));
        initializeEvents();
    }

    public void initializeEvents()
    {
        // intiialize all the events here, to register them to the EventManager eventHandlers list.
        new PlayerChatEvent();
    }


    public void mainLoop()
    {
        while(!Game.windowShouldClose()) {
            // inputs, events
            EventManager.getInstance().pollEvents();
        }
    }

    public static Player findPlayerByName(String name)
    {
        for (Player p: players)
        {
            if (p.getName().equals(name))
            {
               return p;
            }
        }
        return null;
    }


    public static boolean windowShouldClose() {
        return Game.gameOn;
    }

    public static void setWindowShouldClose(boolean option) {
        Game.gameOn = option;
    }


}
