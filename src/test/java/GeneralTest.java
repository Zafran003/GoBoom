import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class GeneralTest {

	public final static String EXIT_GAME = "e";
	public final static String SAVE_GAME = "s";
	public final static String LOAD_GAME = "l";
	public final static String RESET_GAME = "r";
	public final static String PLAY_CARD = "play";

	@Test
	void arrayListTest() {

		String a[] = new String[] { "A", EXIT_GAME, SAVE_GAME, LOAD_GAME };

		Collection<String> aList = new ArrayList<String>(Arrays.asList(a));
		boolean isTrue = aList.contains("A");
		assertTrue(isTrue);
		isTrue = aList.contains(EXIT_GAME);	
		assertTrue(isTrue);
		
		

	}

}
