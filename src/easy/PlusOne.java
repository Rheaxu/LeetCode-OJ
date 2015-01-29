package easy;

import java.util.Stack;

public class PlusOne {
	
	public static void main(String[] args)
	{
		int[] arr = {1,0,3};
		PlusOne po = new PlusOne();
		int[] result = po.plusOne(arr);
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i]+" ");
		}
	}
	
	public int[] plusOne(int[] digits) {

		int lastdigit=0;
		for(int i=digits.length-1;i>=0;i--)
		{
			lastdigit = digits[i];
			lastdigit++;
			if(lastdigit<10)
			{ 
				digits[i] = lastdigit;
				break;
			}
			digits[i] = lastdigit%10;
		}
		if(lastdigit<10) return digits;
		int[] arr = new int[digits.length+1];
		arr[0] = 1;
		for(int i=0;i<digits.length;i++)
		{
			arr[i+1] = digits[i];
		}
		return arr;
    }
}
