package easy;


public class MajorElem {	
	
	public static void main(String[] args)
	{
		MajorElem me = new MajorElem();
		int[] nums = {2,3,3,3,1,4,3,3,5};
		System.out.println(me.majorityElement(nums));
	}
	
	public int majorityElement(int[] num) {
        int maj=0;
        int count = 0;
        int n = num.length;
        for (int i = 0; i < n; i++){
            if (count == 0){
                maj = num[i];
                count++;
            }
            else if (num[i] == maj){
                count++;
                if (count > n/2) return maj;
            }
            else count--;
        }
        return maj;
    }
}
