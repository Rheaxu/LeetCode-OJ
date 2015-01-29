package easy;

/**
 * 
 * @author Rhea
 * !!!Not work with 1534236469 -> 1056389759
 */
public class ReverseDigits {

    public int reverse(int x) {
	   int ret = 0;
	   while (x != 0) {
	      // handle overflow/underflow
	      if (Math.abs(ret) > 2147483647) {
	         return 0;
	      }
	      ret = ret * 10 + x % 10;
	      x /= 10;
	   }
	   return ret;
	}
    
    public static void main(String[] args)
    {
    	ReverseDigits rd = new ReverseDigits();
    	System.out.print(rd.reverse(1534236469));
    }
}
