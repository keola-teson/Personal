package sorting;

/**
 * Class to sort with insetion sort
 * (code based on psuedo code i found on the internet)
 */
public class InsertionSort
{	
	public static void insertionSort(int[] array)
	{
		//loops through the array
		for (int i = 0; i < array.length; i++)
		{
			//declares j and gives it the value i
			int j = i;
			//loops while j > 0 and the current item is less than the last item
			while (j > 0 && array[j] < array[j - 1])
			{
				//stores the current and last value
				int thisValue = array[j];
				int lastValue = array[j - 1];
				
				//swaps them
				array[j] = lastValue;
				array[j - 1] = thisValue;
				
				//decrements j
				j--;
			}
		}
	}
}
