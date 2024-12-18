import java.util.Arrays;

/**
 * Class to scramble a string
 * Personal project
 */
public class Scrambler
{

	public static void main(String[] args)
	{
		System.out.println(scrambleSentence("I am a sentence to scramble."));
		System.out.println(scrambleText("This is a sentence to scramble. This has an exclamation point! Does this have a question mark?"));
	}
	
	/**
	 * Method to find the indexes of a specific char inside 
	 * @param string
	 * @param character
	 * @return an array with every index of every char
	 */
	public static int[] findIndexes(String string, char character)
	{
		/*
		 * declares count
		 * loops through string
		 * - every time the iterated char matches the passed char, add one to count
		 */
		int count = 0;
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == character)
			{
				count++;
			}
		}
		
		/*
		 * make an array with a length based on the value stored in count
		 * loops through the string
		 * - checks if the iterated char matches the passed char
		 *   - loops through the array
		 *     - checks if the iterated value is 0 (the default value in an int[])
		 *       - adds i (the current index of the string is on)
		 *       - breaks the loop to go back to the original loop
		 */
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
	
	/**
	 * Method to merge arrays
	 * @param array1
	 * @param array2
	 * @return an array comprised of two arrays
	 */
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
	
	/**
	 * void method to scramble an array
	 * @param array
	 */
	public static void scrambleArray(Object[] array)
	{
		/*
		 * loops through the passed array
		 * - generates a random number between 0 and the length of the string
		 * - stores the value at the index the rng generated
		 * - stores the current value the loop is on
		 * 
		 * - swaps the two items
		 */
		for (int i = 0; i < array.length; i++)
		{
			int randomIndex = (int)(Math.random() * array.length);
			Object randomItem = array[randomIndex];
			Object currentItem = array[i];
			
			array[i] = randomItem;
			array[randomIndex] = currentItem;
		}
	}
	
	/**
	 * Method to scramble a word
	 * @param string
	 * @return the scrambled version of the passed string
	 */
	public static String scrambleWord(String string)
	{
		//String object and gives it the value of string parameter
		String temp = string;
		//empties string
		string = "";
		
		/*
		 * while the length of temp is greater than 0
		 * - generate a random number
		 * - add whatever letter the randomizer generated to string
		 * - gut that letter from temp
		 */
		while(temp.length() > 0)
		{
			int randomizer = (int)(Math.random() * temp.length());
			string += temp.charAt(randomizer);
			temp = temp.substring(0, randomizer) + temp.substring(randomizer + 1);
		}
		
		return string;
	}
	
	/**
	 * Method to scramble sentences
	 * @param string
	 * @return a scrambled version the passed string
	 */
	public static String scrambleSentence(String string)
	{
		/*
		 * create String punct with empty string
		 * checks if it ends in '.'
		 * - adds ". " to punct and 
		 * - removes it from the sentence
		 * checks if it ends in '!'
		 * - adds "! " to punct and 
		 * - removes it from the sentence
		 * checks if it ends in '?'
		 * - adds "? " to punct and 
		 * - removes it from the sentence
		 */
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
		
		//calls the findIndexes() method to find each index of every space in the string and stores it in spaceIndexes
		int[] spaceIndexes = findIndexes(string, ' ');
		
		//creates a new String[] with a length of the length of the spaceIndexes array + 1
		String[] wordArray = new String[spaceIndexes.length + 1];
		
		/*
		 * adds the first sentence into the array (0, spaceIndexes[0] because 0 is a constant)
		 * loops through the array
		 * - adds the next sentences to the array ([i + 1] because i starts at 0 but we already added a sentence to the first item in the array)
		 * adds the final sentence to the array
		 */
		wordArray[0] = string.substring(0, spaceIndexes[0]);
		for (int i = 0; i < spaceIndexes.length - 1; i++)
		{
			wordArray[i + 1] = string.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]);
		}
		wordArray[wordArray.length - 1] = string.substring(spaceIndexes[spaceIndexes.length - 1] + 1);
		
		//scrambles the values in the array by calling the scrambleArray() method
		scrambleArray(wordArray);
		
		/*
		 * empties the string
		 * for each item in the array
		 * - scramble each item and add it to string
		 */
		string = "";
		for(String i : wordArray)
		{
			string += scrambleWord(i) + " ";
		}
		//gets rid of the last space
		string = string.substring(0, string.lastIndexOf(' '));
		
		//returns string and adds punct after it
		return string + punct;
	}
	
	/**
	 * Method to scramble more than one sentence
	 * @param string
	 * @return a scrambled version of the passed string
	 */
	public static String scrambleText(String string)
	{
		/*
		 * arrays to store the indexes of '.', '!', and '?'
		 */
		int[] periodIndexes = findIndexes(string, '.');
		int[] exclamationIndexes = findIndexes(string, '!');
		int[] questionIndexes = findIndexes(string, '?');
		
		//merges the first two array (period and exclamation arrays) by calling the mergeArrays() method
		int[] firstMerge = mergeArrays(periodIndexes, exclamationIndexes);
		//creates the final array of all the indexes in one array
		int[] finalIndexes = mergeArrays(firstMerge, questionIndexes);
		
		Arrays.sort(finalIndexes);
		
		//creates a String[] with the length of finalIndexes
		String[] sentenceArray = new String[finalIndexes.length];
		
		//adds the first sentence to the sentence array
		sentenceArray[0] = string.substring(0, finalIndexes[0] + 1);
		/*
		 * checks if the finalIndexes array length is greater than 1
		 * - loops through the array - 2
		 *   - adds each sentence into the array
		 * - adds the last sentence to the array
		 */
		if (finalIndexes.length > 1)
		{
			for (int i = 0; i < sentenceArray.length - 2; i++)
			{
				sentenceArray[i + 1] = string.substring(finalIndexes[i] + 2, finalIndexes[i + 1] + 1);
			}
			sentenceArray[sentenceArray.length - 1] = string.substring(finalIndexes[finalIndexes.length - 2] + 2, finalIndexes[finalIndexes.length - 1] + 1);
		}
		
		//scrambles the array
		scrambleArray(sentenceArray);
		
		//empties string
		string = "";
		/*
		 * for each item in the array
		 * - pass it into the scrambleSentence() method
		 */
		for (String i : sentenceArray)
		{
			string += scrambleSentence(i);
		}
		//removes the last space in the string
		string = string.substring(0, string.lastIndexOf(' '));
		
		return string;
	}
}
