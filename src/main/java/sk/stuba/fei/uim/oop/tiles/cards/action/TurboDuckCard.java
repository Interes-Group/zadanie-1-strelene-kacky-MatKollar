package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.cards.Card;
import sk.stuba.fei.uim.oop.tiles.cards.river.DuckCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class TurboDuckCard extends ActionCard {

    public TurboDuckCard() {
        this.name = "Turboduck";
    }

    @Override
    public void activate(Pond pond, Player[] players) {
        while (true) {
            int duckSelection = this.readDuckSelection(pond);
            ArrayList<Card> riverCards = pond.getRiverCards();
            riverCards.add(0, riverCards.get(duckSelection));
            riverCards.remove(duckSelection + 1);
            break;
        }
    }

    private int readDuckSelection(Pond pond) {
        ArrayList<Card> riverCards = pond.getRiverCards();

        while (true) {
            int duckSelection = ZKlavesnice.readInt("Select duck: ");
            duckSelection--;

            if (duckSelection >= 0 && duckSelection < 6 && (riverCards.get(duckSelection) instanceof DuckCard)) {
                return duckSelection;
            }
            else {
                System.out.println("Invalid selection, please try again: ");
            }
        }

    }
}