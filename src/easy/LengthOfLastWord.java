package easy;

public class LengthOfLastWord {

	public static void main(String[] args)
	{
		String s = " ";
		LengthOfLastWord lolw = new LengthOfLastWord();
		System.out.println(lolw.lengthOfLastWord(s));
	}
	
	public int lengthOfLastWord(String s) {
        if(s==null||s.isEmpty()) return 0;
        String[] ss = s.split(" ");
        if(ss.length==0) return 0;
        return ss[ss.length-1].length();
    }
}
