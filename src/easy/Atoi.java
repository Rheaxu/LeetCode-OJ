package easy;

public class Atoi {

	
	public static void main(String[] args)
	{
		Integer i = new Integer("+1");
		//System.out.println(i);
		Atoi a = new Atoi();
		System.out.println(a.atoi2("-2147483647"));
	}
	/**
	 * My solution
	 * @param str
	 * @return
	 */
	public int atoi1(String str)
	{
		if(str.length()==0) return 0;
		int i = 0,result=0,digitcount=0;
		while(str.charAt(i)==' ') i++;
		char sign = '+';
		if(str.charAt(i)=='-' || str.charAt(i)=='+') sign = str.charAt(i++);
		while(i<str.length()&&str.substring(i, i+1).matches("[0-9]"))
		{
			result = result*10+(int)str.charAt(i++)-48;
			digitcount++;
		}
		if(result == 0) return 0;
		else if(sign == '-') result = -result;
		if(sign=='+'&&(result<0 || digitcount > 10)) return Integer.MAX_VALUE;
		if(sign=='-'&&(result>0 || digitcount > 10)) return Integer.MIN_VALUE;
		
		return result;
	}
	
	
	/**
	 * Solution referred to others
	 */
	public int atoi2(String str)
	{
		int result = 0, i=0;
		if(str.length()==0) return 0;
		char sign = '+';
		while(str.charAt(i)==' ') i++;
		if(str.charAt(i)=='-' || str.charAt(i)=='+') sign = str.charAt(i++);

		while(i<str.length()&&str.substring(i, i+1).matches("[0-9]"))
		{
			if(result > Integer.MAX_VALUE/10 || (result >= Integer.MAX_VALUE/10 && str.charAt(i)>'7'))
			{
				if(sign == '+') return Integer.MAX_VALUE;
				else return Integer.MIN_VALUE;
			}
			result = result*10+(int)str.charAt(i++)-'0';
		}
		
		return sign=='+'?result:-result;
	}
}
