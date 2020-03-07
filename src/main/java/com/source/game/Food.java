package com.source.game;

import java.util.Random;

public class Food
{
	float x;
	float y;

	public Food(int fieldSize, Snake snake)
	{
		Random random = new Random(System.currentTimeMillis());

		do{
			this.x = random.nextInt(fieldSize);
			this.y = random.nextInt(fieldSize);
		}while(snake.contains(this));
	}
}
