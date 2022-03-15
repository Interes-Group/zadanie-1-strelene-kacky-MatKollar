package sk.stuba.fei.uim.oop.tiles.packs;

import sk.stuba.fei.uim.oop.tiles.cards.action.*;

import java.util.ArrayList;

public class ActionPack extends CardPack{
    private final int AIM_CARDS_COUNT = 10;
    private final int SHOOT_CARDS_COUNT = 12;
    private final int WILD_BILL_COUNT = 2;
    private final int DUCK_MARCH_COUNT = 6;
    private final int TURBO_DUCK_COUNT = 1;
    private final int SCATTER_CARD_COUNT = 2;
    private final int DUCK_DANCE_COUNT = 1;


    public ActionPack() {
        this.cards = new ArrayList<>();
        this.addAimCards();
        this.addShootCards();
        this.addWildBillCards();
        this.addDuckMarchCards();
        this.addTurboDuckCard();
        this.addScatterCards();
        this.addDuckDanceCard();
        this.shufflePack();
    }


    private void addAimCards() {
        for (int i = 0; i < AIM_CARDS_COUNT; i++) {
            AimCard aimCard = new AimCard();
            this.cards.add(aimCard);
        }
    }

    private void addShootCards() {
        for (int i = 0; i < SHOOT_CARDS_COUNT; i++) {
            ShootCard shootCard = new ShootCard();
            this.cards.add(shootCard);
        }
    }

    private void addWildBillCards () {
        for (int i = 0; i < WILD_BILL_COUNT; i++) {
            WildBillCard wildBillCard = new WildBillCard();
            this.cards.add(wildBillCard);
        }
    }

    private void addDuckMarchCards() {
        for (int i = 0; i < DUCK_MARCH_COUNT; i++) {
            DuckMarchCard duckMarchCard = new DuckMarchCard();
            this.cards.add(duckMarchCard);
        }
    }

    private void addTurboDuckCard() {
        for (int i = 0; i < TURBO_DUCK_COUNT; i++) {
            TurboDuckCard turboDuckCard = new TurboDuckCard();
            this.cards.add(turboDuckCard);
        }
    }

    private void addScatterCards() {
        for (int i = 0; i < SCATTER_CARD_COUNT; i++) {
            ScatterCard scatterCard = new ScatterCard();
            this.cards.add(scatterCard);
        }
    }

    private void addDuckDanceCard() {
        for (int i = 0; i < DUCK_DANCE_COUNT; i++) {
            DuckDanceCard duckDanceCard = new DuckDanceCard();
            this.cards.add(duckDanceCard);
        }
    }
}
