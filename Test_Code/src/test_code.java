import java.util.ArrayList;
import java.util.List;

enum Level
{
	LOW,
	MEDIUM,
	HIGH
}


public class test_code
{
	public static void main(String[] args) throws InterruptedException
	{
		for (int i=0; i<3; i++)
		{
			System.out.println(i);
		}
		System.out.print("\n");
		
		
		
		int[] foo = {1, 2, 4, 3, 5};
		
		for (int i : foo)
		{
			System.out.println(i);
		}
		System.out.print("\n");
		
		
		
		char a = 'a';
		char b = 'b';
		char c = 'c';
		char d = 'd';
		String abcd = "" + a + b + c + d;
		System.out.println(abcd);
		System.out.println(abcd.substring(1));
		System.out.print("\n");
		
		
		
		System.out.println(a + 0);
		System.out.println(b + 0);
		System.out.println(c + 0);
		System.out.println(d + 0);
		System.out.print("\n");
		
		
		
		char newChar = 'a' + 1;
		System.out.println(newChar);
		System.out.print("\n");
		
		System.out.print("(1)  [NULL] \n"                 + "(2)  [START OF HEADING] \n"           + 
		                 "(3)  [START OF TEXT] \n"        + "(4)  [END OF TRANSMISSION] \n"        + 
		                 "(5)  [ENQUIRY] \n"              + "(6)  [ACKNOWLEDGE] \n"                + 
		                 "(7)  [BELL] \n"                 + "(8)  [BACKSPACE] \n"                  + 
		                 "(9)  [HORIZONTAL TAB] \n"       + "(10) [NEW LINE] \n" 				   + 
		                 "(11) [VERTICAL TAB] \n"         + "(12) [NEW PAGE] \n"                   + 
				   		 "(13) [CARRIAGE RETURN] \n"      + "(14) [SHIFT OUT] \n"                  + 
		                 "(15) [SHIFT IN] \n"             + "(16) [DATA LINK ESCAPE] \n"           + 
				   		 "(17) [DEVICE CONTROL 1] \n"     + "(18) [DEVICE CONTROL 2] \n"           + 
		                 "(19) [DEVICE CONTROL 3] \n"     + "(20) [DEVICE CONTROL 4] \n"           + 
						 "(21) [NEGATIVE ACKNOWLEDGE] \n" + "(22) [SYNCHRONOUS IDLE] \n"           + 
		                 "(23) [END OF TRANS \n"          + "(24) [CANCEL] \n"                     + 
						 "(25) [END OF MEDIUM] \n"        + "(26) [SUBSTITUE] \n"                  + 
						 "(27) [ESCAPE] \n"               + "(28) [FILE SEPARATOR] \n"             + 
						 "(29) [GROUP SEPARATOR] \n"      + "(30) [RECORD SEPARATOR] \n"           + 
						 "(31) [UNIT SEPARATOR] \n"       + "(32) [SPACE] \n")                     ;
		for (int i = 32; i < 127; i++)
		{
			char x = (char)i;
			System.out.println("(" + i + ") " + x);
		}
		System.out.println("(127) [DELETE]");
		System.out.print("\n");
		
		
		
		long num = 5;
		System.out.print(num + "! = ");
		for(long i = num - 1; i > 0; i--)
		{
			num *= i;
		}
		System.out.println(num);
		System.out.print("\n");
		
		long n2 = 10;
		System.out.print(n2 + "!! = ");
		for (long i = n2 - 2; i > 0; i -= 2)
		{
			n2 *= i;
		}
		System.out.println(n2);
		System.out.print("\n");
		
		long n3 = 22;
		System.out.print(n3 + "!!! = ");
		for (long i = n3 - 3; i > 0; i -= 3)
		{
			n3 *= i;
		}
		System.out.println(n3);
		System.out.print("\n");
		
		
		
		int year = -4;
		System.out.println(findIfIsLeapYear(year));
		System.out.print("\n");
		
		
		
		System.out.println(compSciRef("freedom"));
		System.out.print("\n");
		
		
		
		boolean test = false;
		while (test)
		{
			System.out.println("Hi!");
		}
		
		
		
		String enumTest = "MEDIUM";
		Level level = Level.valueOf(enumTest);
		System.out.println(level);
		System.out.println();
		
		
		
		String string = "abc123";
		String temp = "";
		for (int i = string.length() - 1; i > -1; i--)
		{
			temp += string.charAt(i);
		}
		System.out.println(temp);
		System.out.println();
		
		
		
		try
		{
			throw new NotTheCorrectMethodException();
		}
		catch(NotTheCorrectMethodException e)
		{
			System.out.println("Error. " + e.getMessage());
		}
		System.out.println();
		
		
		
		randomizeUntilNum(6, 3);
		System.out.println();
		
		
		double castMe = 97;
		Object caster = (char)castMe;
		System.out.println(caster);
		System.out.println();
		
		
		
		String full = seperateValues();
		String first = seperateValues().substring(0, seperateValues().indexOf((char)29));
		String second = seperateValues().substring(seperateValues().indexOf((char)29) + 1);
		
		System.out.println(full);
		System.out.println(first);
		System.out.println(second);
		System.out.println();
		
		
		
		System.out.println(convertToBase10(110));
		System.out.println(convertToBinary(12));
		System.out.println();
		
		
		
		byte bit = 12;
		bit = (byte)((bit >> 1) - 1);
		System.out.println(bit);
		System.out.println();
		
		
		
		int wiseOne = 5;
		int wiseTwo = 7;
		
		System.out.println(wiseOne & wiseTwo);
		System.out.println(wiseOne | wiseTwo);
		System.out.println(wiseOne ^ wiseTwo);
		System.out.println(~wiseOne);
		System.out.println(~wiseTwo);
		System.out.println();
		
		
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(5);
		numbers.add(4);
		numbers.forEach( (n) -> { System.out.println(n); } );
		System.out.println();
		
		
		
		String repeatingChars = "aaaabbccc";
		System.out.println(condenseString(repeatingChars) + "\n");
		
		
		
		System.out.println(fibonacciSequence(15) + "\n");
		
		
		
		ArrayList<Integer> sortMethodQuestionMark = new ArrayList<>();
		sortMethodQuestionMark.add(2);
		sortMethodQuestionMark.add(3);
		sortMethodQuestionMark.add(1);
		System.out.println(sortMethodQuestionMark);
		System.out.println("---------");
		
		sortMethodQuestionMark.sort(null);
		System.out.println(sortMethodQuestionMark);
		System.out.println();
		
		
		
		ArrayList<String> cars = new ArrayList<>();
		cars.add("McQueen");
		cars.add("Mater");
		cars.add("Luigi");
		cars.add("Guido");
		cars.add(1, "Doc Hudson");
		cars.remove(2);
		System.out.println(cars);
		
		
		
		System.out.println("Original: " + cars.get(0));
		System.out.println("-----\nBefore: " + cars.set(0, "Lightning McQueen"));
		System.out.println("After: " + cars.get(0));
		
		System.out.println("\n" + cars.get(3));
		System.out.println("-----\nRemoved: " + cars.remove(3));
		try
		{
			System.out.println(cars.get(3));
		}
		catch (IndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(cars.add("Guido"));
		
		
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		names.add("Derek");
		
		names.add(names.remove(0));
		System.out.println(names);
		System.out.println();
		
		
		
		System.out.println(findPrimeNumbers(1000));
		System.out.println();
		
		
		
		printMe();
		test_code2.printMe();
		test_code2.test_code3.printMe();
		test_code2.test_code3.test_code4.printMe();
		System.out.println();
		
		
		
		System.out.println(round10(16) + "\n");
		
		
		
		System.out.println(rFact(20));
		System.out.println();
		
		
		
		System.out.println((int)(Math.random() * 2));
		System.out.println();
		
		
		
		printR(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}.length);
		System.out.println();
		
		
		System.out.println(scrambleWord("AARDVARK"));
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add("TAN");
		wordList.add("ABRACADABRA");
		wordList.add("WHOA");
		wordList.add("AARDVARK");
		wordList.add("EGGS");
		wordList.add("A");
		System.out.println(wordList);
		
		scrambleOrRemove(wordList);
		System.out.println(wordList);
	}
	
	
	
	
	public static boolean findIfIsLeapYear(int year)
	{
		if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
		{
			return true;
		}
		return false;
	}
	
	
	
