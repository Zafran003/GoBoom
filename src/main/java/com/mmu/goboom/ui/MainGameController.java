package com.mmu.goboom.ui;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.mmu.goboom.GameMemory;
import com.mmu.goboom.executor.ExecutorUIService;
import com.mmu.goboom.executor.ExecutorUIServiceImpl;
import com.mmu.goboom.init.InitService;
import com.mmu.goboom.init.InitServiceImpl;
import com.mmu.goboom.player.MemoryUtil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MainGameController {

	@FXML
	private Button submitButton;

	@FXML
	private Button onSaveButton;

	@FXML
	private Button onResetButton;

	@FXML
	private Button onExitButton;

	@FXML
	private Button onLoadButton;

	@FXML
	public Label textLabel;

	@FXML
	private TextArea consoleText;

	@FXML
	private TextField userInput;

	@FXML
	protected void onLoadButtonClicked(ActionEvent event)
			throws JsonGenerationException, JsonMappingException, IOException {
		MemoryUtil.readFromFile();
		textLabel.setText("Game loaded Successfully");

		ExecutorUIService executorUIService = new ExecutorUIServiceImpl();
		GameMemory memory = MainMemory.GAME_MEMORY_MAIN;
		executorUIService.printLastPlayer(memory.getLastPlayer());
		MemoryUtil.printExecutor(memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(), memory.getPlayer4(),
				memory.getTrickCount(), memory.getDeck(), memory.getCenterArray(), memory.getLastPlayer());
		consoleText.setText(MainMemory.consoleText);
		userInput.setDisable(false);
		textLabel.setText(MainMemory.text_label);
		this.onLoadButton.setDisable(true);
	}

	@FXML
	protected void onSaveButtonClicked(ActionEvent event) {

		textLabel.setText("Game Saved Successfully");
	}

	@FXML
	protected void onResetButtonClicked(ActionEvent event) {
		InitService InitService = new InitServiceImpl();
		GameMemory memory = InitService.init();
		MainMemory.GAME_MEMORY_MAIN = memory;
		consoleText.setText("Game Reseted!!");
		textLabel.setText("Press Play Button to Continue");
		submitButton.setDisable(false);
	}

	@FXML
	protected void onExitButtonClicked(ActionEvent event) {
		System.exit(0);
	}

	// Presentation 4b (continue)
	// mapped from scene builder and play button 
	@FXML
	protected void onSubmitButtonClicked(ActionEvent event) {
		userInput.setDisable(false);
		submitButton.setDisable(true);
		this.onLoadButton.setDisable(true);
		
		
		executeCommand();
	}

	@FXML
	protected void onKeyTyped(KeyEvent event) {
		String character = event.getCharacter();
		if (character.equals("\r")) {
			executeCommand();
		}

	}

	private void playGame() {
		MainMemory.submitButton = submitButton;

		userInput.setText("");
		consoleText.setText(MainMemory.consoleText);

		textLabel.setText(MainMemory.text_label);
	}

	// Presentation 5.
	// Init the ExecutorUIServiceImpl service for GUI
	// ExecutorServiceImpl for the console
	private void executeCommand() {
		consoleText.setText("Waiting game to start...");

		ExecutorUIService executorUIService = new ExecutorUIServiceImpl();
		
		// load back from JVM static value
		GameMemory memory = MainMemory.GAME_MEMORY_MAIN;
		
		// Presentation 5b hold ctrl and click run implemention to explain
		executorUIService.run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(),
				memory.getPlayer4(), memory.getCurrentPlayer(), memory.getTrickCount(), memory.getDeck(), memory.getCenterArray(),
				userInput.getText());

		playGame();

	}
}
