package datastructure;

import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> stack = new ArrayList<Integer>();
    ArrayList<Integer> minstack = new ArrayList<Integer>();
    int size = 0;
    
    void push(int x)
    {
        if(stack.isEmpty())
        {
            minstack.add(x);
            stack.add(x);
        }
        else
        {
        	stack.add(x);
            int oldmin = minstack.get(size-1);
            if(x < oldmin) minstack.add(x);
            else minstack.add(oldmin);
        }
        size ++;
    }
    
    void pop()
    {
        stack.remove(size-1);
        minstack.remove(size-1);
    }
    
    int top()
    {
        return stack.get(size-1);
    }
    
    int getMin()
    {
        return minstack.get(size-1);
    }
    
    public static void main(String[] args)
    {
    	MinStack mins = new MinStack();
    	mins.push(0);
    	mins.push(1);
    	mins.push(9);
    	mins.push(5);
    	mins.push(4);
    	mins.push(-3);
    	mins.push(6);
    	System.out.println(mins.size);
    	System.out.println(mins.stack);
    	System.out.println(mins.minstack);
    	System.out.println(mins.getMin());
    	System.out.println(mins.top());
    }
}