package com.source.UserInterface;

import com.source.UserInterface.Widgets.Button;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;

public class MainMenu
{
	public static final int DistanceBetweenButtons = 30;

	public static VBox addButtons(VBox mainMenuGroup)
	{
		StackPane PlayButton = Button.generateButton(new StackPane(), "START");
		PlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("START GAME!!!!!");
			}
		});


		StackPane SettingButton = Button.generateButton(new StackPane(), "SETTINGS");
		SettingButton.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("SETTINGS!!!!!");
			}
		});

		StackPane ExitButton = Button.generateButton(new StackPane(), "EXIT");
		ExitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("EXIT!!!!!");
			}
		});

		mainMenuGroup.getChildren().addAll(PlayButton, SettingButton, ExitButton);
		return mainMenuGroup;
	}
}
