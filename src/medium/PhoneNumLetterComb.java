package medium;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumLetterComb {
	
	private final String[] dict = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	public List<String> letterCombinations(String digits) {
		
		ArrayList<String> result = new ArrayList<String>();
		result.add("");
		for(int i=0;i<digits.length();i++)
		{
			String letters = dict[new Integer(digits.substring(i, i+1))];
			ArrayList<String> newResult = new ArrayList<String>();			
			for(int j=0;j<letters.length();j++)
			{
				
				for(int m=0;m<result.size();m++)
				{
					newResult.add(result.get(m)+letters.substring(j, j+1));
				}
			}
			result = newResult;

		}
		
		return result;
    }
		
	public static void main(String args[])
	{
		PhoneNumLetterComb pnlc = new PhoneNumLetterComb();
		System.out.println(pnlc.letterCombinations(""));
	}
}
