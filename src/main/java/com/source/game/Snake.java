package com.source.game;

import java.util.ArrayList;

public class Snake
{
	private class BodyPart
	{
		private int x;
		private int y;
		private int z;

		public BodyPart(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public void move(int xOffset, int yOffset)
		{
			this.x += xOffset;
			this.y += yOffset;
		}
		public void move(BodyPart other)
		{
			this.x = other.x;
			this.y = other.y;
		}
		public boolean equals(BodyPart other)
		{
			if(this.x == other.x && this.y == other.y)
				return true;
			return false;
		}
/*		public boolean equals(Food food)
		{
			if(this.x == food.x && this.y == food.y)
				return true;
			return false;
		}*/
	}

	public static final int START_LENGTH = 4;
	private ArrayList<BodyPart> body = new ArrayList<BodyPart>(START_LENGTH);
	private Directions direction = Directions.left;
	private boolean isAlive = true;
	private boolean isAteAllFood = true;

	public Snake(int fieldSize)
	{
		int xOffset = 0, yOffset = 0;
		switch (direction)
		{
			case up:
				yOffset = 1;
				break;
			case down:
				yOffset = -1;
				break;
			case left:
				xOffset = 1;
				break;
			case right:
				xOffset = -1;
				break;
		}

		for (int i = 0; i < START_LENGTH; i++)
		{
			int BPx = fieldSize / 2 + xOffset * i - 1;
			int BPy = fieldSize / 2 + yOffset * i - 1;
			body.add(new BodyPart(BPx, BPy));
		}
	}
	private void move(BodyPart head, Directions direction)
	{
		int xOffset = 0, yOffset = 0;
		if(direction == null)
			direction = this.direction;
		switch (direction)
		{
			case up:
				if(this.direction == Directions.down) //Tried to move up while moving down
				{
					direction = Directions.down;
					yOffset = 1;
				}
				else
					yOffset = -1;
				break;
			case down:
				if(this.direction == Directions.up) //Tried to move down while moving up
				{
					direction = Directions.up;
					yOffset = -1;
				}
				else
					yOffset = 1;
				break;
			case left:
				if(this.direction == Directions.right) //Tried to move left while moving right
				{
					direction = Directions.right;
					xOffset = 1;
				}
				else
					xOffset = -1;
				break;
			case right:
				if(this.direction == Directions.left) //Tried to move right while moving left
				{
					direction = Directions.left;
					xOffset = -1;
				}
				else
					xOffset = 1;
				break;
		}
		this.direction = direction;
		head.move(xOffset, yOffset);
	}
	private boolean collidedAWall(int fieldSize, BodyPart head)
	{
		/*	Код для телепортации при входе в стену
			if(head.x < 0)
				head.move(new BodyPart((int) fieldSize - 1, head.y));
			else if (head.x >= fieldSize)
				head.move(new BodyPart(0, head.y));
			else if (head.y < 0)
				head.move(new BodyPart(head.x, (int) fieldSize - 1));
			else if (head.y >= fieldSize)
				head.move(new BodyPart(head.x, 0));
		*/
		if (head.x < 0 || head.x >= fieldSize || head.y < 0 || head.y >= fieldSize)
			return true;
		return false;
	}
	private boolean collidedItself(BodyPart head)
	{
		for (int i = 4; i < body.size(); i++)
		{
			if(head.equals(body.get(i)))
				return true;
		}
		return false;
	}
	private void moveSnake(BodyPart newHead)
	{
		for (int i = body.size() - 1; i > 0; i--)
			body.get(i).move(body.get(i - 1));
		body.get(0).move(newHead);
	}
	public boolean contains(Food food)
	{
		for (BodyPart bodyPart : body)
			if(bodyPart.equals(food)) //TODO добавить метод equals
				return true;
		return false;
	}

}