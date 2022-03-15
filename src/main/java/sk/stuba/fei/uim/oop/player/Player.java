package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.ActionPack;

import java.util.ArrayList;

public class Player {

    private final String name;
    private final int number;
    private int ducks;
    private boolean active;
    private ArrayList<Card> actionCards;

    public static final int DUCK_COUNT = 5;
    public static final int PLAYER_CARDS_COUNT = 3;


    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.ducks = 5;
        this.active = true;
        this.actionCards = new ArrayList<>();
    }

    public void getCards(ActionPack actionPack) {
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            this.actionCards.add(actionPack.cards.get(i));
            actionPack.cards.remove(i);
        }
    }

    public void drawCards() {
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            System.out.println(i+1+". " + actionCards.get(i).getName());
        }
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
