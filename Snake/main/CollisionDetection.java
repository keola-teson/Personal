package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import apple.Apple;
import snake.SnakeHead;



public class CollisionDetection
{
	private SnakeHead snakeHead = new SnakeHead();;
	private Apple apple = new Apple();;

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
		
		if (snakeHead.hasCollided())
		{
			apple.setPosX((int)(Math.random() * GamePanel.getScreenWidth() / GamePanel.getTileSize()) * GamePanel.getTileSize());
			apple.setPosY((int)(Math.random() * GamePanel.getScreenWidth() / GamePanel.getTileSize()) * GamePanel.getTileSize());
			
			apple.setCollisionBox(new Rectangle(apple.getPosX(), apple.getPosY(), GamePanel.getTileSize(), GamePanel.getTileSize()));
		}
	}
	
	
	public void draw(Graphics2D g2)
	{
		apple.draw(g2);
	}
	
}
