package sk.stuba.fei.uim.oop.tiles;


import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.ActionPack;
import sk.stuba.fei.uim.oop.tiles.packs.RiverPack;

import java.util.ArrayList;

public class Pond {
    public static final int WATER_COUNT = 5;


    private final int RIVER_SIZE = 6;
    private boolean[] crosshairs;
    private ArrayList<Card> riverCards;
    private RiverPack riverPack;
    private ActionPack actionPack;

    public Pond() {
        this.crosshairs = new boolean[RIVER_SIZE];
        this.riverCards = new ArrayList<Card>();
        this.preparePacks();
        this.spreadTheCards();
    }

    private void preparePacks() {
        this.riverPack = new RiverPack();
        this.actionPack = new ActionPack();
    }

    private void spreadTheCards() {
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

}
