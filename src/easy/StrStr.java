package easy;

public class StrStr {

	public static void main(String[] args)
	{
		String haystack = "findinahaystackneedleina";
		String needle = "needle";
		StrStr ss = new StrStr();
		System.out.println(ss.strStr3(haystack, needle));
	}
	
	public String strStr3(String haystack, String needle) {
	    //KMP algorithms
	    if(needle.equals("")) return haystack;
	    if(haystack.equals("")) return null;
	    char[] arr = needle.toCharArray();
	    int[] next = makeNext(arr);

	    for(int i = 0, j = 0, end = haystack.length(); i < end;){
	        if(j == -1 || haystack.charAt(i) == arr[j]){
	            j++;
	            i++;
	            if(j == arr.length) return haystack.substring(i - arr.length);
	        }
	        if(i < end && haystack.charAt(i) != arr[j]) j = next[j];
	    }
	    return null;
	}

	private int[] makeNext(char[] arr){
	    int len = arr.length;
	    int[] next = new int[len];

	    next[0] = -1;
	    for(int i = 0, j = -1; i + 1 < len;){
	        if(j == -1 || arr[i] == arr[j]){
	            next[i+1] = j+1;
	            if(arr[i+1] == arr[j+1]) next[i+1] = next[j+1];
	            i++;
	            j++;
	        }
	        if(arr[i] != arr[j]) j = next[j];
	    }

	    return next;
	}
	
	/**
	 * Boyer-Moore Algorithm
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr2(String haystack, String needle)
	{
		char[] text = haystack.toCharArray();
		char[] pattern = needle.toCharArray();
		if(text.length<pattern.length) return -1;
		int tstartind = 0,pind = pattern.length-1,tind=tstartind+pind;
		while(tind<text.length){
			while(pind>=0&&text[tind] == pattern[pind])
			{
				tind--;pind--;
			}
			if(pind<0) return tstartind;
			while(pind>=0&&text[tind]!=pattern[pind])
			{
				pind--;
			}
			tstartind = tind-pind;
			pind = pattern.length-1;
			tind = tstartind+pind;
		}
		return -1;
	}
	
	public int strStr(String haystack, String needle) {
        int ind = -1, endind=needle.length();
        if(haystack.length()<needle.length()) return ind;
        if(haystack == null&& needle == null || needle == "") return 0;
        char[] str = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int patternhash = 0, matchhash = 0;
        for(int i=0;i<pattern.length;i++)
        {
        	patternhash += pattern[i];
        	matchhash += str[i];
        }
        if(matchhash == patternhash)
    	{
    		int j=0;
    		for(;j<pattern.length;j++)
    		{
    			if(pattern[j]!=str[j])break;
    		}
    		if(j==pattern.length)return 0;
    	}
        for(ind=1;endind<str.length;endind++,ind++)
        {
        	matchhash = matchhash-str[ind-1]+str[endind];
        	if(matchhash == patternhash)
        	{
        		int j=0;
        		for(;j<pattern.length;j++)
        		{
        			if(pattern[j]!=str[ind+j])break;
        		}
        		if(j==pattern.length)return ind;
        	}
        }
        return -1;
    }
}
