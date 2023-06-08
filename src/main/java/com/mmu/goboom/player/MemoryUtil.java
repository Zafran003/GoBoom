package com.mmu.goboom.player;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mmu.goboom.Card;
import com.mmu.goboom.GameMemory;
import com.mmu.goboom.Player;

import java.io.File;
import java.io.IOException;

public class MemoryUtil {

	public static String RESOURCE_JSON = "resource/";
	public static String write2File(Card leadCard, Player player1, Player player2, Player player3, Player player4,
			int trickCount) throws JsonGenerationException, JsonMappingException, IOException {
        
        ObjectMapper mapper = new ObjectMapper();
        //User user = new User();
        GameMemory gameMemory = new GameMemory();
        gameMemory.setLeadCard(leadCard);
        gameMemory.setPlayer1(player1);
        gameMemory.setPlayer2(player2);
        gameMemory.setPlayer3(player3);
        gameMemory.setPlayer4(player4);
        gameMemory.getCenterArray().add(leadCard);
        // Print out the cards in the players' hands
        gameMemory.setTrickCount(1);

        //Object to JSON in file
        mapper.writeValue(new File(RESOURCE_JSON + "memory.json"), gameMemory);
        
        return mapper.writeValueAsString(gameMemory);
        
	}
}
