package apple;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;

public class Apple
{
	private int posX;
	private int posY;
	
	private final int size = GamePanel.getTileSize();
	
	public Apple()
	{
		posX = 1240;
		posY = GamePanel.getScreenHeight() / 2;
	}
	
	public void draw(Graphics2D g2)
	{
		g2.setColor(Color.RED);
		g2.fillRect(posX, posY, size, size);
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public void randomizePosX()
	{
		this.posX = (int)(Math.random() * GamePanel.getScreenWidth());
		if (posX % size != 0)
		{
			randomizePosX();
		}
	}
	
	public void randomizePosY()
	{
		this.posY = (int)(Math.random() * GamePanel.getScreenHeight());
		if (posY % size != 0)
		{
			randomizePosY();
		}
	}
}