
public class CodingBatTest
{

	public static void main(String[] args)
	{
		int[] nums = {5, 1, 7, 3, 7, 8, 1};
		
		System.out.println(maxTriple(nums));
	}

	public static int maxTriple(int[] nums)
	{
		int biggest = nums[0];
		
		for (int i = 1; i < nums.length; i++)
		{
			if (biggest < nums[i])
			{
				biggest = nums[i];
			}
		}
		
		return biggest;
	}

}
