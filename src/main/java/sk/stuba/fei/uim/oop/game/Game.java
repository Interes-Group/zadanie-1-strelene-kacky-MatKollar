package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.tiles.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Game {
    private final Player[] players;
    private final Pond pond;
    private int numberOfPlayers;

    public Game() {
        System.out.println("Welcome to the game Duck hunt");
        this.readNumberOfPlayers();
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("Enter name of the player "+ (i + 1) +":"), i + 1);
        }
        this.pond = new Pond(numberOfPlayers);
        this.startGame();
    }

    private void readNumberOfPlayers() {
        while (true) {
            numberOfPlayers = ZKlavesnice.readInt("Enter the number of players: ");
            if (numberOfPlayers > 1 && numberOfPlayers < 7) {
                break;
            }
            else {
                System.out.println("Invalid number of players (2-6), please try again: ");
            }
        }
    }

    private void startGame() {
        System.out.println("<----------- GAME STARTED ----------->");
        int roundCounter = 0;
        this.spreadPlayerCards();
        while (getNumberOfActivePlayers() > 1) {
            for (Player player : this.players) {
                if (player.isAlive()) {
                    System.out.println("\nPlayer number " + player.getNumber() + " ("+  player.getName() +") is on the turn");
                    player.drawDucksNumber();
                    this.pond.draw();
                    System.out.println("\nCards of player " + player.getNumber() + " ("+  player.getName() + "):");
                    player.drawCardsOnHand();
                    if (this.actionCardsCanBePlayed(player.getNumber()-1)) {
                        this.selectCard(player.getNumber()-1);
                        player.useActionCard(this.pond, this.players);
                    }
                    else {
                        System.out.println("\nYou can't use any card (ROUND SKIPPED)");
                        player.takeNewCard(this.pond, 0);
                    }
                    if (getNumberOfActivePlayers() == 1) {
                        break;
                    }
                }
            }
            roundCounter++;
            System.out.println("ROUND NUMBER " + roundCounter + " IS OVER.\n");
        }
        this.printWinner();
        System.out.println("<---------- GAME FINISHED ---------->");
    }

    private void spreadPlayerCards() {
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i].getCards(this.pond);
        }
    }

    private int getNumberOfActivePlayers() {
        int count = 0;
        for (Player player : this.players) {
            if (player.isAlive()) {
                count++;
            }
        }
        return count;
    }

    private boolean actionCardsCanBePlayed(int playerNumber) {
        for (ActionCard card : this.players[playerNumber].getActionCardsOnHand()) {
           if(this.players[playerNumber].cardCanBePlayed(this.pond, card)) {
            return true;
           }
        }
        return false;
    }

    private void selectCard(int i) {
        while (true) {
            int cardSelection = ZKlavesnice.readInt("Select action card:");

            if (cardSelection > 0 && cardSelection < 4) {
                players[i].setCardSelection(cardSelection-1);
                ActionCard card = this.players[i].getActionCardsOnHand().get(cardSelection-1);
                if (players[i].cardCanBePlayed(this.pond, card)) {
                    break;
                }
                else {
                    System.out.println("You can't play this card right now.");
                }
            }
            else {
                System.out.println("Invalid card selection, please try again: ");
            }
        }
    }

    private void printWinner() {
        for (Player player : this.players) {
            if (player.isAlive()) {
                System.out.println("THE WINNER IS PLAYER " + player.getNumber() + " (" + player.getName() + ").");
            }
        }
    }
}