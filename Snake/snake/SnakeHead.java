package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import apple.Apple;
import main.GamePanel;
import main.KeyHandler;

public class SnakeHead extends Snake
{	
	private Apple apple = new Apple();
	
	public SnakeHead()
	{
		posX = speed;
		posY = GamePanel.getScreenHeight() / 2;
		
		collisionBox = new Rectangle(posX, posY, size, size);
	}
	
	@Override
	public void update(KeyHandler keyHandler)
	{
		if (keyHandler.up)
		{
			posY -= speed;
			collisionBox.y = posY;
		}
		else if (keyHandler.down)
		{
			posY += speed;
			collisionBox.y = posY;
		}
		else if (keyHandler.left)
		{
			posX -= speed;
			collisionBox.x = posX;
		}
		else if (keyHandler.right)
		{
			posX += speed;
			collisionBox.x = posX;
		}
		else
		{
			//System.out.println("No key pressed.");
		}
		
		detectCollision();
	}

	@Override
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.GREEN);
		g2.fillRect(posX, posY, size, size);
		
		g2.draw(collisionBox);
	}

	@Override
	public void detectCollision()
	{
		int[][] sHVertices = {
				{posX, posY}, 
				{posX, posY + size}, 
				{posX + size, posY}, 
				{posX + size, posY + size}};
		
		if (sHVertices[0][0] == apple.getVertices()[0][0] && sHVertices[0][1] == apple.getVertices()[0][1])
		{
			hasCollided = true;
		}
		else if (sHVertices[1][0] == apple.getVertices()[1][0] && sHVertices[1][1] == apple.getVertices()[1][1])
		{
			hasCollided = true;
		}
		else if (sHVertices[2][0] == apple.getVertices()[2][0] && sHVertices[2][1] == apple.getVertices()[2][1])
		{
			hasCollided = true;
		}
		else if (sHVertices[2][0] == apple.getVertices()[2][0] && sHVertices[2][1] == apple.getVertices()[2][1])
		{
			hasCollided = true;
		}
	}
	
	public boolean hasCollided()
	{
		return hasCollided;
	}

	public void setHasCollided(boolean hC)
	{
		hasCollided = hC;
	}
	
	
	public int getPosX()
	{
		
		return posX;
		
	}
	
	
	public int getPosY()
	{
		
		return posY;
		
		
	}
}
