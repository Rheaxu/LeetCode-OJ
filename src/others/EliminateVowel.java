package others;

public class EliminateVowel 
{
	private static char[] vowels = {'a','e','i','o','u'};
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static String eliminateVowelString(String string){
	
    // Eliminate all the vowels from the input string
    // Return the string without vowels
    // INSERT YOUR CODE HERE
	StringBuilder str = new StringBuilder();
	
	for(int i=0;i<string.length();i++)
	{
		if(!isVowel(string.charAt(i)))
		{	
			str.append(string.charAt(i));
		}
	}
	
	
	
	return str.toString();
  } 
// METHOD SIGNATURE ENDS
  
	public static boolean isVowel(char c)
	{
		for(int i=0;i<vowels.length;i++)
		{
			if(vowels[i] == c || Character.toUpperCase(vowels[i])==c) return true;
		}
		return false;
	}

// DO NOT IMPLEMENT THE main( ) METHOD
  public static void main(String[] args) 
  {
    // PLEASE DO NOT MODIFY THIS FUNCTION
    // YOUR FUNCTION SHALL BE AUTOMATICALLY CALLED AND THE INPUTS FROM HERE SHALL BE PASSED TO IT
    String string="abcdefghijklmnopqrstuvwxyz";
    String result; 
    // ASSUME INPUTS HAVE ALREADY BEEN TAKEN
    result=eliminateVowelString(string);
    System.out.println(result);
    // Print the output
  }
}
