package com.mmu.goboom;

import com.mmu.goboom.init.*;
import com.mmu.goboom.ui.UIMemory;
import com.mmu.goboom.ui.util.StaticString;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.mmu.goboom.executor.*;

public class MainGame extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("goboom.fxml"));
		primaryStage.setTitle(StaticString.APP_TITLE);
		primaryStage.setScene(new Scene(root, 800, 500));
		primaryStage.show();
	}

	public static void main(String[] args) {

		InitService InitService = new InitServiceImpl();
		GameMemory memory = InitService.init();

        UIMemory.GAME_MEMORY_UI = memory;
	//	ExecutorService executorService = new ExecutorServiceImpl();
	//	executorService.run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(),
	//			memory.getPlayer4(), memory.getTrickCount(), memory.getDeck(), memory.getCenterArray());
		
		launch(args);
	}

}
