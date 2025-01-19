package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.KeyHandler;

public class SnakeHead extends Snake
{
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
	}

	@Override
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.GREEN);
		g2.fillRect(posX, posY, size, size);
		
		g2.draw(collisionBox);
	}

	@Override
	public void detectCollision() {}
	
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
