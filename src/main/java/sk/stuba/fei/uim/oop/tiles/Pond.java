package sk.stuba.fei.uim.oop.tiles;


import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.RiverPack;

import java.util.ArrayList;

public class Pond {
    public static final int WATER_COUNT = 5;


    private final int riverSize = 6;
    private boolean[] crosshairs;
    private ArrayList<Card> riverCards;
    private RiverPack riverPack;

    public Pond() {
        this.crosshairs = new boolean[riverSize];
        this.riverCards = new ArrayList<Card>();
        this.preparePacks();
    }

    private void preparePacks() {
        this.riverPack = new RiverPack();
    }

    public void draw () {
        System.out.println("Pond:");
        for (int i = 0; i < riverSize; i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(this.crosshairs[i]);
        }
    }

}
