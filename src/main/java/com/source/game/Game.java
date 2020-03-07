package com.source.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener
{
	public static final int fieldSize = 15;
	private Snake snake = new Snake(fieldSize);
	private boolean isGameRunning = false;
	private Directions newDirection = null;
	private Food food;

	private boolean gameCycle(){
		if(snake.isAteAllFood)
			food = new Food(fieldSize, snake);
		isGameRunning = snake.update(fieldSize, food, newDirection);
		newDirection = null;
		if(!isGameRunning)
			if(snake.isAlive)
				System.out.println("WON!");
			else
				System.out.println("LOST(");
//Отрисовку и вызов данного метода на себя должен взять рендерер или отдельный управляющий класс
		return isGameRunning;
	}

	private static Directions getDirectionByKey(int keyCode){
		switch (keyCode)
		{
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:
				return Directions.up;
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:
				return Directions.down;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:
				return Directions.left;
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:
				return Directions.right;
		}
		return null;
	}
	public void keyPressed(KeyEvent keyEvent){
		newDirection = getDirectionByKey(keyEvent.getKeyCode());
	}

	public void keyTyped(KeyEvent keyEvent){}
	public void keyReleased(KeyEvent keyEvent){

	}
}
