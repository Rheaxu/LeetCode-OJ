package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	public static void main(String[] args)
	{
		GrayCode gc = new GrayCode();
		List<Integer> gclist = gc.grayCode2(2);
		for(int i:gclist)
			System.out.print(i+" ");
	}
	/**
	 * Other's concise code
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode2(int n)
	{
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(0);
		for(int i=0;i<n;i++)
		{
			int inc = 1<<i;
			for(int j=arr.size()-1;j>=0;j--)
				arr.add(inc+arr.get(j));
		}
		return arr;
	}
	
	/**
	 * My solution
	 * @param n
	 * @return
	 */
	public List<Integer> grayCode(int n) {
        List<Integer> gclist = new ArrayList<Integer>();
        List<String> gcstrs = grayCodeHelper(n);
        for(String code:gcstrs)
        {	System.out.println(code);
        	gclist.add(binToDec(code));
        }
        return gclist;
    }
	public List<String> grayCodeHelper(int n)
	{
		List<String> gcstrs = new ArrayList<String>();
		if(n==0)
		{
			gcstrs.add("0");
			return gcstrs;
		}
		if(n==1)
		{
			gcstrs.add("0");
			gcstrs.add("1");
			return gcstrs;
		}
		List<String> lastgcstrs = grayCodeHelper(n-1);
		for(String laststr:lastgcstrs)
			gcstrs.add("0"+laststr);
		for(int i=lastgcstrs.size()-1;i>=0;i--)
			gcstrs.add("1"+lastgcstrs.get(i));
		
		return gcstrs;
	}
	
	public int binToDec(String s)
	{
		char[] arr = s.toCharArray();
		int sum=0;
		for(int i=arr.length-1;i>=0;i--)
			sum += Math.pow(2, arr.length-i-1)*Character.getNumericValue(arr[i]);
		return sum;
	}
	
}
