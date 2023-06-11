package com.mmu.goboom.ui.util;

import java.util.Arrays;
import java.util.List;

public class StaticString {

	public final static String APP_TITLE = "JavaFX Go Boom Game";
	public final static String ERROR_MESSAGE = "Error";

	public final static String EXIT_GAME = "e";
	public final static String SAVE_GAME = "s";
	public final static String LOAD_GAME = "l";
	public final static String NEW_GAME = "n";
	public final static String RESET_GAME = "r";
	public final static String PLAY_CARD = "play";

	public static final String settingList[] = new String[] { EXIT_GAME, SAVE_GAME, LOAD_GAME, RESET_GAME };
	
	public static final List<String> GAME_SETTING_CHOICES = Arrays.asList(settingList);

}
