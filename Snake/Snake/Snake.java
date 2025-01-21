package snake;

import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import main.GamePanel;
import main.KeyHandler;

public class Snake
{
	private boolean hasEaten;
	
	private int posX;
	private int posY;
	
	private final int size = GamePanel.getTileSize(); //the size of the snake nodes
	private final int speed = size; //how many pixels each object moves
	
	private int bodyCount = 0;
	private final HashMap<Integer, Integer> bodyLocations = new HashMap<>();
	
	public Snake()
	{
		posX = speed;
		posY = GamePanel.getScreenHeight() / 2;
	}
	
	public void update(KeyHandler keyHandler)
	{
		if (hasEaten)
		{
			bodyCount++;
			
			hasEaten = false;
		}
		
		if (keyHandler.isUp())
		{
			posY -= speed;
		}
		else if (keyHandler.isDown())
		{
			posY += speed;
		}
		else if (keyHandler.isLeft())
		{
			posX -= speed;

		}
		else if (keyHandler.isRight())
		{
			posX += speed;
		}
	}
	
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.GREEN);
		g2.fillRect(posX, posY, size, size);
		
		for (int i = 0; i < 5; i++)
		{
			g2.fillRect(posX - (i * 20), posY, size, size);
        }
	}
	
	public int getPosX() { return posX; }
	public int getPosY() { return posY; }
	
	public void setHasEaten(boolean hasEaten) { this.hasEaten = hasEaten; }
}
