package javafx.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Window;

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
    private Label textLabel;
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
    	
    	textLabel.setText("anything");
        Window owner = submitButton.getScene().getWindow();
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

        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome ");
    }
}
