package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class AimCard extends ActionCard {

    public AimCard() {
        this.name = "Aim";
    }

    @Override
    public void activate(Pond pond) {

       boolean[] crosshairs = pond.getCrosshairs();
       while (true) {
           int aimSelection = this.readAimSelection();
           if (!crosshairs[aimSelection]) {
               crosshairs[aimSelection] = true;
               pond.setCrosshairs(crosshairs);
               break;
           }
       }
    }

    private int readAimSelection() {
        while (true) {
            int aimSelection = ZKlavesnice.readInt("Select where to aim: ");
            if (aimSelection > 0 && aimSelection < 7) {
                return aimSelection - 1;
            }
            else {
                System.out.println("Invalid selection, please try again: ");
            }
        }
    }
}
