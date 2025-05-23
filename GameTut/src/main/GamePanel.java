package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable
{
	// SCREEN SETTINGS
	private final int originalTileSize = 16; // 16x16 tile
	private final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	// FPS
	private final int constant = 60;
	
	public TileManager tileM = new TileManager(this);
	private KeyHandler keyH = new KeyHandler();
	private Thread gameThread;
	public CollisionCheck collisionCheck = new CollisionCheck(this);
	public Player player = new Player(this, keyH);
	
	
	public GamePanel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread()
	{
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run()
	{
		double drawInterval = 1000000000/constant; // 0.01667 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		// FPS counter
		long timer = 0;
		int drawCount = 0;
		
		
		while (gameThread != null)
		{
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
			
			if (delta >= 1)
			{
				// 1 UPDATE: update information such as character position
				update();
				
				// 2 DRAW: draw the screen with the update information
				repaint();
				
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000)
			{
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update()
	{
		player.update();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		player.draw(g2);
		
		g2.dispose();
	}
}
