package easy;

import java.util.Stack;

public class ClimbingStairs {
	
	public static void main(String[] args)
	{
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs2(2));
	}
	
	/**
	 * Solution by referring to other's
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n)
	{
		int[] steps = new int[n+1];
		steps[0] = 1;
		steps[1] = 1;
		for(int count=2;count <= n;count++)
			steps[count] = steps[count-1]+steps[count-2];
		return steps[n];
	}
	
	/**
	 * My solution. Very slow method
	 * @param n
	 * @return
	 */
	public int climbStairs1(int n) {
		if(n<=0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		return climbStairs1(n-1)+climbStairs1(n-2);
    }
}
