package com.mmu.goboom.player;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import com.mmu.goboom.GameMemory;
import com.mmu.goboom.Player;

public class PlayerTest {

	private static final String RESOURCE = "resource/";

	// Objective of test 
	// Positive/Negative Scenario Test
	// Passing parameter
	@Test
	void drawCardTest() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		GameMemory gameMemory = mapper.readValue(new File(RESOURCE + "memory_determineFirstPlayer_all_values.json"),
				GameMemory.class);
		Player player = gameMemory.getPlayer1();
		String returnValue = player.drawCard(gameMemory.getCenterArray(), gameMemory.getDeck());
		System.out.println("returnValue=" + returnValue);
		assertTrue(returnValue.equals("success"));

	}
	
	// Objective of test
	// Positive/Negative Scenario Test
	// Passing parameter
	@Test
	void playCardTest() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		GameMemory gameMemory = mapper.readValue(new File(RESOURCE + "memory_determineFirstPlayer_all_values.json"),
				GameMemory.class);
		Player player = gameMemory.getPlayer1();
		boolean isTrue = player.playCard("s5", gameMemory.getCenterArray());
		System.out.println("returnValue=" + isTrue);
		assertTrue(isTrue);

	}
}
