package com.source.UserInterface.Widgets;

import javafx.scene.control.TextArea;
import javafx.scene.shape.Box;

public class Button
{
	private double x;
	private double y;
	public static final int ButtonWidth = 300;
	public static final int ButtonHeight = 80;
	public static final int ButtonDepth = 10;
	Box shape;
	TextArea text;
	public Button(double x, double y, String label)
	{
		text = new TextArea(label);
		shape = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		shape.translateXProperty().set(x);
		shape.translateYProperty().set(y);
		shape.setAccessibleText(label);
		text.translateXProperty().set(x);
		text.translateYProperty().set(y);
		this.x = x;
		this.y = y;
	}
}
