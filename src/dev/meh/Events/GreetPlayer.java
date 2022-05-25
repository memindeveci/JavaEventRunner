package dev.meh.Events;

import dev.meh.Game;

public class GreetPlayer implements Listener {

    @EventListener
    public void Greet(PlayerChatEvent e) {
        switch (e.getMessage()) {
            case "0":
                System.out.println("Terminating");
                Game.setWindowShouldClose(true);
                break;
            case "1":
                e.getPlayer().greet();
                break;
            case "2":
                System.out.println("not 1");
                break;

            default:
                System.out.println("Usage: 0 (terminates the chat) OR 1 (activates the listeners)");
                break;
        }
    }

}
