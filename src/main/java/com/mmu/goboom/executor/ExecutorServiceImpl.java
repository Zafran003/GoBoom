package com.mmu.goboom.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.GameMemory;
import com.mmu.goboom.Player;
import com.mmu.goboom.init.InitService;
import com.mmu.goboom.init.InitServiceImpl;
import com.mmu.goboom.player.MemoryUtil;
import com.mmu.goboom.player.PlayerService;
import com.mmu.goboom.player.PlayerServiceImpl;
import com.mmu.goboom.player.PlayerUtil;
import com.mmu.goboom.ui.MainMemory;
import com.mmu.goboom.ui.util.StaticString;

public class ExecutorServiceImpl extends Executor implements ExecutorService {

	GameMemory memory;
	int loopTurn = 0;
	Player currentPlayer = null;
	boolean isReload = false;
	@Override
	public void runFromFile() {
		try {
			this.load();
			this.loopTurn = memory.getLoopTurn();
			MemoryUtil.printExecutor(memory);
			run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(),
					memory.getPlayer4(), memory.getTrickCount(), memory.getDeck(), memory.getCenterArray());
			isReload = true;
			
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
	public void run(Card leadCard, Player player1, Player player2, Player player3, Player player4, int trickCount,
			Deck deck, ArrayList<Card> centerArray) throws JsonGenerationException, JsonMappingException, IOException {
		Scanner scanner = new Scanner(System.in); // to resolve scanner

		while (true) {

			Player lastPlayer = null;
			if (memory != null) {
				leadCard = memory.getLeadCard();
				player1 = memory.getPlayer1();
				player2 = memory.getPlayer2();
				player3 = memory.getPlayer3();
				player4 = memory.getPlayer4();
				trickCount = memory.getTrickCount();
				deck = memory.getDeck();
				centerArray = memory.getCenterArray();
				lastPlayer = memory.getLastPlayer();
				currentPlayer = memory.getCurrentPlayer();
			}

			if (!isReload) {
				if (loopTurn == 0) {
					// First player determination
					PlayerService playerService = new PlayerServiceImpl();

					lastPlayer = playerService.determineFirstPlayer(leadCard, player1, player2, player3, player4,
							trickCount);

					MemoryUtil.printExecutor(player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer);

				}
			}
			

			boolean isPlay = true;
			for (int i = loopTurn; i < 4; i++) {
				String userInput;

				if (!isReload) {
					// Rotate the players' turns
				    currentPlayer = lastPlayer;
					lastPlayer = PlayerUtil.getNextPlayer(lastPlayer, player1, player2, player3, player4);
				}
				System.out.println("current player-->" + currentPlayer);
				System.out.println("last player-->" + lastPlayer);
				
				System.out.print("> ");
				userInput = scanner.next();

				saveState(leadCard, player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer, currentPlayer,
						loopTurn);

				isPlay = this.isPlay(userInput);

				if (!isPlay) {
					break;
				}

				switchUser(userInput, deck, currentPlayer, centerArray);

				// TODO BOOM : implement the saveState from the isPlay(String userInput) and remove the line below
				// the below is auto save
				saveState(leadCard, player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer, currentPlayer,
						loopTurn);

				MemoryUtil.printExecutor(player1, player2, player3, player4, trickCount, deck, centerArray, lastPlayer);
				loopTurn++;
			}

			trickCount++; // Increment trick count
			centerArray.clear(); // Clear the centerArray after every trick
			loopTurn = 0;
			isReload = false;
		}
	}

	protected boolean isPlay(String userInput) throws JsonGenerationException, JsonMappingException, IOException {

		System.out.println("userInput -->" + userInput);

		boolean isGameSetting = StaticString.GAME_SETTING_CHOICES.contains(userInput);
		System.out.println("isGameSetting -->" + isGameSetting);
		if (isGameSetting) {

			if (userInput.equals(StaticString.EXIT_GAME)) {
				System.out.println ("Game Exited");
				System.exit(0);
			} else if (userInput.equals(StaticString.RESET_GAME)) {

				resetPlayer();
				return false;

			} else if (userInput.equals(StaticString.SAVE_GAME)) {
				// TODO BOOM: to be implemented

			}

		}

		return true;
	}

	protected void refreshExecutorService(Card leadCard, Player player1, Player player2, Player player3, Player player4,
			int trickCount, Deck deck, ArrayList<Card> centerArray, Player lastPlayer) {
		System.out.println("\n\n\n\n=======Refreshing data======");
		leadCard = memory.getLeadCard();
		player1 = memory.getPlayer1();
		player2 = memory.getPlayer2();
		player3 = memory.getPlayer3();
		player4 = memory.getPlayer4();
		deck = memory.getDeck();
		trickCount = memory.getTrickCount();
		centerArray = memory.getCenterArray();
		lastPlayer = memory.getLastPlayer();
		loopTurn = memory.getLoopTurn();

	}

	protected void resetPlayer() {
		System.out.println("\n\n\n\n=======Game resetted======");
		InitService InitService = new InitServiceImpl();
		memory = InitService.init();

		MainMemory.GAME_MEMORY_MAIN = memory;
	}

	protected void saveState(Card leadCard, Player player1, Player player2, Player player3, Player player4,
			int trickCount, Deck deck, ArrayList<Card> centerArray, Player lastPlayer, Player currentPlayer, int loopTurn) {

		try {
			MemoryUtil.write2File(leadCard, player1, player2, player3, player4, trickCount, lastPlayer, currentPlayer, loopTurn,
					centerArray);
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

	protected void load() throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("\n\n\n\n=======Game reloaded======");
		MemoryUtil.readFromFile();
		memory = MainMemory.GAME_MEMORY_MAIN;
	}

}
