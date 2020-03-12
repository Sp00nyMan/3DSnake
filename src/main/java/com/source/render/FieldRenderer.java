package com.source.render;


import javafx.scene.Group;
import javafx.scene.shape.Box;

public class FieldRenderer extends Renderer
{
	public static final int fieldSize = 15;
	public static final int CellWidth = 30;
	public static final int CellHeight = 30;
	public static final int CellLength = 15;
	public static final int DistanceBetweenCells = 4;

	public static void addField(Group group)
	{
		for (int i = 0; i < fieldSize; i++)
		{
			for (int j = 0; j < fieldSize; j++)
			{
				Box cell = new Box(CellWidth, CellHeight, CellLength);
				cell.translateXProperty().set(i * (CellWidth + DistanceBetweenCells));
				cell.translateYProperty().set(j * (CellHeight + DistanceBetweenCells));
				group.getChildren().add(cell);
			}
		}
	}
}
