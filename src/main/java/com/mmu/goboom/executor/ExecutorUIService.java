package com.mmu.goboom.executor;

import java.util.ArrayList;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.Player;

public interface ExecutorUIService {


	void run(Card leadCard, Player player1, Player player2, Player player3, Player player4, int trickCount, Deck deck,
			ArrayList<Card> centerArray, String userInput);

}
