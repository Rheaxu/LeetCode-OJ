package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args)
	{
		PascalTriangle pt = new PascalTriangle();
		//List<Integer> row = pt.getRow1(3);
		List<List<Integer>> allrows = pt.generate(0);
		for(int j=0;j<allrows.size();j++)
		{
			List<Integer> row = allrows.get(j);
			for(int i=0;i<row.size();i++)
			{
				System.out.print(row.get(i)+" ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * My solution
	 */
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}
	
	/**
	 * My solution
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow1(int rowIndex)
	{
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		if(rowIndex == 0)return row;
		List<Integer> lastrow = new ArrayList<Integer>(row);
		
		int rowind = 1;
		while(rowind<=rowIndex)
		{
			lastrow = new ArrayList<Integer>(row);
			row.clear();
			row.add(1);
			for(int i=1;i<rowind;i++)
			{
				row.add(lastrow.get(i-1)+lastrow.get(i));
			}
			row.add(1);
			rowind++;
		}
		return row;
	}
	
	/**
	 * Solution from other
	 */
	public List<Integer> getRow2(int rowIndex)
	{
		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		for(int i=1;i<=rowIndex;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
		}		
		return row;
	}
}
