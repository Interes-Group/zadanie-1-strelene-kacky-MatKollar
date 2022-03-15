package sk.stuba.fei.uim.oop.tiles.cards.river;

import sk.stuba.fei.uim.oop.tiles.cards.Card;

public class DuckCard extends Card {
    private int owner;

    public DuckCard(int playerNumber) {
        this.owner = playerNumber;
        this.name = "Duck of player " + Integer.toString(this.owner);

    }
}
