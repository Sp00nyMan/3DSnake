package com.source.controllers;

import com.source.UserInterface.scene.GameScene;
import com.source.UserInterface.scene.MainMenu;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener
{
	private Stage mainStage;
	private MainMenu menu;
	private GameScene game = null;

	public MainController(Stage primaryStage)
	{
		mainStage = primaryStage;

		menu = new MainMenu(); //If mainGroup is null it will init it with mainMenuGroup from mainMenu
		menu.addActionListener(this);

		//mainStage.setResizable(false);
		mainStage.setTitle(MainMenu.title);
		mainStage.setScene(menu.getScene());
		mainStage.show();
	}

	public void actionPerformed(ActionEvent e)
	{
		switch (e.getID())
		{
			case -1:
				Platform.exit();
				System.exit(0);
			case 0:
				System.out.println("START!!!!!");
				game = new GameScene();
				mainStage.setScene(game.getScene());
				game.start();
				break;
			case 1:
				System.out.println("SETTINGS!!!!!!");
				break;
		}
	}
}
