package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import apple.Apple;
import snake.SnakeHead;

public class GamePanel extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	private static final int screenWidth = 1278;
	private static final int screenHeight = 720;
	
	private static final int tileSize = 18;
	
	private KeyHandler keyHander = new KeyHandler();
	private SnakeHead snakeHead = new SnakeHead();
	private Apple apple = new Apple();
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHander);
		this.setFocusable(true);
		
		apple.setDefaultValues(1224, GamePanel.getScreenHeight() / 2, new Rectangle(1224, GamePanel.getScreenHeight() / 2, tileSize, tileSize));
	}
	
	Thread thread = new Thread();
	
	public void startGameThread()
	{
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		double delta = 0;
		double drawInterval = (double)1000000000 / 30;
		long currentTime;
		
		while (thread.isAlive())
		{
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			
			lastTime = currentTime;
			
			if (delta >= 1)
			{
				update();
				repaint();
				
				delta--;
			}
			
			snakeHead.detectCollision();
		}
		
	}
	
	public void update()
	{
		apple.update();
		snakeHead.update(keyHander);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		apple.draw(g2);
		snakeHead.draw(g2);
		
		g2.dispose();
	}
	
	public static int getScreenWidth()
	{
		return screenWidth;
	}
	
	public static int getScreenHeight()
	{
		return screenHeight;
	}

	public static int getTileSize()
	{
		return tileSize;
	}
	
	
}
