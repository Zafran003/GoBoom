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
		GameMemory memory = UIMemory.GAME_MEMORY_UI;
		executorUIService.printLastPlayer(memory.getLastPlayer());
		MemoryUtil.printExecutor(memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(), memory.getPlayer4(),
				memory.getTrickCount(), memory.getDeck(), memory.getCenterArray(), memory.getLastPlayer());
		consoleText.setText(UIMemory.consoleText);
		userInput.setDisable(false);
		textLabel.setText(UIMemory.text_label);
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
		UIMemory.GAME_MEMORY_UI = memory;
		consoleText.setText("Game Reseted!!");
		textLabel.setText("Press Play Button to Continue");
		submitButton.setDisable(false);
	}

	@FXML
	protected void onExitButtonClicked(ActionEvent event) {
		System.exit(0);
	}

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
		UIMemory.submitButton = submitButton;

		userInput.setText("");
		consoleText.setText(UIMemory.consoleText);

		textLabel.setText(UIMemory.text_label);
	}

	private void executeCommand() {
		consoleText.setText("Waiting game to start...");

		ExecutorUIService executorUIService = new ExecutorUIServiceImpl();
		GameMemory memory = UIMemory.GAME_MEMORY_UI;
		executorUIService.run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(),
				memory.getPlayer4(), memory.getTrickCount(), memory.getDeck(), memory.getCenterArray(),
				userInput.getText());

		playGame();

	}
}
