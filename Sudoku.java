import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Sudoku
{
	public static void main(String[] args)
	{
		playGame();
	}
	
	private static Scanner scanner = new Scanner(System.in);
	
	//board for logic
	private static int[][][] board = 
		{{{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0 ,0}},
		
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0 ,0}},
		
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0 ,0}}};
	//board for printing
	private static char[][][] boardCopy = 
		{{{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0 ,0}},
		
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0 ,0}},
		
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0, 0}},
		 {{0, 0, 0},{0, 0, 0},{0, 0 ,0}}};
	
	public static void playGame()
	{
		System.out.println("Welcome to Sudoku!");
		System.out.println("\nChoose a difficulty: (Easy | Medium | Hard | No Hints)");
		
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("easy"))
		{
			playGame('e');
		}
		else if (input.equalsIgnoreCase("medium"))
		{
			playGame('m');
		}
		else if (input.equalsIgnoreCase("hard"))
		{
			playGame('h');
		}
		else
		{
			playGame('n');
		}
		
		
		scanner.close();
	}
	
	private static void printBoard()
	{
		//moves through the 3d array
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				for (int k = 0; k < board[i][j].length; k++)
				{
					//adds either a space or a number into boardCopy
					if (board[i][j][k] == 0)
					{
						boardCopy[i][j][k] = ' ';
						continue;
					}
					for (int m = 1; m <= 9; m++)
					{
						if (board[i][j][k] == m)
						{
							boardCopy[i][j][k] = (char)(m + 48);
						}
					}
				}
			}
		}
		
		//moves through the 3d array
		//prints the first array in the first three grid then the second then the third and repeats for the other 6 grids in the 3d array
		for (int  k = 0; k < boardCopy.length; k += 3)
		{
			for (int i = k; i <= k + 2; i++)
			{
				for (int j = 0; j < boardCopy[i][0].length; j++)
				{
					System.out.print("|\033[4m" + boardCopy[i][0][j] + "\033[0m");
				}
				System.out.print("| ");
			}
			System.out.println();
			
			for (int i = k; i <= k + 2; i++)
			{
				for (int j = 0; j < boardCopy[i][1].length; j++)
				{
					System.out.print("|\033[4m" + boardCopy[i][1][j] + "\033[0m");
				}
				System.out.print("| ");
			}
			System.out.println();
			
			for (int i = k; i <= k + 2; i++)
			{
				for (int j = 0; j < boardCopy[i][2].length; j++)
				{
					System.out.print("|\033[4m" + boardCopy[i][2][j] + "\033[0m");
				}
				System.out.print("| ");
			}
			System.out.println("\n");
		}
	}
	
	private static void printSpecificGrid(int gridSelection)
	{
		//prints a single 2d array in the 3d array based on whatever the user selected
		for (char[] i : boardCopy[gridSelection])
		{
			for (char j : i)
			{
				System.out.print("|\033[4m" + j + "\033[0m");
			}
			System.out.print("|\n");
		}
	}
	
	private static void randomizeBeginning(char difficulty)
	{
		//checks the passed char to determine how much hint numbers the player gets
		int levelNum = 0;
		if (difficulty == 'e')
		{
			levelNum = 31;
		}
		else if (difficulty == 'm')
		{
			levelNum = 21;
		}
		else if (difficulty == 'h')
		{
			levelNum = 11;
		}
		
		for (int i = 0; i < levelNum; i++)
		{
			//creates an array for random values (grid selection, minimum grid selection, posY, posX, hintNum)
			int[] randNums = randomizeNums();
			
			//loops until num is lonely
			boolean numIsLonely;
			do
			{
				//calls the checkHintPosition method to check if the hint number is in a valid spot
				numIsLonely = checkHintPosition(randNums);
				
			} while (!numIsLonely);
			
			board[randNums[0]][randNums[2]][randNums[3]] = randNums[4];
		}
	}
	

	private static boolean checkHintPosition(int[] randNums)
	{
		//checks the squares in the same grid
		for (int[] j : board[randNums[0]])
		{
			for (int k : j)
			{
				//checks if that number already exists in the grid
				if (k == randNums[4])
				{
					randNums[4] = (int)(Math.random() * 9) + 1;
					return false;
				}
			}
		}
		
		//checks the squares in the same row
		for (int j = randNums[1]; j < randNums[1] + 3; j++)
		{
			for (int k : board[j][randNums[2]])
			{
				//checks if that number already exists in the row
				if (k == randNums[4])
				{
					randNums[4] = (int)(Math.random() * 9) + 1;
					return false;
				}
			}
		}
		
		//checks the squares in the same column
		for (int j = 0; j < board.length; j++)
		{
			for (int k = 0; k <= 2; k++)
			{
				//checks if that number already exists in the column
				if (board[j][k][randNums[3]] == randNums[4])
				{
					randNums[4] = (int)(Math.random() * 9) + 1;
					return false;
				}
			}
		}
		
		//returns true if all checks fail
		return true;
	}

	
	private static int[] randomizeNums()
	{
		/*
		 * randomly chooses numbers between 0...9 (1...9 for the hint num)
		 * returns them as an array
		 */
		int randGridSelection = (int)(Math.random() * board.length);
		int minimumGridSelection = getMininumGridSelection(randGridSelection);
		
		int randPosY = (int)(Math.random() * board[randGridSelection].length);
		
		int randPosX = (int)(Math.random() * board[randGridSelection][randPosY].length);
		
		int randHintNum = (int)(Math.random() * 9) + 1;
		
		return new int[]{randGridSelection, minimumGridSelection, randPosY, randPosX, randHintNum};
	}
	

	private static int getMininumGridSelection(int gridSelection)
	{
		//stores the grid selection
		int minimumGridSelection = gridSelection;
		
		//decrements minimumGridSelection until it reaches the beginning of the row
		while (minimumGridSelection != 0 && minimumGridSelection != 3 && minimumGridSelection != 6)
		{
			minimumGridSelection--;
		}
		
		return minimumGridSelection;
	}

	private static void playGame(char difficulty)
	{
		randomizeBeginning(difficulty);
		printBoard();
		
		int gridSelection, column, row, num;
		
		//loops until number is in a valid position
		boolean numIsAlone;
		do
		{
			System.out.println("Choose a grid: (1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9)");
			gridSelection = checkInput() - 1;
			printSpecificGrid(gridSelection);
			
			System.out.println("Choose a column: (1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9)");
			column = checkInput() - 1;
			
			System.out.println("Choose a row: (1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9)");
			row = checkInput() - 1;
			
			System.out.println("Place a number: (1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9)");
			num = checkInput();
			
			numIsAlone = checkNumberPlacement(num, gridSelection, row, column);
		}
		while (!numIsAlone);
		
		//adds to board
		board[gridSelection][column][row] = num;
		
		//prints board
		printBoard();
		//checks win
		checkWin();
	}
	
	private static boolean checkNumberPlacement(int num, int gridSelection, int posX, int posY)
	{
		//gets the starting grid in your row
		int minimumGridSelection = getMininumGridSelection(gridSelection);
		
		//checks if the spot is filled
		if (board[gridSelection][posY][posX] != 0)
		{
			System.out.println("That spot is filled. Please try again.");
			return false;
		}
		
		//moves through the selected grid
		for (int[] j : board[gridSelection])
		{
			for (int k : j)
			{
				//checks if the number already exists in the grid
				if (k == num)
				{
					System.out.println(1);
					System.out.println("Invalid spot for that number. Please try again.");
					return false;
				}
			}
		}
		
		//moves through the row
		for (int j = minimumGridSelection; j < minimumGridSelection + 3; j++)
		{
			for (int k : board[j][posY])
			{
				//checks if the number exists in the row
				if (k == num)
				{
					System.out.println(2);
					System.out.println("Invalid spot for that number. Please try again.");
					return false;
				}
			}
		}
		
		//moves through the column
		for (int j = 0; j < board.length; j++)
		{
			for (int k = 0; k <= 2; k++)
			{
				//checks if the number exists in the column
				if (board[j][k][posX] == num)
				{
					System.out.println(3);
					System.out.println("Invalid spot for that number. Please try again.");
					return false;
				}
			}
		}
		
		//returns true if all checks are false
		return true;
	}
	
	private static int checkInput()
	{
		//loops forever (until a value gets returned)
		while (true)
		{
			//in case the player inputs a letter
			try
			{
				int input = Integer.parseInt(scanner.nextLine());
				
				//checks if input is a valid number
				for (int i = 1; i <= 9; i++)
				{
					if (input == i)
					{
						//returns if true
						return input;
					}
				}
			} catch (Exception e) {}
			
			System.out.println("Please select a valid option. Try again.");
		}
	}
	
	private static void checkWin()
	{
		//moves through the 3d array
		for (int[][] i : board)
		{
			for (int[] j : i)
			{
				for (int k : j)
				{
					//checks if the board isn't filled
					if (k == 0)
					{
						return;
					}
				}
			}
		}
		
		System.out.println("You win!");
		
		System.out.println("Do you want to play again?");
		String input = scanner.nextLine();
		
		if (input.equalsIgnoreCase("no"))
		{
			System.out.println("Bye bye.");
			System.exit(0);
		}
		
		System.out.println("Resetting board");
		try
		{
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(3000);
			System.out.print(".");
			TimeUnit.MILLISECONDS.sleep(3000);
			System.out.print(".");
		}
		catch (InterruptedException e) { e.printStackTrace(); }
		System.out.println();
		
		playGame();
	}
}
