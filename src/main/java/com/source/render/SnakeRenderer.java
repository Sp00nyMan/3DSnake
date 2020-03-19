package com.source.render;

import com.source.game.Field;
import com.source.game.Food;
import com.source.game.Snake;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

import java.util.ArrayList;

public abstract class SnakeRenderer
{
	private static final float scale = 1f;

	public static final float partWidth = Field.CellWidth * scale;
	public static final float partHeight = Field.CellHeight * scale;
	public static final float partLength = Field.CellLength * scale * 3;

	public static final Color partColor = Color.GREEN;
	public static final Color foodColor = Color.RED;
	public static final Color headColor = Color.YELLOW;

	public static Group getSnake(ArrayList<Snake.BodyPart> body)
	{
		Group group = new Group();
		{
			Box part = getPart(body.get(0).x, body.get(0).y);
			part.setMaterial(new PhongMaterial(headColor));
			group.getChildren().add(part);
		}
		for (int i = 1; i < body.size(); i++)
		{
			Box part = getPart(body.get(i).x, body.get(i).y);
			part.setMaterial(new PhongMaterial(partColor));
			group.getChildren().add(part);
		}
		return group;
	}
	private static Box getPart(float x, float y)
	{
		Box part = new Box(partWidth, partHeight, partLength);
		part.translateXProperty().set((Field.CellWidth + Field.DistanceBetweenCells) * x + Field.CellWidth / 2);
		part.translateYProperty().set((Field.CellHeight + Field.DistanceBetweenCells) * y + Field.CellWidth / 2);
		return part;
	}
	public static Group getFood(Food food)
	{
		Group group = new Group();
		if (food != null){
			Box f = getPart(food.x, food.y);
			f.setMaterial(new PhongMaterial(foodColor));
			group.getChildren().add(f);
		}
		return group;
	}
}
