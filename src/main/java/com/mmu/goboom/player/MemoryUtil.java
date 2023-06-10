package com.mmu.goboom.player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mmu.goboom.Card;
import com.mmu.goboom.Deck;
import com.mmu.goboom.GameMemory;
import com.mmu.goboom.Player;
import com.mmu.goboom.ui.UIMemory;

public class MemoryUtil {

	public static String RESOURCE_JSON = "resource/";
	public static String write2File(Card leadCard, Player player1, Player player2, Player player3, Player player4,
			int trickCount, Player lastPlayer, int loopTurn) throws JsonGenerationException, JsonMappingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        //User user = new User();
        GameMemory gameMemory = new GameMemory();
        gameMemory.setLeadCard(leadCard);
        gameMemory.setPlayer1(player1);
        gameMemory.setPlayer2(player2);
        gameMemory.setPlayer3(player3);
        gameMemory.setPlayer4(player4);
        gameMemory.setLastPlayer(lastPlayer);
        gameMemory.getCenterArray().add(leadCard);
        // Print out the cards in the players' hands
        gameMemory.setTrickCount(1);
        gameMemory.setLoopTurn(loopTurn);

        //Object to JSON in file
        mapper.writeValue(new File(RESOURCE_JSON + "memory.json"), gameMemory);
        UIMemory.GAME_MEMORY_UI = gameMemory;
        return mapper.writeValueAsString(gameMemory);
        
	}
	
	public static String readFromFile() throws JsonGenerationException, JsonMappingException, IOException {
        
		ObjectMapper mapper = new ObjectMapper();
		GameMemory gameMemory = mapper.readValue(Paths.get(RESOURCE_JSON + "memory.json").toFile(), GameMemory.class);
		
        UIMemory.GAME_MEMORY_UI = gameMemory;
        return mapper.writeValueAsString(gameMemory);
        
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
		UIMemory.consoleText =buffer.toString();
		return buffer;
	}
}
