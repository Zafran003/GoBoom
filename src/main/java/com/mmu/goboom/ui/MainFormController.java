package com.mmu.goboom.ui;

import com.mmu.goboom.GameMemory;
import com.mmu.goboom.executor.ExecutorUIService;
import com.mmu.goboom.executor.ExecutorUIServiceImpl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MainFormController {

	/*
	 * @FXML private TextField nameField;
	 * 
	 * @FXML private TextField emailField;
	 * 
	 * @FXML private PasswordField passwordField;
	 */

	@FXML
	private Button submitButton;

	@FXML
	public Label textLabel;

    
    @FXML
    private TextArea consoleText;

	@FXML
	private TextField userInput;

	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {
		userInput.setDisable(false);
		submitButton.setDisable(true);
		executeCommand();
	}

	@FXML
	protected void onKeyTyped(KeyEvent event) {
		String character = event.getCharacter();
		if (character.equals("\r")) {
			executeCommand();
		}

	}

	private void executeCommand() {
		consoleText.setText("Waiting game to start...");
		UIMemory.submitButton = submitButton;
		ExecutorUIService executorUIService = new ExecutorUIServiceImpl();
		GameMemory memory = UIMemory.GAME_MEMORY_UI;
		executorUIService.run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(),
				memory.getPlayer4(), memory.getTrickCount(), memory.getDeck(), memory.getCenterArray(),
				userInput.getText());
		userInput.setText("");
		consoleText.setText(UIMemory.consoleText);
		/*
		 * if(nameField.getText().isEmpty()) {
		 * AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		 * "Please enter your name"); return; } if(emailField.getText().isEmpty()) {
		 * AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		 * "Please enter your email id"); return; }
		 * if(passwordField.getText().isEmpty()) {
		 * AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		 * "Please enter a password"); return; }
		 */

		textLabel.setText(UIMemory.text_label);

	}
}
