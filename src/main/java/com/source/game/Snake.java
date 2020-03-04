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
}
