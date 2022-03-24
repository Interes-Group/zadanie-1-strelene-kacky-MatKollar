package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.RiverPack;

import java.util.ArrayList;

public class DuckMarchCard extends ActionCard {

    public DuckMarchCard() {
        this.name = "Duck March";
    }

    @Override
    public void activate(Pond pond, Player[] players) {
        ArrayList<Card> riverCards = pond.getRiverCards();
        RiverPack riverPack = pond.getRiverPack();
        riverPack.cards.add(riverCards.get(0));
        riverCards.remove(0);
        pond.addCardOnRiver();
    }
}
