import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Board
{
	private Tile[][] board;
	
	public Board(Tile[][] board)
	{
		this.board = board;
	}
	
	public Tile[][] getBoard()
	{
		return board;
	}
	
	public void setBoardPos(int posY, int posX, Tile tile)
	{
		this.board[posY][posX] = tile;
	}
	
	public void print()
	{
		System.out.println("   0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < board.length; i++)
		{
			System.out.print((i) + " ");
			
			System.out.print("[");
			
			for (int j = 0; j < board[i].length; j++)
			{
				System.out.print(board[i][j]);
				if (j < board[i].length - 1)
					System.out.print(" ");
			}
			System.out.println("]");
		}
	}
	
	public boolean checkWin()
	{
		int revealedCount = 0;
		
		for (Tile[] row : board)
		{
			for (Tile tile : row)
			{
				if (tile.isRevealed() && !tile.isBomb())
				{
					revealedCount++;
				}
			}
		}
		
		if (revealedCount == (board.length * board[0].length) - 10)
		{
			System.out.println("YOU WIN!");
			return true;
		}
		
		return false;
	}
	
	public void reveal(int posY, int posX)
	{
		ArrayList<int[]> posList = new ArrayList<>();
		
		move(posY, posX, posList);
		
		for (int[] pos : posList)
		{
			board[pos[0]][pos[1]].setRevealed(true);
		}
	}
	
	public void move(int posY, int posX, List<int[]> list)
	{
		list.add(new int[] {posY, posX});
		
		int y = posY;
		int x = posX;
		
		moveY(y, x, list);
		
		while (x < board[y].length - 1 && board[y][x].getBombsSurrounding() == 0)
			moveY(y, ++x, list);
		moveY(y, x, list);
		
		y = posY;
		x = posX;
		
		while (x > 0 && board[y][x].getBombsSurrounding() == 0)
			moveY(y, --x, list);
		moveY(y, x, list);
		
		y = posY;
		x = posX;
		
		while (y < board.length - 1 && board[y][x].getBombsSurrounding() == 0)
			moveX(++y, x, list);
		moveX(y, x, list);
		
		y = posY;
		x = posX;
		
		while (y > 0 && board[y][x].getBombsSurrounding() == 0)
			moveX(--y, x, list);
		moveX(y, x, list);
	}
	
	public void moveY(int posY, int posX, List<int[]> list)
	{
		list.add(new int[] {posY, posX});
		
		int y = posY;
		int x = posX;
		
		while(y < board.length - 1 && board[y][x].getBombsSurrounding() == 0)
			list.add(new int[] {++y, x});
		
		y = posY;
		x = posX;
		
		while (y > 0 && board[y][x].getBombsSurrounding() == 0)
			list.add(new int[] {--y, x});
	}
	
	public void moveX(int posY, int posX, List<int[]> list)
	{
		list.add(new int[] {posY, posX});
		
		int y = posY;
		int x = posX;
		
		while (x < board[y].length - 1 && board[y][x].getBombsSurrounding() == 0)
			list.add(new int[] {y, ++x});
		
		y = posY;
		x = posX;
		
		while(x > 0 && board[y][x].getBombsSurrounding() == 0)
			list.add(new int[] {y, --x});
	}
}
