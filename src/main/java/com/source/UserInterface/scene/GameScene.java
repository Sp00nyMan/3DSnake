package com.source.UserInterface.scene;

import com.source.Main;
import com.source.game.Field;
import com.source.game.Game;
import com.source.render.SnakeRenderer;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class GameScene implements EventHandler<KeyEvent>
{
	private Scene scene;
	private Game game = new Game();

	private Group gameGroup;
	private Group snake = new Group();

	private AnimationTimer gameTimer = new AnimationTimer() {
		private long lastUpdate = 0;
		@Override
		public void handle(long l)
		{
			if(!paused && l - lastUpdate >= 300 * 1_000_000)
			{
				if (!game.gameCycle())
				{
					renderTimer.stop();
					this.stop();
				}
				lastUpdate = l;
			}
		}

		@Override
		public void start()
		{
			super.start();
		}
	};
	private AnimationTimer renderTimer = new AnimationTimer() {
		private long lastUpdate = 0;
		@Override
		public void handle(long l)
		{
			if(!paused)
			{
				snake.getChildren().clear();
				snake.getChildren().add(SnakeRenderer.getFood(game.getFood()));
				snake.getChildren().add(SnakeRenderer.getSnake(game.getSnake().getBody()));
			}
		}
	};

	private boolean paused = false;

	public GameScene()
	{
		gameGroup = new Group();
		gameGroup.getChildren().add(Field.getField());
		gameGroup.getChildren().add(snake);

		Camera camera = new PerspectiveCamera();

		scene = new Scene(gameGroup, Main.WIDTH, Main.HEIGHT);
		scene.setFill(Game.BGCOLOR);
		scene.setCamera(camera);
		scene.addEventHandler(KeyEvent.KEY_PRESSED, this);
	}

	public Scene getScene()
	{
		return scene;
	}
	public void start()
	{
		renderTimer.start();
		gameTimer.start();
	}

	@Override
	public void handle(KeyEvent keyEvent)
	{
		switch (keyEvent.getCode())
		{
			case ESCAPE:
				if(!paused)
				{
					Rectangle rect = new Rectangle(0,0,Main.WIDTH, Main.HEIGHT);
					rect.setFill(Color.GRAY);
					rect.setOpacity(0.5);
					gameGroup.getChildren().add(rect);
				}
				else
					gameGroup.getChildren().remove(gameGroup.getChildren().size() - 1);
				paused = !paused;
				break;
			default:
				game.setNewDirection(Game.getDirectionByKey(keyEvent.getCode()));
				break;
		}
	}
}
