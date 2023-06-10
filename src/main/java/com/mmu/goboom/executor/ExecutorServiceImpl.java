package com.mmu.goboom.executor;

import java.util.ArrayList;
import java.util.Scanner;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.Player;
import com.mmu.goboom.player.PlayerService;
import com.mmu.goboom.player.PlayerServiceImpl;
import com.mmu.goboom.player.PlayerUtil;

public class ExecutorServiceImpl extends Executor implements ExecutorService {

	@Override
	public void run(Card leadCard, Player player1, Player player2, Player player3, Player player4, int trickCount,
			Deck deck, ArrayList<Card> centerArray) {
		Scanner scanner = new Scanner(System.in); // to resolve scanner

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

			Player firstPlayer = playerService.determineFirstPlayer(leadCard, player1, player2, player3, player4,
					trickCount);

			System.out.println("Turn " + firstPlayer);

			for (int i = 0; i < 4; i++) {
				String userInput;

				// Rotate the players' turns
				Player currentPlayer = firstPlayer;
				firstPlayer = PlayerUtil.getNextPlayer(firstPlayer, player1, player2, player3, player4);
				System.out.print("> ");
				userInput = scanner.next();
				switchUser(userInput, deck, currentPlayer, centerArray);
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
