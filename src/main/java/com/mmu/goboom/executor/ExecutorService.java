package com.mmu.goboom.executor;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.Player;

public interface ExecutorService {

	void run(Card leadCard, Player player1, Player player2, Player player3, Player player4, int trickCount, Deck deck,
			ArrayList<Card> centerArray) throws JsonGenerationException, JsonMappingException, IOException;

	void runFromFile();


}
