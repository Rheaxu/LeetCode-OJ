package easy;

public class RemoveElement {
	
	public static void main(String[] args)
	{
		int[] A = {2,3,5,1,6,2,2,7,8,3};
		RemoveElement re = new RemoveElement();
		int l = re.removeElement(A, 2);
		for(int i=0;i<A.length;i++)
		System.out.print(A[i]+" ");
		System.out.println("\n"+l);
	}

	/**
	 * Refers to other's solution
	 * @param A
	 * @param elem
	 * @return
	 */
	public int removeElement(int[] A,int elem)
	{
		int len = A.length;
		for(int i=0;i<A.length;i++)
		{
			while(A[i]==elem&&i<len)
			{
				A[i]=A[--len];
			}
		}
		return len;
	}
	
}
