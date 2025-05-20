package main;

import entity.Entity;

public class CollisionCheck
{
	GamePanel gp;
	
	public CollisionCheck(GamePanel gp)
	{
		this.gp = gp;
	}
	
	public void checkTile(Entity entity)
	{
		int entityLeftPosX = entity.posX + entity.collisionArea.x;
		int entityRightPosX = entity.posX + entity.collisionArea.x + entity.collisionArea.width;
		int entityTopPosY = entity.posY + entity.collisionArea.y;
		int entityBottPosY = entity.posY + entity.collisionArea.y + entity.collisionArea.height;
		
		int entityLeftCol = entityLeftPosX / gp.tileSize;
		int entityRightCol = entityRightPosX / gp.tileSize;
		int entityTopRow = entityTopPosY / gp.tileSize;
		int entityBottRow = entityBottPosY / gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch (entity.direction)
		{
			case "up":
				entityTopRow = (entityTopPosY - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
				{
					entity.isColliding = true;
				}
				break;
				
			case "down":
				entityBottRow = (entityBottPosY + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottRow];
				if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
				{
					entity.isColliding = true;
				}
				break;
				
			case "left":
				entityLeftCol = (entityLeftPosX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottRow];
				if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
				{
					entity.isColliding = true;
				}
				break;
				
			case "right":
				entityRightCol = (entityRightPosX + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottRow];
				if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
				{
					entity.isColliding = true;
				}
				break;
		}
	}
}
