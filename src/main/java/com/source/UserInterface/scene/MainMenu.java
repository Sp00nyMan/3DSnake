package com.source.UserInterface.scene;

import com.source.Main;
import com.source.UserInterface.Widgets.Button;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu
{
	public static final int DistanceBetweenButtons = 30;
	public static final String title = "MAIN MENU";

	private Scene scene;
	StackPane PlayButtonPane;
	StackPane SettingsButtonPane;
	StackPane ExitButtonPane;

	public MainMenu(){
		VBox buttonsGroup = new VBox();

		//START BUTTON
		Button PlayButton = new Button("START");
		PlayButtonPane = PlayButton.getStackPane();

		//SETTINGS BUTTON
		Button SettingsButton = new Button("SETTINGS");
		SettingsButtonPane = SettingsButton.getStackPane();

		//EXIT BUTTON
		Button ExitButton = new Button("EXIT");
		ExitButton.changeBoxColor(Color.RED, Color.GREEN);
		ExitButton.changeTextColor(Color.GREEN, Color.RED);
		ExitButtonPane = ExitButton.getStackPane();

		//Adding all buttons to VBox
		buttonsGroup.getChildren().addAll(PlayButtonPane, SettingsButtonPane, ExitButtonPane);
		buttonsGroup.setSpacing(DistanceBetweenButtons);

		Group mainMenuGroup = new Group();
		mainMenuGroup.getChildren().add(buttonsGroup);

		//Moving buttons to the center of the screen
		buttonsGroup.translateXProperty().set(Main.WIDTH / 2 - Button.ButtonWidth / 2);
		buttonsGroup.translateYProperty().set(Main.HEIGHT / 2 - getHeight(3) / 2);

		scene = new Scene(mainMenuGroup, Main.WIDTH, Main.HEIGHT);
		scene.setFill(Color.SILVER);

		Camera camera = new PerspectiveCamera();
		scene.setCamera(camera);
	}

	public Scene getScene()
	{
		return scene;
	}
	private static double getHeight(int buttonCount){
		double height = 0;
		height += Button.ButtonHeight * buttonCount;
		height += (buttonCount - 1) * DistanceBetweenButtons;
		return height;
	}

	public void addActionListener(ActionListener listener){
		PlayButtonPane.setOnMouseClicked(new EventHandler<>()
		{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				listener.actionPerformed(new ActionEvent(this, 0, "start"));
			}
		});

		SettingsButtonPane.setOnMouseClicked(new EventHandler<>()
		{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				listener.actionPerformed(new ActionEvent(this, 1, "settings"));
			}
		});

		ExitButtonPane.setOnMouseClicked(new EventHandler<>()
		{
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				listener.actionPerformed(new ActionEvent(this, -1, "exit"));
			}
		});
	}
}
