package threadsTest;

import java.util.concurrent.TimeUnit;

public class ThreadTest
{
	public static boolean bool;
	
	public static void main(String[] args)
	{	
		Multithreading thing = new Multithreading();
		Thread thread = new Thread(thing);
		thread.start();
		
		
		
	}
}