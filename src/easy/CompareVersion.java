package easy;

public class CompareVersion {

	public static void main(String[] args)
	{
		CompareVersion cv = new CompareVersion();
		//System.out.println("".split("\\.")[0]);
		System.out.println(cv.compareVersion2("1", "1.0"));
	}
	
	
	/**
	 * My solution
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion1(String version1, String version2)
	{
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		int pos=0;
		while(pos<ver1.length && pos<ver2.length)
		{
			if((new Integer(ver1[pos])).equals(new Integer(ver2[pos])))
				pos++;
			else return (new Integer(ver1[pos]).compareTo(new Integer(ver2[pos])));
		}
		
		if(pos<ver1.length){
			for(;pos<ver1.length;pos++)
				if((new Integer(ver1[pos])).compareTo(new Integer(0))>0) return 1;
			return 0;
		}
		else if(pos<ver2.length) {
			for(;pos<ver2.length;pos++)
				if((new Integer(ver2[pos])).compareTo(new Integer(0))>0) return -1;
			return 0;
		}
		else return 0;
	}
	
	/**
	 * Other's concise solution
	 */
	public int compareVersion2(String version1,String version2)
	{
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		int len = Math.max(ver1.length, ver2.length);
		for(int i=0;i<len;i++)
		{
			Integer v1 = i<ver1.length?Integer.parseInt(ver1[i]):0;
			Integer v2 = i<ver2.length?Integer.parseInt(ver2[i]):0;
			int compare = v1.compareTo(v2);
			if(compare!=0) return compare;
		}
		
		return 0;
	}
	
}
