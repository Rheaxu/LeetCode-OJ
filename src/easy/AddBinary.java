package easy;

import java.util.Stack;

public class AddBinary {

	public static void main(String[] args)
	{
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary2("111", "11"));
	}
	
	/**
	 * Referring other's
	 * ^: exclusive or --- 1^1=0, 0^0=0, 1^0=1, 0^1=0
	 * |: inclusive or --- 1|1=1, 1|0=1, 0|1=1, 0|0=0
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary2(String a, String b)
	{
		if(a == null||a.isEmpty()) return b;
		if(b == null||b.isEmpty()) return a;
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int posa = aArray.length-1;
		int posb = bArray.length-1;
		int numa = 0;
		int numb = 0;
		int carry = 0;
		while(posa>=0||posb>=0||carry==1)
		{
			numa = (posa>=0)?Character.getNumericValue(aArray[posa--]):0;
			numb = (posb>=0)?Character.getNumericValue(bArray[posb--]):0;
			int result = numa^numb^carry;
			carry=(numa+numb+carry>=2)?1:0;sb.append(result);
		}
		return sb.reverse().toString();
	}
	
	
	/**
	 * My solution
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary(String a, String b) {
        int posa = a.length()-1,posb = b.length()-1;
        Stack<String> result = new Stack<String>();
        boolean carrier = false;
        while(posa>=0&&posb>=0)
        {
        	char ca = a.charAt(posa),cb = b.charAt(posb);
        	if(ca=='1'&&cb=='1')
        	{
        		if(carrier) result.push("1");
        		else result.push("0");
        		carrier=true;
        	}
        	else if(ca=='0'&&cb=='0')
        	{
        		if(carrier) result.push("1");
        		else result.push("0");
        		carrier=false;
        	}
        	else
        	{
        		if(carrier)result.push("0");
        		else result.push("1");
        	}
        	posa--;
        	posb--;
        }
        if(posa>=0)
        {
        	while(posa>=0)
        	{
        		char c = a.charAt(posa);
        		if(c=='1'&&carrier) result.push("0");
        		else if(c=='0'&&carrier)
        		{
        			result.push("1");
        			carrier = false;
        		}
        		else result.push(c+"");
        		posa--;
        	}
        }
        else if(posb>=0)
        {
        	while(posb>=0)
        	{
        		char c = b.charAt(posb);
        		if(c=='1'&&carrier) result.push("0");
        		else if(c=='0'&&carrier)
        		{
        			result.push("1");
        			carrier = false;
        		}
        		else result.push(c+"");
        		posb--;
        	}
        }
        if(carrier) result.push("1");
        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) sb.append(result.pop());
        return sb.toString();
    }
}
