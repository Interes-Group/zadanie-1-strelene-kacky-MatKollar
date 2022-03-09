package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.tiles.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Game {
    private final Player[] players;
    private Pond pond;
    private int roundCounter;

    public Game() {
        System.out.println("Welcome to the game Duck hunt");
        int numberOfPlayers = ZKlavesnice.readInt("Enter the number of players: ");
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("Enter name of the player "+ (i + 1) +":"), i + 1);
        }
        this.pond = new Pond();
        this.startGame();
    }

    private void startGame() {
        System.out.println("------- GAME STARTED -------");
        this.roundCounter = 0;
        while (getNumberOfActivePlayers() > 1) {

            for (int i = 0; i < getNumberOfActivePlayers(); i++) {
                System.out.println("Player number "+ this.players[i].getNumber() + " ("+  this.players[i].getName() +") is on the turn");
                this.pond.draw();
                ZKlavesnice.readString("Press Enter To Continue");
            }
            this.roundCounter++;
            System.out.println("ROUND NUMBER " + this.roundCounter + " IS OVER.\n");
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
