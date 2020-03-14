package com.source;


import com.source.UserInterface.MainMenu;
import com.source.render.FieldRenderer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application
{
	private static final int WIDTH = (FieldRenderer.fieldSize) * (FieldRenderer.CellWidth + FieldRenderer.DistanceBetweenCells) + FieldRenderer.DistanceBetweenCells;
	private static final int HEIGHT = (FieldRenderer.fieldSize) * (FieldRenderer.CellHeight + FieldRenderer.DistanceBetweenCells) + FieldRenderer.DistanceBetweenCells;
	final Group MainGroup = new Group();

	public void start(Stage stage)
	{
		final VBox MainMenuGroup = new VBox();
		MainGroup.getChildren().add(MainMenu.addButtons(MainMenuGroup));
		MainMenuGroup.setSpacing(MainMenu.DistanceBetweenButtons);

		Scene scene = new Scene(MainGroup, WIDTH, HEIGHT);
		scene.setFill(Color.SILVER);
		Camera camera = new PerspectiveCamera();
		scene.setCamera(camera);

		stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event)
			{
				switch(event.getCode())
				{
					case A:
						MainGroup.translateXProperty().set(MainGroup.getTranslateX() - 1);
						break;
					case D:
						MainGroup.translateXProperty().set(MainGroup.getTranslateX() + 1);
						break;
					case S:
						MainGroup.translateYProperty().set(MainGroup.getTranslateY() + 1);
						break;
					case W:
						MainGroup.translateYProperty().set(MainGroup.getTranslateY() - 1);
						break;
				}
				System.out.println(MainGroup.getTranslateX() + ", " + MainGroup.getTranslateY());
			}
		});

		stage.setTitle("TEST");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args){
		launch(args);
	}

}