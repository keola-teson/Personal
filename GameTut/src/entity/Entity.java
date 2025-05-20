package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity
{
	//entity position in the world
	public int posX, posY;
	public int speed;
	
	//objects used to load entity textures
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	//decides which sprite texture gets used
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	//collision
	public Rectangle collisionArea;
	public boolean isColliding;
}
