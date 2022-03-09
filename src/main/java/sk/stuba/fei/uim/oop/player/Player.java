package sk.stuba.fei.uim.oop.player;

public class Player {

    private final String name;
    private final int number;
    private int ducks;
    private boolean active;

    public static final int DUCK_COUNT = 5;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.ducks = 5;
        this.active = true;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

}
