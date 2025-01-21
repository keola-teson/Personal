package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
	private boolean up, down, left, right;
	

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W)
		{
			up = true;
			down = false;
			left = false;
			right = false;
		}
		if (code == KeyEvent.VK_S)
		{
			up = false;
			down = true;
			left = false;
			right = false;
		}
		if (code == KeyEvent.VK_A)
		{
			up = false;
			down = false;
			left = true;
			right = false;
		} 
		if (code == KeyEvent.VK_D)
		{
			up = false;
			down = false;
			left = false;
			right = true;
		}
	}
	
	public boolean isUp()
	{
		return up;
	}
	
	public boolean isDown()
	{
		return down;
	}
	
	public boolean isLeft()
	{
		return left;
	}
	
	public boolean isRight()
	{
		return right;
	}
}
