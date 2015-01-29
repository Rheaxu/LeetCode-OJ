package others;

import java.util.Random;

public class GenerateNumbers {

	
	public static void main(String[] args)
	{
		Random rand = new Random();
		int min = 15;
		int randomNum = rand.nextInt((Integer.MAX_VALUE - min) + 1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.BYTES);
		System.out.println(randomNum);
	}
}
