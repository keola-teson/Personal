import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class arraytest
{
	public static void main(String[] args)
	{
		HashMap<Integer, String> hashmap = new HashMap<>();
		hashmap.put(1, "a");
		hashmap.put(2, "b");
		hashmap.put(3, "c");
		hashmap.put(4, "d");
		
		for (int i : hashmap.keySet())
		{
			System.out.println(i + ": " + hashmap.get(i));
		}
		
		
		/*
		String[] wordleWords = {"HALVE", "SHELL", "PRONE", "STAIN", "MOMMY", "JOINT", "STERN", "MODEM"};
		int randomGenerator = (int)(Math.random() * wordleWords.length);
		String randomWords = wordleWords[randomGenerator];
		
		System.out.println(randomGenerator);
		System.out.println(randomWords);
		
		
		Scanner scanner = new Scanner(System.in);
		
		int[] arrayOne = {1, 2, 3, 4, 5};
		int[] arrayTwo = {2, 4, 6, 8, 10};
		int[] arrayThree = {3, 6, 9, 12, 15};
		ArrayList<Integer> arraylist = new ArrayList<>();
		
		for(int i = 0; i < 5; i++)
		{
		
		String input = scanner.nextLine();;
		boolean goodInput = false;
		while (!goodInput)
		{	
			try
			{
				Integer.parseInt(input);
				goodInput = true;
			}
			catch (Exception e)
			{
				System.out.println("Please input a valid number");
				input = scanner.nextLine();
			}
		}
		if (arraylist.equals(Integer.parseInt(input)))
		{
			
		}
		
		
		arraylist.add(Integer.parseInt(input));
		
		System.out.println(Arrays.toString(arrayOne));
		System.out.println(Arrays.toString(arrayTwo));
		System.out.println(Arrays.toString(arrayThree));
		
		System.out.print("\n");
		
		System.out.println(arraylist.toString());
		}
		
		scanner.close();
		*/
	}
}
