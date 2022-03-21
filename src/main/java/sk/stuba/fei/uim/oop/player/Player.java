package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.tiles.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.tiles.packs.ActionPack;

import java.util.ArrayList;
import java.util.Objects;

public class Player {

    private final String name;
    private final int number;
    private int ducks;
    private int cardSelection;
    private ArrayList<ActionCard> actionCardsOnHand;

    public static final int DUCK_COUNT = 5;
    public static final int PLAYER_CARDS_COUNT = 3;


    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.ducks = DUCK_COUNT;
        this.actionCardsOnHand = new ArrayList<>();
    }

    public void getCards(ActionPack actionPack) {
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            this.actionCardsOnHand.add((ActionCard) actionPack.cards.get(i));
            actionPack.cards.remove(i);
        }
    }

    public void drawCardsOnHand() {
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            System.out.println(i+1+". " + actionCardsOnHand.get(i).getName());
        }
    }

    public void useActionCard(ActionPack actionPack, Pond pond, Player[] players) {
        this.actionCardsOnHand.get(cardSelection).activate(pond, players);
        this.takeNewCard(actionPack, this.cardSelection);
    }

    public boolean cardCanBePlayed(Pond pond, ActionCard card) {
        if (Objects.equals(card.getName(), "Shoot")) {
            return this.canYouShoot(pond);
        }
        else if (Objects.equals(card.getName(), "Aim")) {
            return this.canYouAim(pond);
        }
        else {
            return true;
        }
    }

    private boolean canYouShoot(Pond pond) {
        boolean[] crosshairs = pond.getCrosshairs();
        for (boolean crosshair : crosshairs) {
            if (crosshair) {
                return true;
            }
        }
        return false;
    }

    private boolean canYouAim(Pond pond) {
        boolean[] crosshairs = pond.getCrosshairs();
        for (boolean crosshair : crosshairs) {
            if (!crosshair) {
                return true;
            }
        }
        return false;
    }

    public void takeNewCard(ActionPack actionPack, int cardSelection) {
        returnUsedCard(actionPack, cardSelection);
        this.actionCardsOnHand.add((ActionCard) actionPack.cards.get(0));
        actionPack.cards.remove(0);
    }

    private void returnUsedCard(ActionPack actionPack, int cardSelection) {
        actionPack.cards.add(this.actionCardsOnHand.get(cardSelection));
        this.actionCardsOnHand.remove(cardSelection);
    }

    public void duckDied() {
        this.ducks--;
    }

    public boolean isActive() {
        return this.ducks > 0;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setCardSelection(int cardSelection) {
        this.cardSelection = cardSelection;
    }

    public ArrayList<ActionCard> getActionCardsOnHand() {
        return actionCardsOnHand;
    }
}