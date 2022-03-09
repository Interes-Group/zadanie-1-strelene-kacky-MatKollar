package sk.stuba.fei.uim.oop.tiles.packs;


import sk.stuba.fei.uim.oop.tiles.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public abstract class CardPack {

    public void shufflePack(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }
}
