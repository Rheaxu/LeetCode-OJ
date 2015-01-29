package easy;

public class RemoveDuplicatesFromSortedArr {

	public static void main(String[] args)
	{
		RemoveDuplicatesFromSortedArr rd = new RemoveDuplicatesFromSortedArr();
		int[] A = {1,2,2,3,3,4,6,7,7,8,9};
		int len = rd.removeDuplicates2(A);
		for(int i=0;i<len;i++)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println("\n"+len);
	}
	
	/**
	 * Concise code by referring to other's
	 * @param A
	 * @return
	 */
	public int removeDuplicates2(int[] A)
	{
		if(A==null) return 0;
		if(A.length<2) return A.length;
		int len = 1;
		for(int i=1;i<A.length;i++)
			if(A[i]!=A[i-1])A[len++] = A[i];
		return len;
	}
	
	/**
	 * My solution
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A)
	{
		if(A==null||A.length==0) return 0;
		if(A.length==1) return 1;
		int n=-1,last = A[0];
		for(int i=1;i<A.length;)
		{
			
			while(i<A.length && A[i] == last)i++;
			A[++n]=last;
			if(i<A.length) last = A[i];
		}
		if(n<A.length-1)
		{
			A[++n] = last;return n;
		}
		
		return ++n;
	}
}
