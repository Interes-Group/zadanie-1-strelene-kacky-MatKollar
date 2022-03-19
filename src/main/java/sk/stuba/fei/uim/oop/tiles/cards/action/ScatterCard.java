package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.cards.Card;

import java.util.ArrayList;
import java.util.Collections;

public class ScatterCard extends ActionCard {

    public ScatterCard() {
        this.name = "Scatter";
    }

    @Override
    public void activate(Pond pond, Player[] players) {
        ArrayList<Card> riverCards = pond.getRiverCards();
        Collections.shuffle(riverCards);
    }
}
