
/**
 * This a personal project I made because I wanted to try my hand at a scrambler
 * This class uses arrays to seperate each word and scramble them individually
 * Each method builds on another
 * @author Keola Teson :)
 */
public class Scrambler
{
	public static void main(String[] args)
	{
		System.out.println(scrambleWord("abcdefghijklmnopqrstuvwxyz"));
		System.out.println(scrambleSentence("The quick brown fox jumps over the lazy dog."));
		System.out.println(scrambleText("This is a test. I want to see if I can scrambled multiple sentences. Carry on."));
	}
	
	/**
	 * Method to scramble individual words
	 * @param word
	 * @return a scrambled version of the param
	 */
	public static String scrambleWord(String word)
	{
		/*
		 * variables used in the scramble
		 */
		int randomizer = 0;
		String randomDisplay = "";
		String display = "";
		
		/*
		 * while loop to loop until the length of the word is 0
		 */
		while(word.length() > 0)
		{
			//randomly picks a number between the 0 and the length of the word (ex: if the word is "string", length is 6, the randomizer would choose a number from 0 to 6)
			randomizer = (int)(Math.random() * word.length());
			
			/*
			 * checks if the number randomly generated was already put inside a display
			 * - adds the number to a display
			 * - adds the charAt the random index generated to a display that will be returned in the future
			 * - removes the letter from the original word
			 */
			if (randomDisplay.indexOf(randomizer) == -1)
			{
				randomDisplay += randomizer;
				display += word.charAt(randomizer);
				word = word.substring(0, randomizer) + word.substring(randomizer + 1);
			}
		}
		//final return statement
		return display;
	}
	
	/**
	 * Method to scramble an array
	 * @param array
	 * @return a scrambled version of the array
	 */
	public static String[] scrambleArray(String[] array)
	{	
		/*
		 * variables used in loop
		 */
		int randomizer = 0;
		String randomDisplay = "";
		String[] temp = new String[array.length];
		int i = 0;
		
		/*
		 * loops while the value of i is less than the array length
		 */
		while (i < array.length)
		{
			//randomly generates a number between 0 and the array length
			randomizer = (int)(Math.random() * array.length);
			
			/*
			 * checks if the number generated was already generated
			 * - adds the number to a display
			 * - adds the value inside the passed array at the generated index to a temp array
			 */
			if (randomDisplay.indexOf(" " + randomizer + " ") == -1)
			{
				randomDisplay += " " + randomizer + " ";
				temp[i] = array[randomizer];
				
				//adds one to i
				i++;
			}
		}
		//returns the temp array
		return temp;
	}
	
	/**
	 * Method to scramble a single sentence
	 * Keeps the spaces where they are supposed to be
	 * @param string
	 * @return the final scrambled sentence
	 */
	public static String scrambleSentence(String string)
	{
		/*
		 * counts the amount of spaces in the string for future use
		 * loops through the string
		 * - checks if the char the loop is iterated on is ' '
		 *   - adds one to spaceCount
		 */
		int spaceCount = 0;
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == ' ')
			{
				spaceCount++;
			}
		}
		
		/*
		 * adds each index of every space into an array
		 * loops through the length of the string
		 * - checks if the charAt i is a space
		 *   - loops through the length of the spaceIndexes array
		 *     - checks if the current item is 0, replaces it with the index of the space it found (i)
		 *     - breaks the loop
		 */
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
		
		//wordArray to store each word into the array [sets length to the length of the spaceIndexes array + 1]
		String[] wordArray = new String[spaceIndexes.length + 1];
		
		/*
		 * adds the first word into the array
		 * loops through length of the spaceIndexes array - 1
		 * - stores each word into the array ([i + 1] because the loop starts at 0 = (i] + 1 to get rid of space, [i + 1] for next index of space)
		 * adds the final word to the array ([.length - 1 to get the last item in the array] + 1 to get rid of the space in the front of the word)
		 */
		wordArray[0] = string.substring(0, spaceIndexes[0]);
		
		for (int i = 0; i < spaceIndexes.length - 1; i++)
		{
			wordArray[i + 1] = string.substring(spaceIndexes[i] + 1, spaceIndexes[i + 1]);
		}
		wordArray[wordArray.length - 1] = string.substring(spaceIndexes[spaceIndexes.length - 1] + 1);
		
		//new String[] that calls the scrambleArray() method and passes into it the wordArray
		String[] scrambledArray = scrambleArray(wordArray);
		
		//changes the value of string to be empty
		string = "";
		
		/*
		 * for-each item in the array
		 * - pass it into the scrambleWord() method and add a space right after
		 */
		for (String i : scrambledArray)
		{
			string += scrambleWord(i) + " ";
		}
		
		//returns the modified string (\b to get rid of the final ' ')
		return string + "\b";
	}
	
	
	/**
	 * Method to scrambled multiple senteces in a string
	 * @param string
	 * @return the scrambled text in the sentence
	 */
	public static String scrambleText(String string)
	{
		/*
		 * counts the amount of periods in the string for future use
		 * loops through the string
		 * - checks if the char the loop is iterated on is '.'
		 *   - adds one to periodCount
		 */
		int periodCount = 0;
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == '.')
			{
				periodCount++;
			}
		}
		
		/*
		 * adds each index of every period into an array
		 * loops through the length of the string
		 * - checks if the charAt i is '.'
		 *   - loops through the length of the spaceIndexes array
		 *     - checks if the current item is 0, replaces it with the index of the space it found (i)
		 *     - breaks the loop
		 */
		int[] periodIndexes = new int[periodCount];
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == '.')
			{
				for (int j = 0; j < periodIndexes.length; j++)
				{
					if (periodIndexes[j] == 0)
					{
						periodIndexes[j] = i;
						break;
					}
				}
			}
		}
		
		//array to add each individual sentence
		String[] sentenceArray = new String[periodIndexes.length];
		
		/*
		 * adds the first sentence to the array (0 is a constant)
		 * loops through the length of the array (.length - 2 because there is a period at the end of the word)
		 * - adds the next sentences to the array ([i] + 2 to get rid of the space and the period, [i + 1] to go to the next period)
		 * adds the last sentence to the array ([.length - 2] + 2 to find the second to last period in the string and to get rid of the period and space, 
		 * [.length - 1] to get the last value;
		 */
		sentenceArray[0] = string.substring(0, periodIndexes[0]);
		
		if (periodIndexes.length > 1)
		{
			for (int i = 0; i < sentenceArray.length - 2; i++)
			{
				sentenceArray[i + 1] = string.substring(periodIndexes[i] + 2, periodIndexes[i + 1]);
			}
			sentenceArray[sentenceArray.length - 1] = string.substring(periodIndexes[periodIndexes.length - 2] + 2, periodIndexes[periodIndexes.length - 1]);
		}
		
		//passes the new sentenceArray into the scrambleArray() method and stores that value
		String[] scrambledArray = scrambleArray(sentenceArray);
		
		//resets string
		string = "";
		
		/*
		 * for-each item in the array
		 * - pass it into the scrambleSentence() method and add a ". " after
		 */
		for (String i : scrambledArray)
		{
			string += scrambleSentence(i) + ". ";
		}
		
		//returns the modified string (\b to get rid of the final ' ')
		return string + "\b";
	}
}
