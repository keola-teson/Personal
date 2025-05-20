package finding;

import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		int[] numArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		
		algo1(11, numArray);
		algo2(6, numArray);
	}
	
	public static void algo1(int num, int[] array)
	{
		int i = 0;
		
		for (int element : array)
		{
			if (element == num)
			{
				System.out.println("Index of " + num + " is " + i);
				return;
			}
			i++;
		}
	}
	
	public static void algo2(int num, int[] array)
	{
		int middle = array[array.length / 2];
		System.out.println(middle);
		
		if (middle == num)
		{
			System.out.println("Index of " + num + " is " + (array.length / 2));
			return;
		}
		else if (middle > num)
		{
			int[] halvedArray = copyArray(0, array.length / 2, array);
			algo2(num, array, halvedArray);
		}
		else if (middle < num)
		{
			int[] halvedArray = copyArray(array.length / 2, array.length - 1, array);
			algo2(num, array, halvedArray);
		}
	}
	
	private static int[] copyArray(int startingIndex, int endingIndex, int[] array)
	{
		int[] copy = new int[(endingIndex - startingIndex) + 1];
		
		for (int i = startingIndex; i <= endingIndex; i++)
		{
			copy[i - startingIndex] = array[i];
		}
		
		return copy;
	}
	
	private static void algo2(int num, int[] array, int[] array2)
	{
		int middle = array[array.length / 2];
		System.out.println(middle);
		
		if (middle == num)
		{
			System.out.println("Index of " + num + " is " + (array.length / 2));
			return;
		}
		else if (middle > num)
		{
			int[] halvedArray = copyArray(0, array2.length / 2, array2);
			algo2(num, array, halvedArray);
		}
		else if (middle < num)
		{
			int[] halvedArray = copyArray(array2.length / 2, array2.length - 1, array2);
			algo2(num, array, halvedArray);
		}
	}
}
