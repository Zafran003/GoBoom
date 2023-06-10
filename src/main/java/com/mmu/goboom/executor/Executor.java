package com.mmu.goboom.executor;

import java.util.ArrayList;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.Player;
import com.mmu.goboom.ui.UIMemory;

public class Executor {

	public boolean switchUser(String userInput, Deck deck, Player currentPlayer, ArrayList<Card> centerArray) {
		boolean isValidInput = false;
		switch (userInput) { // what the user entered
		case "s": // suppose to start a new game
			isValidInput = true;
		case "x": // exits the game
			System.exit(0);
		case "d": // Draw cards from deck

			while (deck.getDeck().size() > 0) {
				String result = currentPlayer.drawCard(centerArray, deck);
				if (result.equals("success")) {
					isValidInput = true;
				} else if (result.equals("error")) {
					isValidInput = true;
				}
			}
			break;
		default:

			if (currentPlayer.playCard(userInput, centerArray)) {
				isValidInput = true;
			} else {
				System.out.println("Invalid input, please enter again.\n");
				isValidInput = false;
			}
		}

		return isValidInput;
	}
	
	protected void printLastPlayer(Player lastPlayer) {
		UIMemory.text_label = "Turn " + lastPlayer.toString();

	}
}
