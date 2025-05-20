import java.util.Scanner;

public class scannertest {

	public static void main(String[] args)
	{
		//sets scanner 
				Scanner myReader = new Scanner(System.in);
				
				//sets variables and its values
				int num1 = myReader.nextInt();
				String operation = myReader.next();
				int num2 = myReader.nextInt();
				
				//make if statements and print them
				if (operation.equals("+"))
				{
					System.out.print(num1 + num2);
				}
				if (operation.equals("-"))
				{
					System.out.print(num1 - num2);
				}
				if (operation.equals("*"))
				{
					System.out.print(num1 * num2);
				}
				if (operation.equals("/"))
				{
					System.out.print(num1 / num2);
				}
				
				//close readers
				myReader.close();
	}
}
