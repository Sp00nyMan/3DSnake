package com.source.UserInterface;

import com.source.Main;
import com.source.UserInterface.Widgets.Button;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class MainMenu
{
	public static final int DistanceBetweenButtons = 30;
	public static final String title = "MAIN MENU";

	private Scene scene;
	private Camera camera = new PerspectiveCamera();
	private Group mainMenuGroup = new Group();

	public MainMenu(Group mainGroup)
	{
		VBox buttonsGroup = new VBox();

		Button PlayButton = new Button("START");
		StackPane PlayButtonPane = PlayButton.getStackPane();
		PlayButtonPane.setOnMouseClicked(mouseEvent -> System.out.println("START GAME!!!!!"));

		Button SettingsButton = new Button("SETTINGS");
		StackPane SettingsButtonPane = SettingsButton.getStackPane();
		SettingsButtonPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent)
			{
				System.out.println("SETTINGS");
			}
		});

		Button ExitButton = new Button("EXIT");
		ExitButton.changeBoxColor(Color.RED, Color.GREEN);
		ExitButton.changeTextColor(Color.GREEN, Color.RED);
		StackPane ExitButtonPane = ExitButton.getStackPane();
		ExitButtonPane.setOnMouseClicked(mouseEvent -> System.out.println("EXIT!!!!!"));

		buttonsGroup.getChildren().addAll(PlayButtonPane, SettingsButtonPane, ExitButtonPane);
		buttonsGroup.setSpacing(DistanceBetweenButtons);

		mainMenuGroup.getChildren().add(buttonsGroup);
		if(mainGroup == null)
			mainGroup = mainMenuGroup;
		else
			mainGroup.getChildren().add(mainMenuGroup);

		scene = new Scene(mainGroup, Main.WIDTH, Main.HEIGHT);
		scene.setFill(Color.SILVER);
		scene.setCamera(camera);
	}

	public Scene getScene()
	{
		return scene;
	}

	private void setEventHandler()
	{
		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent)
			{
				switch (keyEvent.getCode())
				{
					case A:
						mainMenuGroup.translateXProperty().set(mainMenuGroup.getTranslateX() - 1);
						break;
					case D:
						mainMenuGroup.translateXProperty().set(mainMenuGroup.getTranslateX() + 1);
						break;
					case S:
						mainMenuGroup.translateYProperty().set(mainMenuGroup.getTranslateY() + 1);
						break;
					case W:
						mainMenuGroup.translateYProperty().set(mainMenuGroup.getTranslateY() - 1);
						break;
				}
				System.out.println(mainMenuGroup.getTranslateX() + ", " + mainMenuGroup.getTranslateY());
			}
		});
	}

}
