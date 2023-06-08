package com.mmu.goboom.player;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.Test;

import com.mmu.goboom.GameMemory;

public class JsonTest {

	private static final String RESOURCE = "resource/";

	@Test
	void readMemoryFile() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			GameMemory gameMemory = mapper.readValue(new File(RESOURCE + "memory.json"), GameMemory.class);
			assertNotNull(gameMemory);

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
}
