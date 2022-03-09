package sk.stuba.fei.uim.oop.tiles.packs;

import sk.stuba.fei.uim.oop.game.Game;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.Pond;
import sk.stuba.fei.uim.oop.tiles.cards.DuckCard;
import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.cards.WaterCard;

import java.util.ArrayList;


public class RiverPack extends CardPack{

    public RiverPack() {
        this.cards = new ArrayList<>();
        this.addWaterCards();
        this.addPlayerDucks();
        this.shufflePack();
    }

    private void addWaterCards() {
        for (int i = 0; i < Pond.WATER_COUNT; i++) {
            WaterCard waterCard = new WaterCard();
            cards.add(waterCard);
        }
    }

    private void addPlayerDucks() {
        for (int i = 0; i < Game.numberOfPlayers; i++) {
            for (int j = 0; j < Player.DUCK_COUNT; j++) {
                DuckCard duckCard = new DuckCard(i + 1);
                cards.add(duckCard);
            }
        }
    }

}
