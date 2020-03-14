package com.source.UserInterface;

import com.source.UserInterface.Widgets.Button;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;

public class MainMenu
{
	public static final int ButtonWidth = 300;
	public static final int ButtonHeight = 80;
	public static final int ButtonDepth = 100;
	public static final int DistanceBetweenButtons = 30;

	public static VBox addButtons(VBox mainMenuGroup)
	{
		Group PlayButton = Button.generateButton(new Group(), "START");
		PlayButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("START GAME!!!!!");
			}
		});


		Box SettingButton = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		SettingButton.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("SETTINGS!!!!!");
			}
		});
		SettingButton.translateXProperty().set(ButtonWidth / 2 + 1.3);
		SettingButton.translateYProperty().set(13.3);


		Box ExitButton = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		ExitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("EXIT!!!!!");
			}
		});
		ExitButton.translateXProperty().set(ButtonWidth / 2 + 1.3);
		ExitButton.translateYProperty().set(13.3);

		mainMenuGroup.getChildren().addAll(PlayButton, SettingButton, ExitButton);
		return mainMenuGroup;
	}
}
