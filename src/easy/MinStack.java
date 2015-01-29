package easy;

import java.util.Stack;

public class MinStack {

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minstack = new Stack<Integer>();
	
	public void push(int x)
	{
		stack.push(x);
		if(minstack.size()!=0)
		{
			int min = minstack.peek();
			if(x<=min) minstack.push(x);
			else minstack.push(min);
		}
		else minstack.push(x);
	}
	
	public void pop()
	{
		stack.pop();
		minstack.pop();
	}
	
	public int top()
	{
		return stack.peek();
	}
	
	public int getMin()
	{
		return minstack.peek();
	}
}
