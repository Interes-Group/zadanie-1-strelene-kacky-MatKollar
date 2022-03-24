package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.ActionPack;
import sk.stuba.fei.uim.oop.tiles.packs.RiverPack;

import java.util.ArrayList;

public class Pond {
    public static final int WATER_COUNT = 5;
    public final int RIVER_SIZE = 6;

    private boolean[] crosshairs;
    private final ArrayList<Card> riverCards;
    private final RiverPack riverPack;
    private final ActionPack actionPack;

    public Pond(int numberOfPlayers) {
        this.crosshairs = new boolean[RIVER_SIZE];
        this.riverCards = new ArrayList<>();
        this.riverPack = new RiverPack(numberOfPlayers);
        this.actionPack = new ActionPack();
        this.spreadTheCards();
    }

    public void spreadTheCards() {
        for (int i = 0; i < RIVER_SIZE; i++) {
            this.riverCards.add(riverPack.cards.get(0));
            riverPack.cards.remove(0);
        }
    }

    public void draw() {
        System.out.println("Pond:");
        for (int i = 0; i < RIVER_SIZE; i++) {
            System.out.print(i + 1 + ". ");
            this.isAimed(i);
            System.out.println(" - " + this.riverCards.get(i).getName());
        }
    }

    private void isAimed(int row) {
        if (this.crosshairs[row]) {
            System.out.print("Aimed at");
        }
        else {
            System.out.print("Not aimed at");
        }
    }

    public void addCardOnRiver() {
        this.riverCards.add(this.riverPack.cards.get(0));
        this.riverPack.cards.remove(0);
    }

    public boolean[] getCrosshairs() {
        return crosshairs;
    }

    public void setCrosshairs(boolean[] crosshairs) {
        this.crosshairs = crosshairs;
    }

    public ArrayList<Card> getRiverCards() {
        return riverCards;
    }

    public RiverPack getRiverPack() {
        return riverPack;
    }

    public ActionPack getActionPack() {
        return actionPack;
    }
}