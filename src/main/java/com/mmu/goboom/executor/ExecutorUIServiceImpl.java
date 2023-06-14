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
import com.mmu.goboom.ui.MainMemory;
import com.mmu.goboom.ui.util.AlertHelper;
import com.mmu.goboom.ui.util.StaticString;

public class ExecutorUIServiceImpl  extends Executor implements ExecutorUIService {

	// Presentation #6
	// Implementation almost same except while loop like console
	// Implementation here is per click and each click load from static JVM memory 
	@Override
	public void run(Card leadCard, Player player1, Player player2, Player player3, Player player4, Player currentPlayer, int trickCount,
			Deck deck, ArrayList<Card> centerArray, String userInput) {
		int loopTurn = MainMemory.GAME_MEMORY_MAIN.getLoopTurn();
		System.out.println("loopTurn-->" + loopTurn);
		Player lastPlayer = MainMemory.GAME_MEMORY_MAIN.getLastPlayer();
		if (loopTurn == 0) {

			// First player determination
			PlayerService playerService = new PlayerServiceImpl();

			lastPlayer = playerService.determineFirstPlayer(leadCard, player1, player2, player3, player4, trickCount);
			MemoryUtil.printExecutor(player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer);

			this.printLastPlayer(lastPlayer);
		}

		if (loopTurn > 0 && loopTurn < 4) {
			// Rotate the players' turns
			currentPlayer = lastPlayer;

			// TODO BOOM must have: create a try catch here, if exception being throw, then throw an error
			if (!switchUser(userInput, deck, currentPlayer, centerArray)) {
				AlertHelper.showAlert(StaticString.ERROR_MESSAGE, "Incorrect Input, please try again");
				return;
			}

			lastPlayer = PlayerUtil.getNextPlayer(lastPlayer, player1, player2, player3, player4);

			this.printLastPlayer(lastPlayer);

			MemoryUtil.printExecutor(player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer);

			if (loopTurn == 3) {
				loopTurn = 0;
				trickCount++; // Increment trick count
				centerArray.clear(); // Clear the centerArray after every trick
			}

		}

		loopTurn++;

		// TODO: temporary to store the data
		try {
			MemoryUtil.write2File(leadCard, player1, player2, player3, player4, trickCount, lastPlayer, currentPlayer, loopTurn, centerArray, deck);
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

	@Override
	public void printLastPlayer(Player lastPlayer) {
		super.printLastPlayer(lastPlayer);
	}
}
