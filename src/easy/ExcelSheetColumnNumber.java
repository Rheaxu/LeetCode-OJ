package easy;

public class ExcelSheetColumnNumber {
	
	public static void main(String[] args)
	{
		String str = "LM";
		ExcelSheetColumnNumber esdn = new ExcelSheetColumnNumber();
		System.out.println(esdn.titleToNumber2(str));
	}
	
	/**
	 * My solution
	 * @param s
	 * @return
	 */
	public int titleToNumber1(String s) 
	{
		int count = 0;
		int num = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
        	char c = s.charAt(i);
        	num += Math.pow(26.0, count++)*(c-64);
        }
        return num;
    }
	
	public int titleToNumber2(String s)
	{
		int num = 0;
		for(int i=0;i<s.length();num=num*26+(s.charAt(i)-'A'+1),i++);
		return num;
	}
}
