package easy;

public class ExcelSheetColumnTitle {
	
	public static void main(String[] args)
	{
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle2(325));
	}
	/**
	 * My solution
	 * @param n
	 * @return
	 */
	public String convertToTitle1(int n)
	{
		StringBuilder title = new StringBuilder();
		
		while(n>0)
		{
			if(n<=26){
				title.insert(0, Character.toString((char)(65+n-1)));
				break;
			}
			else{
				int remain = n%26;
				title.insert(0,Character.toString((char)(remain==0?90:(65+remain-1))));
				n = n/26;
				if(remain == 0) n--;
			}
		}
		
		return title.toString();
	}
	
	/**
	 * Most votes solution
	 */
	public String convertToTitle2(int n)
	{
		return n == 0 ? "" : convertToTitle2(--n / 26) + (char)('A' + (n % 26));
	}
}
