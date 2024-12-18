package sorting;

/**
 * Class for bubble sorting
 */
public class BubbleSort
{	
	/**
	 * Method for the algorithm
	 * @param array
	 */
	public static void bubbleSort(int[] array)
	{
		/*
		 * loops through the array
		 * - stores the current and next values in the array
		 * - checks if the current vlue is greater than the next value
		 *   - swaps them
		 */
		for (int i = 0; i < array.length - 1; i++)
		{
			int currentValue = array[i];
			int nextValue = array[i + 1];
			
			if (currentValue > nextValue)
			{
				array[i] = nextValue;
				array[i + 1] = currentValue;
			}
		}
		
		/*
		 * loops through the array
		 * - checks if the current item is greater than the next time
		 *   - recursion
		 */
		for (int i = 0; i < array.length - 1; i++)
		{
			if (array[i] > array[i + 1])
			{
				bubbleSort(array);
			}
		}
	}
}
