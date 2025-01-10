package main;

import apple.Apple;
import snake.SnakeHead;



public class CollisionDetection
{
	private SnakeHead snakeHead;
	private Apple apple;
	
	public CollisionDetection()
	{
		
		this.snakeHead = new SnakeHead();
		this.apple = new Apple();
		
	}

	public void detectAppleCollision()
	{
		
		int[][] sHVertices = {
				{snakeHead.getPosX(), snakeHead.getPosY()}, 
				{snakeHead.getPosX(), snakeHead.getPosY() + GamePanel.getTileSize()}, 
				{snakeHead.getPosX() + GamePanel.getTileSize(), snakeHead.getPosY()}, 
				{snakeHead.getPosX() + GamePanel.getTileSize(), snakeHead.getPosY() + GamePanel.getTileSize()}};
		
		if (sHVertices[0][0] == apple.getVertices()[0][0] && sHVertices[0][1] == apple.getVertices()[0][1])
		{
			snakeHead.setHasCollided(true);
		}
		else if (sHVertices[1][0] == apple.getVertices()[1][0] && sHVertices[1][1] == apple.getVertices()[1][1])
		{
			snakeHead.setHasCollided(true);
		}
		else if (sHVertices[2][0] == apple.getVertices()[2][0] && sHVertices[2][1] == apple.getVertices()[2][1])
		{
			snakeHead.setHasCollided(true);
		}
		else if (sHVertices[2][0] == apple.getVertices()[2][0] && sHVertices[2][1] == apple.getVertices()[2][1])
		{
			snakeHead.setHasCollided(true);
		}
		
	}
	
}
