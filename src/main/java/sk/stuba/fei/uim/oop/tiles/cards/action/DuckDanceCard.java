package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.packs.RiverPack;

import java.util.ArrayList;

public class DuckDanceCard extends ActionCard{

    public DuckDanceCard() {
        this.name = "Duck Dance";
    }

    @Override
    public void activate(Pond pond, Player[] players) {
        ArrayList<Card> riverCards = pond.getRiverCards();
        RiverPack riverPack = pond.getRiverPack();
        this.addCardsToRiverPack(riverCards, riverPack);
        riverPack.shufflePack();
        pond.spreadTheCards();
    }

    private void addCardsToRiverPack(ArrayList<Card> riverCards, RiverPack riverPack) {
        riverPack.cards.addAll(riverCards);
        riverCards.clear();
    }
}
