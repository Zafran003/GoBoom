package com.mmu.goboom.executor;

import java.util.ArrayList;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.Player;
import com.mmu.goboom.ui.MainMemory;

public class Executor {

	// this method being shared by console and gui

	public boolean switchUser(String userInput, Deck deck, Player currentPlayer, ArrayList<Card> centerArray) {
		boolean isValidInput = false;
		switch (userInput) { // what the user entered

		case "d": // Draw cards from deck

			while (deck.getDeck().size() > 0) {
				String result = currentPlayer.drawCard(centerArray, deck);
				if (result.equals("success")) {
					isValidInput = true;
					break;
				} else if (result.equals("error")) {
					isValidInput = true;
					break;
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
		MainMemory.text_label = "Turn " + lastPlayer.toString();

	}
}
