package easy;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	
	public static void main(String[] args)
	{
		Set<Integer> numset = new HashSet<Integer>();
		numset.add(1);
		numset.add(1);
		String[] boardstr = {
				"....5..1.",".4.3.....",".....3..1",
				"8......2.","..2.7....",".15......",
				".....2...",".2.9.....","..4......"};
		char[][] board = new char[9][9];
		for(int i=0;i<9;i++)
		{
			char[] schar = boardstr[i].toCharArray();
			for(int j=0;j<9;j++)
			{
				board[i][j] = schar[j];
			}
		}
		ValidSudoku vs = new ValidSudoku();
		System.out.println(vs.isValidSudoku1(board));
	}
	/**
	 * Other's concise version
	 * Check whether the cubes in the given range are valid
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku1(char[][] board)
	{
		for(int i=0;i<9;i++)
		{
			if(!isPartialValid(board,i,0,i,8)) return false;
			if(!isPartialValid(board,0,i,8,i)) return false;
		}
		
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(!isPartialValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
		
		return true;
	}
	private boolean isPartialValid(char[][] board,int x1,int y1,int x2,int y2)
	{
		Set<Integer> numset = new HashSet<Integer>();
		for(int i=x1;i<=x2;i++)
		{
			for(int j=y1;j<=y2;j++)
				if(board[i][j]!='.')
					if(!numset.add(Character.getNumericValue(board[i][j])))return false;
		}
		
		return true;
	}
	
	/**
	 * My Solution
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
        	int count = 0;
        	Set<Integer> numset = new HashSet<Integer>();
        	for(int j=0;j<9;j++)
        	{
        		if(board[i][j]!='.')
        		{
        			count++;
        			numset.add(Character.getNumericValue(board[i][j]));
        		}
        	}
        	if(count!=numset.size()) return false;
        }
        
        for(int j=0;j<9;j++)
        {
        	Set<Integer> numset = new HashSet<Integer>();
        	int count = 0;
        	for(int i=0;i<9;i++)
        	{
        		if(board[i][j]!='.')
        		{
        			count++;
        			numset.add(Character.getNumericValue(board[i][j]));
        		}
        		if(count!=numset.size()) return false;
        	}
        }
        
        for(int i=0;i<3;i++)
        {
        	for(int j=0;j<3;j++)
        	{
    			int count = 0;
    			Set<Integer> numset = new HashSet<Integer>();
        		for(int m=0;m<3;m++)
        		{
        			for(int n=0;n<3;n++)
        			{
        				char c = board[i*3+m][j*3+n];
        				if(c!='.')
        				{
        					count++;
        					numset.add(Character.getNumericValue(c));
        				}
        			}
        		}
				if(count!=numset.size()) return false;
        	}
        }
		
		return true;
    }
}
