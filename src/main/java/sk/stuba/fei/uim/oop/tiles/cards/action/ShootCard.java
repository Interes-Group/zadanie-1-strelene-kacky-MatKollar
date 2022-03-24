package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.cards.river.DuckCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class ShootCard extends ActionCard {

    public ShootCard() {
        this.name = "Shoot";
    }

    @Override
    public void activate(Pond pond, Player[] players) {
        boolean[] crosshairs = pond.getCrosshairs();
        ArrayList<Card> riverCards = pond.getRiverCards();
        int shootSelection = this.readShootSelection(crosshairs);
        if (riverCards.get(shootSelection) instanceof DuckCard) {
           this.shootDuck(pond, shootSelection, players);
        }
        crosshairs[shootSelection] = false;
        pond.setCrosshairs(crosshairs);
    }

    private int readShootSelection(boolean[] crosshairs) {
        while (true) {
            int shootSelection = ZKlavesnice.readInt("Select where to shoot: ");
            shootSelection--;
            if (shootSelection >= 0 && shootSelection < 6 && crosshairs[shootSelection]) {
                return shootSelection;
            }
            else {
                System.out.println("Invalid selection, please try again: ");
            }
        }
    }

    private void shootDuck(Pond pond, int shootSelection, Player[] players) {
        ArrayList<Card> riverCards = pond.getRiverCards();
        DuckCard duck = (DuckCard) riverCards.get(shootSelection);
        players[duck.getOwner() - 1].duckDied(pond);
        riverCards.remove(shootSelection);
        pond.addCardOnRiver();
    }
}

