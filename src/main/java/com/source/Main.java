package com.source;


import com.source.controllers.MainController;
import com.source.game.Field;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application
{
	public static final int WIDTH = (Field.fieldSize) * (Field.CellWidth + Field.DistanceBetweenCells) + Field.DistanceBetweenCells;
	public static final int HEIGHT = (Field.fieldSize) * (Field.CellHeight + Field.DistanceBetweenCells) + Field.DistanceBetweenCells;

	public void start(Stage stage)
	{
		new MainController(stage);
	}

	public static void main(String[] args){
		launch(args);
	}
}