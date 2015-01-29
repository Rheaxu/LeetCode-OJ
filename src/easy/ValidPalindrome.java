package easy;

public class ValidPalindrome {

	public static void main(String[] args)
	{
		String s = "A man, a plan, a canal: Panama";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome2(s));
	}
	/**
	 * Version1
	 * @param s
	 * @return
	 */
	public boolean isPalindrome1(String s) 
	{
		if(s=="" || s==null) return true;
		int i=0,j=s.length()-1;
        while(i<j)
        {
        	char leftc = s.charAt(i);
        	char rightc = s.charAt(j);
        	if(!((leftc>=97 && leftc<=122) || (leftc>=65 && leftc<=90) || (leftc>=48 && leftc<=57)))
        	{
        		i++;
        		continue;
        	}
        	if(!((rightc>=97 && rightc<=122) || (rightc>=65 && rightc<=90) || (rightc>=48 && rightc<=57)))
        	{
        		j--;
        		continue;
        	}
        	if(!s.substring(i, i+1).toLowerCase().equals(s.substring(j,j+1).toLowerCase()))
        		return false;
        	i++;
        	j--;
        }
		return true;
    }
	
	/**
	 * Version modified from other's
	 */
	public boolean isPalindrome2(String s)
	{
		s = s.toLowerCase();
		s = s.replaceAll("[^0-9a-z]", "");
		char[] cs = s.toCharArray();
		int i=0,j=cs.length-1;
		while(i<j)
		{
			if(cs[i]!=cs[j]) return false;
			i++;
			j--;
		}
		return true;
	}
	
}
