package sorting;
import java.util.Arrays;

public class Sorting
{
	private String string;
	
	Sorting(String string)
	{
		this.string = string;
	}
	
	public String getString()
	{
		return string;
	}
	
	public int[] addIntToArray()
	{
		int[] array = new int[string.length()];
		
		for (int i = 0; i < string.length(); i++)
		{
			array[i] = Integer.parseInt(string.substring(i, i + 1));
		}
		
		return array;
	}
	
	public int[] addIntToArraySpace()
	{
		
		int spaceCount = 0;
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == ' ')
			{
				spaceCount++;
			}
		}
		
		int[] spaceIndexes = new int[spaceCount];
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == ' ')
			{
				for (int j = 0; j < spaceIndexes.length; j++)
				{
					if (spaceIndexes[j] == 0)
					{
						spaceIndexes[j] = i;
						break;
					}
				}
			}
		}
		
		int[] array = new int[spaceIndexes.length + 1];
		array[0] = Integer.parseInt(string.substring(0, array[0] + 1));
		for (int i = 0; i < spaceIndexes.length - 1; i++)
		{
			for (int j = 1; j < array.length - 1; j++)
			{
				if (array[j] == 0)
				{
					array[j] = Integer.parseInt(string.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]));
					break;
				}
			}
		}
		array[array.length - 1] = Integer.parseInt(string.substring(spaceIndexes[spaceIndexes.length - 1] + 1));
		System.out.println(Arrays.toString(array));
		
		System.out.println(Arrays.toString(spaceIndexes));
		
		return array;
	}
	
	public static int[] insertionSort(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int j = i;
			while (j > 0 && array[j] < array[j - 1])
			{
				int thisValue = array[j];
				int lastValue = array[j - 1];
				
				array[j] = lastValue;
				array[j - 1] = thisValue;
				
				j--;
			}
		}
		
		return array;
	}
	
	
}
