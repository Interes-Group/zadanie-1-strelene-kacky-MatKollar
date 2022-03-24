package sk.stuba.fei.uim.oop.tiles.packs;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.tiles.cards.river.DuckCard;
import sk.stuba.fei.uim.oop.tiles.cards.river.WaterCard;

import java.util.ArrayList;

public class RiverPack extends CardPack {

    public RiverPack(int numberOfPlayers) {
        this.cards = new ArrayList<>();
        this.addWaterCards();
        this.addPlayerDucks(numberOfPlayers);
        this.shufflePack();
    }

    private void addWaterCards() {
        for (int i = 0; i < Pond.WATER_COUNT; i++) {
            WaterCard waterCard = new WaterCard();
            cards.add(waterCard);
        }
    }

    private void addPlayerDucks(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < Player.DUCK_COUNT; j++) {
                DuckCard duckCard = new DuckCard(i + 1);
                cards.add(duckCard);
            }
        }
    }
}