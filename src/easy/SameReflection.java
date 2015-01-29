package easy;

public class SameReflection {
	public int isSameReflection(String word1, String word2)
	{
		if(word1.length()>100 || word2.length()>100) return -1;
		if(!word1.matches("[a-z]*")) return -1;
		if(!word2.matches("[a-z]*")) return -1;
		if(word1.length()!=word2.length()) return -1;
		int wordlen = word1.length();
		if(wordlen == 0) return -1;
		
		int[][] match = new int[wordlen][wordlen];
		int maxpathlen = 0;
		int maxi=0,maxj=0;
		StringBuilder[][] pathrcd = 
				new StringBuilder[wordlen][wordlen];

		for(int j=0;j<wordlen;j++)
		{
			if(word1.charAt(0) == word2.charAt(j))
			{
				match[0][j] = 1;	
				pathrcd[0][j] = new StringBuilder("0,"+j);
			}
			else
				pathrcd[0][j] = new StringBuilder("");
		}
		maxpathlen = match[0][wordlen-1];
		maxi = 0;
		maxj = wordlen-1;

		for(int i=0;i<wordlen;i++)
		{
			if(word2.charAt(0) == word1.charAt(i))
			{
				match[i][0] = 1;
				pathrcd[i][0] = new StringBuilder(i+",0");
			}
			else
				pathrcd[i][0] = new StringBuilder("");
		}
		if(match[wordlen-1][0]>maxpathlen)
		{
			maxpathlen = match[wordlen-1][0];
			maxi=wordlen-1;
			maxj=0;
		}
		
		for(int i=1;i<wordlen;i++)
		{
			for(int j=1;j<wordlen;j++)
			{
				if(word1.charAt(i) == word2.charAt(j))
				{
					match[i][j] = match[i-1][j-1]+1;
					if(pathrcd[i-1][j-1].length()==0)
						pathrcd[i][j] = new StringBuilder(pathrcd[i-1][j-1].toString()+i+","+j);
					else
						pathrcd[i][j] = new StringBuilder(pathrcd[i-1][j-1].toString()+"->"+i+","+j);
				}
				else
				{
					match[i][j] = match[i-1][j-1];
					pathrcd[i][j] = new StringBuilder("");
				}
								
				if(j==wordlen-1 && match[i][j]>maxpathlen)
				{
					maxpathlen = match[i][j];
					maxi = i;
					maxj = j;
				}

				if(i==wordlen-1 && match[i][j] > maxpathlen)
				{
					maxpathlen = match[i][j];
					maxi = i;
					maxj = j;
				}
			}
		}
		
		/*for(int i=0;i<wordlen;i++)
		{
			for(int j=0;j<wordlen;j++)
			{
				System.out.print(pathrcd[i][j]+"|");
			}
			System.out.println();
			
		}*/
		
		if(match[maxi][maxj] == 0 || pathrcd[maxi][maxj].equals("")) return -1;
		String[] indices = pathrcd[maxi][maxj].toString().split("->");
		if(indices.length==0 || indices.length==1 && indices[0].equals("")) return -1;
		String[] firstind = indices[0].split(",");
		String[] lastind = indices[indices.length-1].split(",");
		int firstindi = new Integer(firstind[0]);
		int firstindj = new Integer(firstind[1]);
		int lastindi = new Integer(lastind[0]);
		int lastindj = new Integer(lastind[1]);
		int anothermatchlen = 0;
		if(lastindi ==wordlen-1 && lastindj == wordlen-1 && 
				firstindi == 0 && firstindj == 0)
			return 1;
		if(lastindi == wordlen-1 && firstindj == 0)
		{
			anothermatchlen = match[firstindi-1][wordlen-1];
		}
		else if(lastindj == wordlen-1 && firstindi == 0)
		{
			anothermatchlen = match[wordlen-1][firstindj-1];
		}
		else
			return -1;
		if(anothermatchlen+maxpathlen == wordlen) return 1;
		System.out.println(pathrcd[maxi][maxj]);
		
		return -1;
		
	}
	
	
	public static void main(String[] args)
	{
		SameReflection sr = new SameReflection();
		int result = sr.isSameReflection("cccccveedef", "cceeedefccc");
		System.out.println(result);
	}
}
