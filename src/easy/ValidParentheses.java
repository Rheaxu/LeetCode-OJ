package easy;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args)
	{
		ValidParentheses vp = new ValidParentheses();
		String s = "]";
		System.out.println(vp.isValid(s));
	}
	
	public boolean isValid(String s)
	{
		Stack<String> stack  = new Stack<String>();
		for(int i=0;i<s.length();i++)
		{
			String str = s.substring(i, i+1);
			if(str.equals("(")||str.equals("{")||str.equals("["))
			{
				stack.push(str);
				continue;
			}
			if(stack.isEmpty()) return false;
			String str2 = stack.pop();
			if(str.equals(")"))
				if(!str2.equals("(")) return false;
			if(str.equals("]"))
				if(!str2.equals("[")) return false;
			if(str.equals("}"))
				if(!str2.equals("{")) return false;
		}
		if(stack.size()!=0) return false;
		return true;
	}
}
