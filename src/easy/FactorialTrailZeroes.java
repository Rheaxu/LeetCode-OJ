package easy;

public class FactorialTrailZeroes {
	
	public static void main(String[] args)
	{
		FactorialTrailZeroes ftz = new FactorialTrailZeroes();
		System.out.println(ftz.trailingZeroes2(30));
	}
	
	public int trailingZeroes2(int n)
	{
		int num=0;
		for(;n>0;n=n/5,num+=n);
		return num;
	}
	
	
	int[] facts;
	public int trailingZeroes(int n)
	{
		facts = new int[n+1];
		int num = calfact(n);
		int count = 0;
		while(num%10==0)
		{
			count++;
			num /= 10;
		}
		return count;
	}
	
	public int calfact(int n)
	{
		if(n==0 || n==1) return 1;
		if(facts[n]!=0) return facts[n];
		else facts[n] = calfact(n-1)*n;
		return facts[n];
	}
}
