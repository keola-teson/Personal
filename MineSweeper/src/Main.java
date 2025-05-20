import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		playGame();
	}

	public static void playGame()
	{
		Board board = createBoard(4, 4);
		Scanner scanner = new Scanner(System.in);
		
		board.print();
		
//		System.out.println("Choose X position:");
//		int x = scanner.nextInt();
//		
//		System.out.println("Choose Y position:");
//		int y = scanner.nextInt();
//		
//		while (!board.getBoard()[y][x].isBomb())
//		{
//			
//		}
		
		board.checkWin();
		
		scanner.close();
	}
	
	public static Board createBoard(int posY, int posX)
	{
		Tile[][] tiles = new Tile[10][10];
		
		/* fills the tiles with empty tiles to avoid a NullPointerException */
		for (int i = 0; i < tiles.length; i++)
		{
			for (int j = 0; j < tiles[i].length; j++)
			{
				tiles[i][j] = new Tile(false, 0, false, false);
			}
		}
		
		/* randomly picks 10 spots on the tiles and puts a bomb there */
		for (int i = 0; i <= 10; i++)
		{
			int randY = (int)(Math.random() * tiles.length);
			int randX = (int)(Math.random() * tiles[randY].length);
			
			if ((randY == posY || randY == posY + 1 || randY == posY - 1) && (randX == posX || randX == posX + 1 || randX == posX - 1))
				i--;
			else
				tiles[randY][randX] = new Tile(true, 0, false, true); // first true is for bomb attribute
		}
		
		/* puts the numbers on the tiles */
		for (int i = 0; i < tiles.length; i++)
		{
			for (int j = 0; j < tiles[i].length; j++)
			{
				if (!tiles[i][j].isBomb()) // checked to not override bomb tiless
				{
					int bombCount = 0;
					
					/* checks the row above current position */
					if (i - 1 > -1) // error protection
					{
						if (j - 1 > -1 && tiles[i - 1][j - 1].isBomb()) bombCount++; // increment if found
						if (tiles[i - 1][j].isBomb()) bombCount++; // increment if found
						if (j + 1 < tiles[i].length && tiles[i - 1][j + 1].isBomb()) bombCount++; // increment if found
					}
					
					/* checks the row current position is on */
					if (j - 1 > -1 && tiles[i][j - 1].isBomb()) bombCount++; // increment if found
					if (j + 1 < tiles[i].length && tiles[i][j + 1].isBomb()) bombCount++; // increment if found
					
					/* checks the row below current position */
					if (i + 1 < tiles.length) // error protection
					{
						if (j - 1 > -1 && tiles[i + 1][j - 1].isBomb()) bombCount++; // increment if found
						if (tiles[i + 1][j].isBomb()) bombCount++; // increment if found
						if (j + 1 < tiles[i].length && tiles[i + 1][j + 1].isBomb()) bombCount++; // increment if found
					}
					
					tiles[i][j] = new Tile(false, bombCount, false, false); // overrides old object with new object with bombCount updated
				}
			}
		}
		
		Board board = new Board(tiles);
		board.reveal(posY, posX);
		
		return board;
	}
}
