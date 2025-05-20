
public class class_test
{

	public static void main(String[] args)
	{
		int x = -5;
		while (x < 0)
		{
		   x++;
		   System.out.print(x + " ");
		}
		System.out.print("\n");
		
		
		String str = "Girmenzi";
		String strCopy = "";
		int c = 0;
		for (int i = 0; i < str.length(); i += 3)
		{
			strCopy += "" + str.charAt(i);
			System.out.println(str.charAt(i));
			c++;
		}
		System.out.println(strCopy);
		System.out.println(c);
	}

}
