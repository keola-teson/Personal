package snake;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.KeyHandler;

public abstract class Snake
{
	protected int posX;
	protected int posY;
	protected final int size = GamePanel.getTileSize(); //the size of the snake nodes
	protected final int speed = size; //how many pixels each object moves
	
	protected boolean hasCollided;
	protected Rectangle collisionBox;
	
	protected abstract void update(KeyHandler keyHandler);
	protected abstract void draw(Graphics2D g2);
	
	protected abstract void detectCollision();
}
