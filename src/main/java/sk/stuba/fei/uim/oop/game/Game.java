package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.board.Pond;
import sk.stuba.fei.uim.oop.tiles.cards.action.ActionCard;
import sk.stuba.fei.uim.oop.tiles.packs.ActionPack;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


public class Game {
    private final Player[] players;
    private final Pond pond;
    private int roundCounter;
    private ActionPack actionPack;
    public static int numberOfPlayers;

    public Game() {
        System.out.println("Welcome to the game Duck hunt");
        this.readNumberOfPlayers();
        this.players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i] = new Player(ZKlavesnice.readString("Enter name of the player "+ (i + 1) +":"), i + 1);
        }
        this.actionPack = new ActionPack();
        this.pond = new Pond();
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
        System.out.println("----------- GAME STARTED -----------");
        this.roundCounter = 0;
        this.spreadPlayerCards();
        while (getNumberOfActivePlayers() > 1) {

            for (int currentPlayer = 0; getNumberOfActivePlayers() > 1; currentPlayer = this.getNextPlayer(currentPlayer)) {
                System.out.println("Player number "+ this.players[currentPlayer].getNumber() + " ("+  this.players[currentPlayer].getName() +") is on the turn");
                this.pond.draw();
                System.out.println("\nCards of player "+ + this.players[currentPlayer].getNumber() + " ("+  this.players[currentPlayer].getName() + "):");
                this.players[currentPlayer].drawCardsOnHand();

                if (this.actionCardsCanBePlayed(currentPlayer)) {
                    this.selectCard(currentPlayer);
                    this.players[currentPlayer].useActionCard(actionPack, this.pond, this.players);
                }
                else {


                    System.out.println("\nYou can't use any card (ROUND SKIPPED)");
                    this.players[currentPlayer].takeNewCard(actionPack, 0);
                }
                ZKlavesnice.readString("Press Enter To Continue");
                if (currentPlayer == getLastActivePlayer()) {
                    break;
                }
            }
            this.roundCounter++;
            System.out.println("ROUND NUMBER " + this.roundCounter + " IS OVER.\n");
        }
        this.printWinner();
        System.out.println("---------- GAME FINISHED ----------");
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

    private int getLastActivePlayer() {
        int lastActive = 0;
        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isActive()) {
                lastActive = i;
            }
        }
        return lastActive;
    }

    private int getNextPlayer(int currentPlayer) {
        for (int nextPlayer = currentPlayer + 1; nextPlayer < this.players.length; nextPlayer++) {
            if (this.players[nextPlayer].isActive()) {
                return nextPlayer;
            }
        }
        return currentPlayer;
    }

    private void spreadPlayerCards() {
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players[i].getCards(actionPack);
        }
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
                    System.out.println("You can't play this card.");
                }
            }
            else {
                System.out.println("Invalid card selection, please try again: ");
            }
        }
    }

    private void printWinner() {
        for (int i = 0; i < this.players.length; i++) {
            if (players[i].isActive()) {
                System.out.println("THE WINNER IS PLAYER "+ players[i].getNumber() + " ("+ players[i].getName() + ").");
            }
        }
    }
}