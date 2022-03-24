package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class AimCard extends ActionCard {

    public AimCard() {
        this.name = "Aim";
    }

    @Override
    public void activate(Pond pond,  Player[] players) {
        boolean[] crosshairs = pond.getCrosshairs();
        int aimSelection = this.readAimSelection(crosshairs);
        crosshairs[aimSelection] = true;
        pond.setCrosshairs(crosshairs);
    }

    private int readAimSelection(boolean[] crosshairs) {
        while (true) {
            int aimSelection = ZKlavesnice.readInt("Select where to aim: ");
            aimSelection--;
            if (aimSelection >= 0 && aimSelection < 6 && !crosshairs[aimSelection]) {
                return aimSelection;
            }
            else {
                System.out.println("Invalid selection, please try again: ");
            }
        }
    }
}