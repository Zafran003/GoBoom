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
import com.mmu.goboom.ui.MainMemory;

public class MemoryUtil {

	public static String RESOURCE_JSON = "resource/";
	public static String write2File(Card leadCard, Player player1, Player player2, Player player3, Player player4,
			int trickCount, Player lastPlayer,  Player currentPlayer, int loopTurn, ArrayList<Card> centerArray, Deck deck) throws JsonGenerationException, JsonMappingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        //User user = new User();
        GameMemory gameMemory = new GameMemory();
        gameMemory.setLeadCard(leadCard);
        gameMemory.setPlayer1(player1);
        gameMemory.setPlayer2(player2);
        gameMemory.setPlayer3(player3);
        gameMemory.setPlayer4(player4);
        gameMemory.setLastPlayer(lastPlayer);
        gameMemory.setCenterArray(centerArray);;
        // Print out the cards in the players' hands
        gameMemory.setTrickCount(1);
        gameMemory.setLoopTurn(loopTurn);
        gameMemory.setCurrentPlayer(currentPlayer);
        gameMemory.setDeck(deck);

        //Object to JSON in file
        mapper.writeValue(new File(RESOURCE_JSON + "memory.json"), gameMemory);
        MainMemory.GAME_MEMORY_MAIN = gameMemory;
        return mapper.writeValueAsString(gameMemory);
        
	}
	
	public static String readFromFile() throws JsonGenerationException, JsonMappingException, IOException {
        
		ObjectMapper mapper = new ObjectMapper();
		GameMemory gameMemory = mapper.readValue(Paths.get(RESOURCE_JSON + "memory.json").toFile(), GameMemory.class);
		
        MainMemory.GAME_MEMORY_MAIN = gameMemory;
        return mapper.writeValueAsString(gameMemory);
        
	}
	
	public static StringBuffer printExecutor(Player player1, Player player2, Player player3, Player player4, int trickCount,
			Deck deck, ArrayList<Card> centerArray, Player lastPlayer) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\n");
		
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
		buffer.append("Last Player: " + lastPlayer);
		buffer.append("\n");
		buffer.append("Center  : " + centerArray.toString()); // The center card
		buffer.append("\n");
		buffer.append(deck);
		buffer.append("\n");
<<<<<<< HEAD
		buffer.append("Score   : Player1 = " + player1.getScore() + "| Player2 = " + player2.getScore() + "| Player3 = " + player3.getScore() + "| Player4 = " + player4.getScore());
=======
		buffer.append("Score   : Player1 = " + player1.getScore() + " | Player2 = " + player2.getScore()+" | Player3 = "+player3.getScore() +" | Player4 = "+player4.getScore()+" |");
>>>>>>> 8acb00cedaaf224f6684503834097ff57f92f8a4
		buffer.append("\n");
		buffer.append("Turn " + lastPlayer);
		
		System.out.println(buffer.toString());
		MainMemory.consoleText =buffer.toString();
		return buffer;
	}
	
	public static StringBuffer printExecutor(GameMemory gameMemory) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\n");
		buffer.append("Trick #" + gameMemory.getTrickCount()); // Perform trick logic here
		buffer.append("\n");
		buffer.append(gameMemory.getPlayer1());
		buffer.append("\n");
		buffer.append(gameMemory.getPlayer2());
		buffer.append("\n");
		buffer.append(gameMemory.getPlayer3());
		buffer.append("\n");
		buffer.append(gameMemory.getPlayer4());
		buffer.append("\n");
		buffer.append("Last Player: " + gameMemory.getLastPlayer());
		buffer.append("\n");
		buffer.append("Center  : " + gameMemory.getCenterArray().toString()); // The center card
		buffer.append("\n");
		buffer.append(gameMemory.getDeck());
		buffer.append("\n");
		buffer.append("Score   : Player1 = 0 | Player2 = 0 | Player3 = 0 | Player4 = 0");
		buffer.append("\n");
		buffer.append("Turn " + gameMemory.getLastPlayer());
		
		System.out.println(buffer.toString());
		MainMemory.consoleText =buffer.toString();
		return buffer;
	}
	
}
