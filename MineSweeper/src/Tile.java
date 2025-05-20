
public class Tile
{
	/* Class Attributes */
	private boolean isBomb; // is bomb
	private int bombsSurrounding; // the amount of bombs surrounding
	private boolean hasFlag; // has flag
	private boolean isRevealed; // is revealed

	/**
	 * CONSTRUCTOR
	 * @param isBomb
	 * @param bombsSurrounding
	 * @param hasFlag
	 * @param isRevealed
	 */
	public Tile(boolean isBomb, int bombsSurrounding, boolean hasFlag, boolean isRevealed)
	{
		this.isBomb = isBomb;
		this.bombsSurrounding = bombsSurrounding;
		this.hasFlag = hasFlag;
		this.isRevealed = isRevealed;
	}

	/**
	 * @return the isBomb
	 */
	public boolean isBomb()
	{
		return isBomb;
	}

	/**
	 * @param isBomb the isBomb to set
	 */
	public void setBomb(boolean isBomb)
	{
		this.isBomb = isBomb;
	}

	/**
	 * @return the bombsSurrounding
	 */
	public int getBombsSurrounding()
	{
		return bombsSurrounding;
	}

	/**
	 * @param bombsSurrounding the bombsSurrounding to set
	 */
	public void setBombsSurrounding(int bombsSurrounding)
	{
		this.bombsSurrounding = bombsSurrounding;
	}

	/**
	 * @return the hasFlag
	 */
	public boolean isHasFlag()
	{
		return hasFlag;
	}

	/**
	 * @param hasFlag the hasFlag to set
	 */
	public void setHasFlag(boolean hasFlag)
	{
		this.hasFlag = hasFlag;
	}

	/**
	 * @return the isRevealed
	 */
	public boolean isRevealed()
	{
		return isRevealed;
	}

	/**
	 * @param isRevealed the isRevealed to set
	 */
	public void setRevealed(boolean isRevealed)
	{
		this.isRevealed = isRevealed;
	}
	
	
	@Override
	public String toString()
	{
		if (isRevealed)
		{
			if (hasFlag)
				return "Y";
			
			if (isBomb)
				return "X";
			
			if (bombsSurrounding == 1)
				return "1";
			else if (bombsSurrounding == 2)
				return "2";
			else if (bombsSurrounding == 3)
				return "3";
			else if (bombsSurrounding == 4)
				return "4";
			else if (bombsSurrounding == 5)
				return "5";
			else if (bombsSurrounding == 6)
				return "6";
			else if (bombsSurrounding == 7)
				return "7";
			else if (bombsSurrounding == 8)
				return "8";
			
			return " ";
		}
		
		return "O";
	}
}
