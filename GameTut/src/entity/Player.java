package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.*;

public class Player extends Entity
{
	private GamePanel gp;
	private KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	
	public Player(GamePanel gp, KeyHandler keyH)
	{
		this.gp = gp;
		this.keyH = keyH;
		
		//centers the player in the screen
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		collisionArea = new Rectangle();
		collisionArea.x = 8;
		collisionArea.y = 16;
		collisionArea.width = 32;
		collisionArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues()
	{
		posX = gp.tileSize * 23;
		posY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage()
	{
		try
		{
			up1 = ImageIO.read(getClass().getResource("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResource("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResource("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResource("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResource("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResource("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResource("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResource("/player/boy_right_2.png"));
			
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public void update()
	{
		if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
		{	
			if (keyH.upPressed == true)
			{
				direction = "up";
			}
			else if (keyH.downPressed == true)
			{
				direction = "down";
			}
			else if (keyH.leftPressed == true)
			{
				direction = "left";
			}
			else if (keyH.rightPressed == true)
			{
				direction = "right";
			}
			
			// CHECK TILE COLLISION
			isColliding = false;
			gp.collisionCheck.checkTile(this);
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (isColliding == false)
			{
				switch (direction)
				{
					case "up":
						posY -= speed;
						break;
						
					case "down":
						posY += speed;
						break;
						
					case "left":
						posX -= speed;
						break;
						
					case "right":
						posX += speed;
						break;
				}
			}
			
			spriteCounter++;
			if (spriteCounter > 12)
			{
				if (spriteNum == 1)
				{
					spriteNum = 2;
				}
				else if (spriteNum == 2)
				{
					spriteNum = 1;
				}
				
				spriteCounter = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2)
	{
		BufferedImage image = null;
		
		switch(direction)
		{
			case "up":
				if (spriteNum == 1)
				{
					image = up1;
				}
				if (spriteNum == 2)
				{
					image = up2;
				}
				break;
				
			case "down":
				if (spriteNum == 1)
					image = down1;
				
				if (spriteNum == 2)
					image = down2;
				break;
				
			case "left":
				if (spriteNum == 1)
				{
					image = left1;
				}
				if (spriteNum == 2)
				{
					image = left2;
				}
				break;
				
			case "right":
				if (spriteNum == 1)
				{
					image = right1;
				}
				if (spriteNum == 2)
				{
					image = right2;
				}
				break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
