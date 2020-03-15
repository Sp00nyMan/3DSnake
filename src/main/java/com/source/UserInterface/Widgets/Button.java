package com.source.UserInterface.Widgets;

import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;

public class Button
{
	public static final int ButtonWidth = 300;
	public static final int ButtonHeight = 80;
	public static final int ButtonDepth = 60;
	public Color DefaultColorText = Color.BLACK;
	public Color OnHoverText = Color.RED;
	public Color DefaultColorShape = Color.WHITE;
	public Color OnHoverShape = Color.SILVER;
	public static final Font textFont = new Font("Consolas", 40);
	private Box shape = new Box(ButtonWidth, ButtonHeight, ButtonDepth);
	private Label text = new Label();
	private StackPane pane = new StackPane();

	public Button(String label)
	{
		shape.translateXProperty().set(1.3);

		text.setText(label);
		text.setFont(textFont);
		text.setTextFill(Color.BLACK);
		text.setEffect(new Glow(0.6));
		pane.getChildren().addAll(shape, text);
		pane.setOnMouseEntered(mouseEvent -> {
			pane.setScaleZ(0.5);

			shape.setMaterial(new PhongMaterial(OnHoverShape));
			text.setTextFill(OnHoverText);
		});
		pane.setOnMouseExited(mouseEvent -> {
			pane.setScaleZ(1);

			shape.setMaterial(new PhongMaterial(DefaultColorShape));
			text.setTextFill(DefaultColorText);
		});
	}
	public StackPane getStackPane()
	{
		return pane;
	}
	public void changeTextColor(Color Default, Color OnHover)
	{
		DefaultColorText = Default;
		OnHoverText = OnHover;
		text.setTextFill(DefaultColorText);
	}
	public void changeBoxColor(Color Default, Color OnHover)
	{
		DefaultColorShape = Default;
		OnHoverShape = OnHover;
		shape.setMaterial(new PhongMaterial(DefaultColorShape));
	}
}
