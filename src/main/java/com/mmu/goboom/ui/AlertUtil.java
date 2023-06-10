package com.mmu.goboom.ui;

import com.mmu.goboom.ui.util.AlertHelper;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class AlertUtil {

	public static void showAlert(String title, String message) {
		Window owner = UIMemory.submitButton.getScene().getWindow();
		AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, message,
				title);
	}
	
}
