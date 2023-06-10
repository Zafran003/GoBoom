package com.mmu.goboom.executor;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.Player;
import com.mmu.goboom.player.MemoryUtil;
import com.mmu.goboom.player.PlayerService;
import com.mmu.goboom.player.PlayerServiceImpl;
import com.mmu.goboom.player.PlayerUtil;
import com.mmu.goboom.ui.AlertUtil;
import com.mmu.goboom.ui.UIMemory;
import com.mmu.goboom.ui.util.StaticString;

public class ExecutorUIServiceImpl implements ExecutorUIService {

	@Override
	public void run(Card leadCard, Player player1, Player player2, Player player3, Player player4, int trickCount,
			Deck deck, ArrayList<Card> centerArray, String userInput) {
		int loopTurn = UIMemory.GAME_MEMORY_UI.getLoopTurn();
		System.out.println("loopTurn-->" + loopTurn);
		Player lastPlayer = UIMemory.GAME_MEMORY_UI.getLastPlayer();
		if (loopTurn == 0) {

			// First player determination
			PlayerService playerService = new PlayerServiceImpl();

			lastPlayer = playerService.determineFirstPlayer(leadCard, player1, player2, player3, player4, trickCount);
			printExecutor(player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer);

			UIMemory.text_label = "Turn " + lastPlayer.toString();
		}

		if (loopTurn > 0 && loopTurn < 4) {
			// Rotate the players' turns
			Player currentPlayer = lastPlayer;

			if (!switchUser(userInput, deck, currentPlayer, centerArray)) {
				AlertUtil.showAlert(StaticString.ERROR_MESSAGE, "Incorrect Input, please try again");
				return;
			}

			lastPlayer = PlayerUtil.getNextPlayer(lastPlayer, player1, player2, player3, player4);
			UIMemory.text_label = "Turn " + lastPlayer.toString();

			UIMemory.consoleText = printExecutor(player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer).toString();

			if (loopTurn == 3) {
				loopTurn = 0;
				trickCount++; // Increment trick count
				centerArray.clear(); // Clear the centerArray after every trick
			}

		}

		loopTurn++;
		
		// TODO: temporary to store the data
		try {
			MemoryUtil.write2File(leadCard, player1, player2, player3, player4, trickCount, lastPlayer, loopTurn);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 

	}

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
	
	public static StringBuffer printExecutor(Player player1, Player player2, Player player3, Player player4, int trickCount,
			Deck deck, ArrayList<Card> centerArray, Player lastPlayer) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Trick #" + trickCount); // Perform trick logic here
		buffer.append("\n");
		buffer.append(player1);
		buffer.append("\n");
		buffer.append(player2);
		buffer.append("\n");
		buffer.append(player3);
		buffer.append("\n");
		buffer.append(player4);
		buffer.append("\n");
		buffer.append("Center  : " + centerArray.toString()); // The center card
		buffer.append("\n");
		buffer.append(deck);
		buffer.append("\n");
		buffer.append("Score   : Player1 = 0 | Player2 = 0 | Player3 = 0 | Player4 = 0");
		buffer.append("\n");
		buffer.append("Turn " + lastPlayer);
		
		System.out.println(buffer.toString());
		return buffer;
	}
}
