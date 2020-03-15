package com.source;


import com.source.UserInterface.MainMenu;
import com.source.render.FieldRenderer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;


public class Main extends Application
{
	public static final int WIDTH = (FieldRenderer.fieldSize) * (FieldRenderer.CellWidth + FieldRenderer.DistanceBetweenCells) + FieldRenderer.DistanceBetweenCells;
	public static final int HEIGHT = (FieldRenderer.fieldSize) * (FieldRenderer.CellHeight + FieldRenderer.DistanceBetweenCells) + FieldRenderer.DistanceBetweenCells;
	final Group MainGroup = new Group();

	public void start(Stage stage)
	{

		stage.setResizable(false);

/*
		final Group FieldGroup = new Group();
		MainGroup.getChildren().add(FieldRenderer.addField(FieldGroup));
*/

		MainMenu mainMenu = new MainMenu(MainGroup);

		stage.setScene(mainMenu.getScene());
		stage.setTitle(MainMenu.title);
		stage.show();
	}

	public static void main(String[] args){
		launch(args);
	}

}