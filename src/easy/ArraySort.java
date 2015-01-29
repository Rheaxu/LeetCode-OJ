package easy;

public class ArraySort {
	public void merge(int A[], int m, int B[], int n) {
		int counterA=m,counterB = n;
		
		while(counterA+counterB>0 && counterB>0)
		{
			if(counterA>0 && A[counterA-1]>B[counterB-1]){
				A[counterA+counterB-1] = A[counterA-1];
				counterA--;
			}
			else{
				A[counterA+counterB-1] = B[counterB-1];
	        	counterB--;		
			}
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(0<1?"a":"b");
	}
}
