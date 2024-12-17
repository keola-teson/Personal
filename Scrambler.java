
/**
 * This a personal project I made because I wanted to try my hand at a scrambler
 * This class uses arrays to seperate each word and scramble them individually
 * Each method builds on another
 * @author Keola Teson :)
 */
import java.util.Arrays;

public class Scrambler
{

	public static void main(String[] args)
	{
		System.out.println(scrambleSentence("I am a sentence to scramble."));
		System.out.println(scrambleText("This is a sentence to scramble. This has an exclamation point! Does this have a question mark?"));
	}
	
	public static int[] findIndexes(String string, char character)
	{
		int count = 0;
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == character)
			{
				count++;
			}
		}
		
		int[] indexes = new int[count];
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == character)
			{
				for (int j = 0; j < indexes.length; j++)
				{
					if (indexes[j] == 0)
					{
						indexes[j] = i;
						break;
					}
				}
			}
		}
		
		return indexes;
	}
	
	public static int[] mergeArrays(int[] array1, int[] array2)
	{
		//creates the mergedArray
		int[] mergedArray = new int[array1.length + array2.length];
		
		/*
		 * for-each item in the first passed array
		 * - add that value and a space to string1
		 * for-each item in the second passed array
		 * - add that value and a space to string2
		 * combines string1 and string2 into one string
		 */
		String string1 = "";
		for (int i : array1)
		{
			string1 += i + " ";
		}
		String string2 = "";
		for (int i : array2)
		{
			string2 += i + " ";
		}
		String string = string1 + string2;
		
		/*
		 * calls findIndexes() method to find the indexes of every space inside of the merged string
		 * parses each number in the string into an int and stores it into the mergedArray created at the beginning of the method
		 */
		int[] spaceIndexes = findIndexes(string, ' ');
		mergedArray[0] = Integer.parseInt(string.substring(0, mergedArray[0] + 2));
		for (int i = 0; i < spaceIndexes.length - 1; i++)
		{
			for (int j = 1; j < mergedArray.length - 1; j++)
			{
				if (mergedArray[j] == 0)
				{
					mergedArray[j] = Integer.parseInt(string.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]));
					break;
				}
			}
		}
		mergedArray[mergedArray.length - 1] = Integer.parseInt(string.substring(spaceIndexes[spaceIndexes.length - 2] + 1, spaceIndexes[spaceIndexes.length - 1]));
		
		//returns the merged array
		return mergedArray;
	}
	
	public static void scrambleArray(Object[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int randomIndex = (int)(Math.random() * array.length);
			Object randomItem = array[randomIndex];
			Object currentItem = array[i];
			
			array[i] = randomItem;
			array[randomIndex] = currentItem;
		}
	}
	
	public static String scrambleWord(String string)
	{
		String temp = string;
		string = "";
		
		while(temp.length() > 0)
		{
			int randomizer = (int)(Math.random() * temp.length());
			string += temp.charAt(randomizer);
			temp = temp.substring(0, randomizer) + temp.substring(randomizer + 1);
		}
		
		return string;
	}
	
	public static String scrambleSentence(String string)
	{
		String punct = "";
		if (string.indexOf('.') != -1)
		{
			punct = ". ";
			string = string.substring(0, string.length() - 1);
		}
		else if (string.indexOf('!') != -1)
		{
			punct = "! ";
			string = string.substring(0, string.length() - 1);
		}
		else if (string.indexOf('?') != -1)
		{
			punct = "? ";
			string = string.substring(0, string.length() - 1);
		}
		
		int[] spaceIndexes = findIndexes(string, ' ');
		
		String[] wordArray = new String[spaceIndexes.length + 1];
		wordArray[0] = string.substring(0, spaceIndexes[0]);
		for (int i = 0; i < spaceIndexes.length - 1; i++)
		{
			wordArray[i + 1] = string.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]);
		}
		wordArray[wordArray.length - 1] = string.substring(spaceIndexes[spaceIndexes.length - 1] + 1);
		
		scrambleArray(wordArray);
		
		string = "";
		for(String i : wordArray)
		{
			string += scrambleWord(i) + " ";
		}
		string = string.substring(0, string.lastIndexOf(' '));
		
		return string + punct;
	}
	
	public static String scrambleText(String string)
	{
		int[] periodIndexes = findIndexes(string, '.');
		int[] exclamationIndexes = findIndexes(string, '!');
		int[] questionIndexes = findIndexes(string, '?');
		
		int[] firstMerge = mergeArrays(periodIndexes, exclamationIndexes);
		int[] finalIndexes = mergeArrays(firstMerge, questionIndexes);
		
		Arrays.sort(finalIndexes);
		
		String[] sentenceArray = new String[finalIndexes.length];
		
		sentenceArray[0] = string.substring(0, finalIndexes[0] + 1);
		
		if (finalIndexes.length > 1)
		{
			for (int i = 0; i < sentenceArray.length - 2; i++)
			{
				sentenceArray[i + 1] = string.substring(finalIndexes[i] + 2, finalIndexes[i + 1] + 1);
			}
			sentenceArray[sentenceArray.length - 1] = string.substring(finalIndexes[finalIndexes.length - 2] + 2, finalIndexes[finalIndexes.length - 1] + 1);
		}
		
		scrambleArray(sentenceArray);
		
		string = "";
		for (String i : sentenceArray)
		{
			string += scrambleSentence(i);
		}
		string = string.substring(0, string.lastIndexOf(' '));
		
		return string;
	}
}
