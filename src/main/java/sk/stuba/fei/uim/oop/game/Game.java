package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Game {
    private final Player[] players;
    private Pond pond;

    public Game() {
        System.out.println("Welcome to the game Duck hunt");
        int numberOfPlayers = ZKlavesnice.readInt("Enter the number of players: ");
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player();
        }
        this.pond = new Pond();
        this.startGame();
    }

    private void startGame() {
        System.out.println("------- GAME STARTED -------");
        while (getNumberOfActivePlayers() > 1) {
            this.pond.draw();
            ZKlavesnice.readString("Press Enter To Continue");

        }
        System.out.println("------ GAME FINISHED ------");

    }

    private int getNumberOfActivePlayers() {
        int count = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i].isActive()) {
                count++;
            }
        }
        return count;
    }

}