	public static String compSciRef(String jev)
	{
		return jev.equals("freedom") || jev.equals("fame")? "jev" : "Willyynova";
	}
	
	
	
	public static String giveBackwards(String str)
	{
		String temp = "";
		
		for (int i = str.length() - 1; i >= 0; i++)
		{
			temp += str.charAt(i);
		}
		
		return temp;
	}
	
	
	
	public static void randomizeUntilNum(int num, int iters)
	{	
		for (int i = 0; i < iters; i++)
		{
			int rng = num - 1;
			while (rng != num)
			{
				rng = (int)(Math.random() * 9);
				System.out.print(rng);
			}
			System.out.println();
		}
	}
	
	
	
	public static String seperateValues()
	{
		String first = "first";
		String second = "second";
		
		return first + (char)29 + second;
	}
	
	
	
	public static int convertToBase10(long binary)
	{
		int decimal = 0;
		
		int binaryLength = String.valueOf(binary).length();
		for (int i = binaryLength - 1; i >= 0; i--)
		{
			decimal += String.valueOf(binary).charAt((binaryLength - 1) - i) == '1'? Math.pow(2, i) : 0;
		}
		
		return decimal;
	}
	
	
	
	public static String convertToBinary(int decimal)
	{
		if (decimal == 0 || decimal == 1)
		{
			return decimal + "";
		}
		
		Integer[] binaryBuilder = new Integer[100];
		for (int i = binaryBuilder.length - 1; decimal > 0; i--)
		{
			int remainder = decimal % 2;
			
			binaryBuilder[i] = remainder;
			
			decimal /= 2;
		}
		
		String binary = "";
		for (Integer i : binaryBuilder)
		{
			if (i == null)
			{
				break;
			}
			
			binary += i;
		}
		
		return binary;
	}
	
	
	
