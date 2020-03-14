package com.source.UserInterface.Widgets;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public abstract class Button
{
	public static final int ButtonWidth = 300;
	public static final int ButtonHeight = 80;
	public static final int ButtonDepth = 60;
	public static final Color DefaultColorText = Color.BLACK;
	public static final Color OnHoverText = Color.RED;
	public static final Color DefaultColorShape = Color.WHITE;
	public static final Color OnHoverShape = Color.BLUE;

	public static StackPane generateButton(StackPane buttonPane, String label)
	{
		Box shape = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
		shape.translateXProperty().set(1.3);

		Label text = new Label(label);
		text.setTextFill(Color.BLACK);

		buttonPane.getChildren().addAll(shape, text);
		buttonPane.setOnMouseEntered(mouseEvent -> {
			System.out.println("ENTERED");
			buttonPane.setScaleZ(0.5);
			shape.setMaterial(new PhongMaterial(OnHoverShape));
			text.setTextFill(OnHoverText);
		});
		buttonPane.setOnMouseExited(mouseEvent -> {
			System.out.println("EXITED\n\r");
			buttonPane.setScaleZ(1);
			shape.setMaterial(new PhongMaterial(DefaultColorShape));
			text.setTextFill(DefaultColorText);
		});
		return buttonPane;
	}

}
