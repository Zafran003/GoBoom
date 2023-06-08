package com.mmu.goboom;
import java.util.Scanner;

import com.mmu.goboom.player.PlayerService;
import com.mmu.goboom.player.PlayerServiceImpl;
import com.mmu.goboom.player.PlayerUtil;

import java.util.ArrayList;

public class MainGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        Card leadCard = deck.getCard(0); // Get the first card in the deck as the lead card
        deck.removeCard(0); // Remove the lead card from the deck

        // Create arrays to represent the hands of the players
        Card[][] playerHands = new Card[4][7];

        // Draw 7 cards for each player
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                playerHands[j][i] = deck.getCard(0); // Get the top card from the deck
                deck.removeCard(0); // Remove the drawn card from the deck
            }
        }

        // Create instances of the Player class
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        // Assign cards from playerHands array to each player
        for (int i = 0; i < 7; i++) {
            player1.addCard(playerHands[0][i]);
            player2.addCard(playerHands[1][i]);
            player3.addCard(playerHands[2][i]);
            player4.addCard(playerHands[3][i]);
        }

        ArrayList<Card> centerArray = new ArrayList<>();
        centerArray.add(leadCard);

        // Print out the cards in the players' hands
        int trickCount = 1; // Initialize trick count
        while (true) {
            System.out.println("\n");
            System.out.println("Trick #" + trickCount); // Perform trick logic here
            System.out.println(player1);
            System.out.println(player2);
            System.out.println(player3);
            System.out.println(player4);
            System.out.println("Center  : " + centerArray.toString()); // The center card
            System.out.println(deck);
            System.out.println("Score   : Player1 = 0 | Player2 = 0 | Player3 = 0 | Player4 = 0");

            // First player determination
            PlayerService playerService = new PlayerServiceImpl();
            Player firstPlayer = playerService.determineFirstPlayer(leadCard, player1, player2, player3, player4, trickCount);
            System.out.println("Turn " + firstPlayer);

            for (int i = 0; i < 4; i++) {
                String userInput;
                Scanner scanner = new Scanner(System.in); // to resolve scanner

                // Rotate the players' turns
                Player currentPlayer = firstPlayer;
                firstPlayer = PlayerUtil.getNextPlayer(firstPlayer, player1, player2, player3, player4);
                System.out.print("> ");
                userInput = scanner.next();

                switch (userInput) { // what the user entered
                    case "s": // suppose to start a new game
                        return;
                    case "x": // exits the game
                        System.exit(0);
                    case "d": // Draw cards from deck
                        while (deck.getDeckSize() > 0) {
                            String result = currentPlayer.drawCard(centerArray, deck);
                            if (result.equals("success")) {
                                break;
                            } else if (result.equals("error")) {
                                break;
                            }
                        }
                        break;
                    default:
                        if (currentPlayer.playCard(userInput, centerArray)) {
                            break;
                        } else {
                            System.out.println("Invalid input, please enter again.\n");
                        }
                        break;
                }
                System.out.println("\n");
                System.out.println("Trick #" + trickCount);
                System.out.println(player1);
                System.out.println(player2);
                System.out.println(player3);
                System.out.println(player4);
                System.out.println("Center  : " + centerArray.toString()); // The center card
                System.out.println(deck);
                System.out.println("Score   : Player1 = 0 | Player2 = 0 | Player3 = 0 | Player4 = 0");
                System.out.println("Turn " + firstPlayer);
            }
            System.out.println("\n");
            trickCount++; // Increment trick count
            centerArray.clear(); // Clear the centerArray after every trick
        }
    }

}
