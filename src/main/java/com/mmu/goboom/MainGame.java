package com.mmu.goboom;

import com.mmu.goboom.init.*;
import com.mmu.goboom.ui.UIMemory;
import com.mmu.goboom.ui.util.StaticString;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

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

		if (args.length > 0 && args[0].equals("console")) {
			ExecutorService executorService = new ExecutorServiceImpl();
			try {

				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter n for a new game or enter l to load from previous game");
				System.out.print(">");
				String newOrLoad = scanner.next();

				// TODO BOOM: validate newOrLoad , use a new method below

				if (newOrLoad.equals(StaticString.LOAD_GAME)) {
					executorService.runFromFile();
				} else {
					executorService.run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(),
							memory.getPlayer3(), memory.getPlayer4(), memory.getTrickCount(), memory.getDeck(),
							memory.getCenterArray());
				}
				scanner.close();
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

		} else {
			launch(args);
		}

	}

}
