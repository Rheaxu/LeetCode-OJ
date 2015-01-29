package easy;

public class CountAndSay {
	
	public static void main(String[] args)
	{
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(5));
	}
	
	public String countAndSay(int n)
	{
		if(n==1 || n==0) return "1";
		String curstr = "11";
		if(n==2) return curstr;
		String laststr = curstr;
		int count = 1;
		char lastchar = laststr.charAt(0);
		for(int i=2; i<n; i++)
		{
			curstr = "";
			lastchar = laststr.charAt(0);
			count = 1;
			for(int j=1;j<laststr.length();j++)
			{
				if(laststr.charAt(j) == lastchar)
					count++;
				else
				{
					curstr += ""+count+lastchar;
					count = 1;
					lastchar = laststr.charAt(j);
				}
			}
			curstr += ""+count+lastchar;
			laststr = curstr;

		}
		
		return curstr;
	}
}
