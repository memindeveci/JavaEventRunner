package dev.meh.Events;


import dev.meh.Game;
import dev.meh.Player;
import java.util.Scanner;

public class PlayerChatEvent implements PlayerEventHandler {

    private final Scanner scanner = new Scanner(System.in);
    private String name;

    public PlayerChatEvent() {
        EventManager.getInstance().registerHandler(this);
    }

    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public Player getPlayer() {
        Player p = Game.findPlayerByName(name);
        if (p == null)
        {
            System.out.println("Player named " + name + " does not exist.");
        }
        return p;
    }

    @Override
    public boolean getCondition() {
        name = "joe";
        return true;
    }

    public String getMessage() {
        return scanner.nextLine();
    }

}
