package com.mmu.goboom.player;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import com.mmu.goboom.GameMemory;
import com.mmu.goboom.Player;

class PlayerServiceImplTest {

	private static final String RESOURCE = "resource/";

	// Objective of test 
	// Positive/Negative Scenario Test
	// Expected Result 
	@Test
	void testWinnerAllDataPlayer1() throws JsonParseException, JsonMappingException, IOException {
		PlayerService playerService = new PlayerServiceImpl();
		ObjectMapper mapper = new ObjectMapper();

		GameMemory gameMemory = mapper.readValue(new File(RESOURCE + "memory_determineFirstPlayer_all_values.json"), GameMemory.class);

		Player player = playerService.determineFirstPlayer(gameMemory.getLeadCard(), gameMemory.getPlayer1(),
				gameMemory.getPlayer2(), gameMemory.getPlayer3(), gameMemory.getPlayer4(), 0);
		assertNotNull(player);
		assertTrue(player.getPlayerName().equals("Player 1"));
	}

	// Objective of test 
	// Positive/Negative Scenario Test
	// Expected Result 
	@Test
	void testWinner1DataPlayer1() throws JsonParseException, JsonMappingException, IOException {
		PlayerService playerService = new PlayerServiceImpl();
		ObjectMapper mapper = new ObjectMapper();

		GameMemory gameMemory = mapper.readValue(new File(RESOURCE + "memory_determineFirstPlayer_1_array_value.json"), GameMemory.class);

		Player player = playerService.determineFirstPlayer(gameMemory.getLeadCard(), gameMemory.getPlayer1(),
				gameMemory.getPlayer2(), gameMemory.getPlayer3(), gameMemory.getPlayer4(), 0);
		assertNotNull(player);
		assertTrue(player.getPlayerName().equals("Player 1"));
	}
	
}
