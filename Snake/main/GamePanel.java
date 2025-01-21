package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serial;
import javax.swing.JPanel;

import apple.Apple;
import snake.Snake;

public class GamePanel extends JPanel implements Runnable
{
	@Serial
	private static final long serialVersionUID = 1L;
	
	private static final int screenWidth = 1280;
	private static final int screenHeight = 720;
	private static final int tileSize = 20;
	
	
	
	private final KeyHandler keyHandler = new KeyHandler();
	private final Snake snake = new Snake();
	
	private final Apple apple = new Apple();
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
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
		double drawInterval = (double)1000000000 / 25;
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
		}
		
	}
	
	public void update()
	{
		if (snake.getPosX() == apple.getPosX() && snake.getPosY() == apple.getPosY())
		{
			apple.randomizePosX();
			apple.randomizePosY();
			
			snake.setHasEaten(true);
		}
		snake.update(keyHandler);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		apple.draw(g2);
		snake.draw(g2);
		
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