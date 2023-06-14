package com.mmu.goboom.init;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.GameMemory;
import com.mmu.goboom.Player;

public class InitServiceImpl implements InitService{

	@Override
	public GameMemory init() {
		Deck deck = new Deck();
		GameMemory gameMemory = new GameMemory();
		
        Card leadCard = deck.getDeck().get(0); // Get the first card in the deck as the lead card
        deck.removeCard(0); // Remove the lead card from the deck

        // Create arrays to represent the hands of the players
        Card[][] playerHands = new Card[4][7];

        // Draw 7 cards for each player
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                playerHands[j][i] = deck.getDeck().get(0); // Get the top card from the deck
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

        // set the memory of players and cards
        gameMemory.setLeadCard(leadCard);
        gameMemory.setPlayer1(player1);
        gameMemory.setPlayer2(player2);
        gameMemory.setPlayer3(player3);
        gameMemory.setPlayer4(player4);
        gameMemory.getCenterArray().add(leadCard);
        // Print out the cards in the players' hands
        gameMemory.setTrickCount(1);
        gameMemory.setDeck(deck);
        return gameMemory;
	}
}
