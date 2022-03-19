package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.RiverPack;

import java.util.ArrayList;

public class Pond {
    public static final int WATER_COUNT = 5;

    public final static int RIVER_SIZE = 6;
    private boolean[] crosshairs;
    private ArrayList<Card> riverCards;
    private RiverPack riverPack;

    public Pond() {
        this.crosshairs = new boolean[RIVER_SIZE];
        this.riverCards = new ArrayList<>();
        this.preparePacks();
        this.spreadTheCards();
    }

    private void preparePacks() {
        this.riverPack = new RiverPack();
    }

    public void spreadTheCards() {
        for (int i = 0; i < RIVER_SIZE; i++) {
            this.riverCards.add(riverPack.cards.get(i));
            riverPack.cards.remove(i);
        }
    }

    public void draw () {
        System.out.println("Pond:");
        for (int i = 0; i < RIVER_SIZE; i++) {
            System.out.print(i + 1 + ". ");
            this.isAimed(i);
            System.out.println(" - " + this.riverCards.get(i).getName());
        }
    }

    private void isAimed(int i) {
        if (this.crosshairs[i]) {
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

    public void setRiverCards(ArrayList<Card> riverCards) {
        this.riverCards = riverCards;
    }

    public RiverPack getRiverPack() {
        return riverPack;
    }
}