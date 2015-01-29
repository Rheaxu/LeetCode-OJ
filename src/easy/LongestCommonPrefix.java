package easy;

public class LongestCommonPrefix {

	public static void main(String[] args)
	{
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] ss = {"abced","abceg","abcop"};
		System.out.println(lcp.longestCommonPrefix(ss));
	}
	
	public String longestCommonPrefix(String[] strs) 
	{
		if(strs.length==0) return "";
		StringBuilder str = new StringBuilder("");
		for(int i=0;i<strs[0].length();i++)
		{
			int j = 0;
			char last = strs[0].charAt(i);
			while(j<strs.length)
			{
				if(i>=strs[j].length() || last != strs[j].charAt(i)) return str.toString();
				j++;
			}
			str.append(last);
		}
		return str.toString();
    }
}
