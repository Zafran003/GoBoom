package com.mmu.goboom.player;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

	@Test
	void basicTest() throws JsonParseException, JsonMappingException, IOException {
		PlayerService playerService = new PlayerServiceImpl();
		ObjectMapper mapper = new ObjectMapper();

		GameMemory gameMemory = mapper.readValue(new File(RESOURCE + "memory.json"), GameMemory.class);

		//Player player = playerService.determineFirstPlayer(gameMemory.getLeadCard(), gameMemory.getPlayer1(),
		//		gameMemory.getPlayer2(), gameMemory.getPlayer3(), gameMemory.getPlayer4(), 0);
		//assertNotNull(player);
	}

}
