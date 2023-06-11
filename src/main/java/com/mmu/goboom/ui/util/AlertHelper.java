package com.mmu.goboom.ui.util;

import com.mmu.goboom.ui.UIMemory;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class AlertHelper {

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
	public static void showAlert(String title, String message) {
		Window owner = UIMemory.submitButton.getScene().getWindow();
		AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, title,
				message);
	}
}
