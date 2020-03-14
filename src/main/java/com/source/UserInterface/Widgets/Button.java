package com.source.UserInterface.Widgets;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;

public abstract class Button
{
	public static final int ButtonWidth = 300;
	public static final int ButtonHeight = 80;
	public static final int ButtonDepth = 10;

	public static Group generateButton(Group buttonGroup, String label)
	{
		Box shape = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		shape.translateXProperty().set(ButtonWidth / 2 + 1.3);
		shape.translateYProperty().set(13.3);

		Text text = new Text(label);
		text.translateXProperty().set(shape.getWidth() / 2 - text.getWrappingWidth() / 2);
		text.translateYProperty().set(shape.getHeight() / 2 - text.getLayoutBounds().getHeight() / 2);
		text.setFill(Color.BLACK);

		buttonGroup.getChildren().addAll(shape, text);
		return buttonGroup;
	}

}
