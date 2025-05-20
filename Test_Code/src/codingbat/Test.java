package codingbat;

public class Test
{
	public static void main(String[] args)
	{
		System.out.println(notString("not"));
		
		System.out.println(altPairs("Chocolate"));
		
		System.out.println(stringYak("yakxxxyak"));
		
		startWord("", "i");
		
		xyBalance("");
	}
	
	public static String notString(String str)
	{
		if (str.length() >= 3 && str.substring(0, 3).equals("not"))
			return str;
		return "not " + str;
	}
	
	public static String altPairs(String str)
	{
		if (str.length() == 1)
			return str;
	  
		String pairs = "";
	  
		for (int i = 0; i < str.length(); i++)
		{
			if (i % 4 == 0 || i % 4 == 1)
			{
				pairs += str.charAt(i);
			}
		}
	  
		return pairs;
	}
	
	public static String stringYak(String str)
	{
		for (int i = 0; i < str.length() - 3; i++)
		{
			if (str.substring(i, i + 3).equals("yak"))
			{
				str = str.substring(0, i) + str.substring(i + 2);
				i = 0;
			}
		}
		
		return str;
	}

	public static String startWord(String str, String word)
	{
		int length = word.length();
		if (str.length() < length)
			length = str.length();
		
		if (length > 0 && str.substring(1, length).equals(word.substring(1)))
			return str.substring(0, length);
		return "";
	}
	
	public static boolean xyBalance(String str)
	{
		System.out.println(str.indexOf('y'));
		System.out.println(str.indexOf('x'));
		
		return true;
	}

}
