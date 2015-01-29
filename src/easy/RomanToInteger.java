package easy;

public class RomanToInteger {

	public static void main(String[] args)
	{
		RomanToInteger rti = new RomanToInteger();
		String s = "MCMXCVI";
		int r = rti.romanToInt(s);
		System.out.println(r);
	}
	
	public int romanToInt(String s)
	{
		if(s.length() == 0) return 0;
		int result = 0;
		char last = s.charAt(0);
		int acc = getInt(last);
		for(int i=1;i<s.length();i++)
		{
			char cur = s.charAt(i);
			int curint = getInt(cur),lastint = getInt(last);
			if(cur == last)
			{
				acc += getInt(cur);
			}
			else if(curint > lastint)
			{
				acc = curint - acc;
				last = cur;
				result += acc;
				acc = 0;
			}
			else
			{
 				result += acc;
				acc = curint;
				last = cur;
			}
		}
		result += acc;
		
		return result;
	}
	
	public int getInt(char c){
		switch(c){
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
		}
		
		
		return 0;
		
	}
}
