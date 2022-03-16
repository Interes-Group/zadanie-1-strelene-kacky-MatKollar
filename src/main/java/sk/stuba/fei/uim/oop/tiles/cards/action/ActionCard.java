package sk.stuba.fei.uim.oop.tiles.cards.action;

import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.tiles.cards.Card;

public abstract class ActionCard extends Card {

    public abstract void activate(Pond pond);
}
