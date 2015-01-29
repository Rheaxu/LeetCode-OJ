package easy;


/**
 * 
 * @author Rhea
 * TODO: Need to practice again and again
 */
public class ZigzagConvertion {
	public String convert(String s, int nRows) {
		char[] cs = s.toCharArray();
		StringBuilder[] sb = new StringBuilder[nRows];
		for(int n=0;n<nRows;n++) sb[n] = new StringBuilder();

		int i = 0;
		while(i<s.length())
		{
			for(int ind=0;ind<nRows && i<s.length();ind++)
			{
				sb[ind].append(cs[i++]);
			}
			for(int ind=nRows-2;ind>=1 && i<s.length();ind--)
			{
				sb[ind].append(cs[i++]);
			}
		}
	
		for(int j=1; j<sb.length;j++) sb[0].append(sb[j]);
		
		return sb[0].toString();
	}

	
	public static void main(String[] args)
	{
		ZigzagConvertion zc = new ZigzagConvertion();
		String ss = zc.convert("PAYPALISHIRING",3);
		System.out.println(ss);
	}
}
