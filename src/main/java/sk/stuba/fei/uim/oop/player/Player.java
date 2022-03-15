package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.tiles.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.tiles.packs.ActionPack;

import java.util.ArrayList;

public class Player {

    private final String name;
    private final int number;
    private int ducks;
    private int cardSelection;
    private boolean active;
    private ArrayList<ActionCard> actionCardsOnHand;

    public static final int DUCK_COUNT = 5;
    public static final int PLAYER_CARDS_COUNT = 3;


    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.ducks = 5;
        this.active = true;
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

    public void useActionCard(ActionPack actionPack) {
        this.actionCardsOnHand.get(cardSelection).activate();
        this.takeNewCard(actionPack);
    }

    private void takeNewCard(ActionPack actionPack) {
        returnUsedCard(actionPack);
        this.actionCardsOnHand.add((ActionCard) actionPack.cards.get(0));
        actionPack.cards.remove(0);
    }

    private void returnUsedCard(ActionPack actionPack) {
        actionPack.cards.add(this.actionCardsOnHand.get(cardSelection));
        this.actionCardsOnHand.remove(cardSelection);
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setCardSelection(int cardSelection) {
        this.cardSelection = cardSelection;
    }
}
