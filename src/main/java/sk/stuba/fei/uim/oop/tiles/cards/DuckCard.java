package sk.stuba.fei.uim.oop.tiles.cards;

public class DuckCard extends Card {
    private int owner;

    public DuckCard(int playerNumber) {
        this.name = "Duck of player " + Integer.toString(playerNumber);
        this.owner = playerNumber;
    }
}