	public static String condenseString(String string)
	{
		string += " ";
		char current = string.charAt(0);
		int count = 0;
		String condensedString = "";
		
		for (int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) == current)
			{
				count++;
			}
			else
			{
				condensedString += "" + count + current;
				current = string.charAt(i);
				count = 1;
			}
		}
		
		return condensedString;
	}
	
	
	
	public static String fibonacciSequence(int length)
	{
		String sequence = "11";
		
		for (int i = 1; i <= length; i++)
		{
			sequence += Integer.parseInt(sequence.substring(i, i + 1)) + Integer.parseInt(sequence.substring(i - 1, i));
		}
		
		return sequence;
	}
	
	
	
	public static ArrayList<Integer> findPrimeNumbers(int length)
	{
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 0; i <= length; i++)
		{
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
			{
				continue;
			}
			else
			{
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	
	
	public static void printMe()
	{
		System.out.println("I am an outer class");
	}
	class test_code2
	{
		public static void printMe()
		{
			System.out.println("I am an inner class");
		}
		
		class test_code3
		{
			public static void printMe()
			{
				System.out.println("I am an inner inner class");
			}
			
			class test_code4
			{
				public static void printMe()
				{
					System.out.println("I am an inner inner inner class");
				}
			}
		}
	}
	
	
	
	public static int roundSum(int a, int b, int c)
	{
		return round10(a) + round10(b) + round10(c);
	}
	public static int round10(int num)
	{
		if (num % 10 < 5)
		{
			return num - (num % 10);
		}
		return num + (10 - (num % 10));
	}

	
	
	public static int rFact(int num)
	{
		if (num > 1)
			return rFact(num - 1) + rFact(num - 2);
		
		return num;
	}
	
	
	
	public static void printR(int[] array, int length)
	{
		if (array.length == length)
			System.out.print("[");
		
		if (array.length == 0)
		{
			System.out.println("]");
			return;
		}
		
		System.out.print(array[0]);
		System.out.print(array.length == 1? "" : ", ");
		
		int[] copy = new int[array.length - 1];
		
		System.arraycopy(array, 1, copy, 0, array.length - 1);
		printR(copy, length);
	}
	
	public static String scrambleWord(String word)
	{
	    if (word.length() < 2)
	    {
	    	return word;
	    }
	    
	    String scrambled = word;
	    for (int i = 0; i < word.length() - 1; i++)
	    {  
	        if (scrambled.charAt(i) == 'A' && scrambled.charAt(i + 1) != 'A')
	        {
	        	scrambled = scrambled.substring(0, i) + scrambled.charAt(i + 1) + scrambled.charAt(i) + scrambled.substring(i + 2);
	        	i++;
	        }
	    }
	    return scrambled;
	}
	
	public static void scrambleOrRemove(List<String> wordList)
	{
		for (int i = 0; i < wordList.size(); i++)
	    {
	    	if (wordList.get(i).equals(scrambleWord(wordList.get(i))))
	        {
	        	wordList.remove(i--);
	        }
	        else
	        {
	        	wordList.add(i, scrambleWord(wordList.get(i)));
	            wordList.remove(i + 1);
	        }
	    }
	}
}