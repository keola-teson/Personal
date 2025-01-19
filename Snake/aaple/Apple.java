package apple;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public class Apple
{
	private int posX;
	private int posY;
	
	private int size = GamePanel.getTileSize();
	
	private Rectangle collisionBox;
	
	public void setDefaultValues(int posX, int posY, Rectangle collisionBox)
	{
		this.posX = posX;
		this.posY = posY;
		
		this.collisionBox = collisionBox;
	}
	
	public void draw(Graphics2D g2)
	{	
		g2.setColor(Color.RED);
		g2.fill(collisionBox);
	}
	
	public int[][] getVertices()
	{	
		int[][] vertices = {
				{posX, posY}, 
				{posX, posY + size}, 
				{posX + size, posY}, 
				{posX + size, posY + size}};
		
		return vertices;
	}
	
	public Rectangle getCollisionBox()
	{
		return collisionBox;
	}
	
	public void setCollisionBox(Rectangle collisionBox)
	{
		this.collisionBox = collisionBox;
	}
	
	public int getPosX()
	{
		
		return posX;
		
	}
	
	public int getPosY()
	{
		
		return posY;
		
	}
	
	public void setPosX(int posX)
	{
		
		this.posX = posX;
		
	}

	public void setPosY(int posY)
	{
		
		this.posY = posY;
		
	}
	
	
}
