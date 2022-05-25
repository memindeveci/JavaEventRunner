package dev.meh;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void greet() {
        System.out.println(name + " greets you!");
    }
}
