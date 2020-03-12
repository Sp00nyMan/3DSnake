package com.source.UserInterface;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Box;

public class MainMenu
{
	public static final int ButtonWidth = 300;
	public static final int ButtonHeight = 80;
	public static final int ButtonDepth = 100;
	public static final int DistanceBetweenButtons = 30;

	public static Group addButtons(Group mainMenuGroup)
	{
		Box PlayButton = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		PlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("START GAME!!!!!");
			}
		});
		PlayButton.translateYProperty().set(41.3);
		PlayButton.translateXProperty().set(ButtonWidth / 2 + 1.3);


		Box SettingButton = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		SettingButton.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("SETTINGS!!!!!");
			}
		});
		SettingButton.translateYProperty().set(ButtonHeight + DistanceBetweenButtons * 2 + 11.3);
		SettingButton.translateXProperty().set(ButtonWidth / 2 + 1.3);


		Box ExitButton = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		ExitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("EXIT!!!!!");
			}
		});
		ExitButton.translateYProperty().set(ButtonHeight * 2 + DistanceBetweenButtons * 3 + 11.3);
		ExitButton.translateXProperty().set(ButtonWidth / 2 + 1.3);

		mainMenuGroup.getChildren().addAll(PlayButton, SettingButton, ExitButton);
		return mainMenuGroup;
	}
}
