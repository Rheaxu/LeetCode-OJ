package easy;

public class PalindromeNum {
	public static void main(String[] args)
	{
		int a = 100;
		//System.out.println(a);
		PalindromeNum pn = new PalindromeNum();
		System.out.println(pn.isPalindrome1(a));
	}
	
	public boolean isPalindrome1(int x)
	{
		int rev = 0;
		int inputx = x;
		while(x>0)
		{
			rev = rev*10+x%10;
			x /= 10;
		}
		return inputx==rev;
	}
	
	
}
