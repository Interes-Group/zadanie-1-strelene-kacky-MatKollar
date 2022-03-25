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
    private final ArrayList<ActionCard> actionCardsOnHand;

    public static final int DUCK_COUNT = 5;
    public final int PLAYER_CARDS_COUNT = 3;

    public Player(String name, int number) {
        this.name = name;
        this.number = number;
        this.ducks = DUCK_COUNT;
        this.actionCardsOnHand = new ArrayList<>();
    }

    public void getCards(Pond pond) {
        ActionPack actionPack = pond.getActionPack();
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            this.actionCardsOnHand.add((ActionCard) actionPack.cards.get(0));
            actionPack.cards.remove(0);
        }
    }

    public void drawCardsOnHand() {
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            System.out.println(i + 1 + ". " + actionCardsOnHand.get(i).getName());
        }
    }

    public void drawDucksNumber() {
        System.out.print("Ducks: " + this.ducks + "\n");
    }

    public void useActionCard(Pond pond, Player[] players) {
        this.actionCardsOnHand.get(cardSelection).activate(pond, players);
        if (this.isAlive()) {
            this.takeNewCard(pond, this.cardSelection);
        }
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

    public void takeNewCard(Pond pond, int cardSelection) {
        ActionPack actionPack = pond.getActionPack();
        returnUsedCard(actionPack, cardSelection);
        this.actionCardsOnHand.add((ActionCard) actionPack.cards.get(0));
        actionPack.cards.remove(0);
    }

    private void returnUsedCard(ActionPack actionPack, int cardSelection) {
        actionPack.cards.add(this.actionCardsOnHand.get(cardSelection));
        this.actionCardsOnHand.remove(cardSelection);
    }

    public void duckDied(Pond pond) {
        this.ducks--;
        if (this.ducks == 0) {
            this.playerEliminated(pond);
        }
    }

    public void playerEliminated(Pond pond) {
        ActionPack actionPack = pond.getActionPack();
        System.out.println("Player number " + this.number + " (" + this.name + ") was ELIMINATED!");
        for (int i = 0; i < PLAYER_CARDS_COUNT; i++) {
            this.returnUsedCard(actionPack, 0);
        }
    }

    public boolean isAlive() {
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