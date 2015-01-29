package easy;

import datastructure.ListNode;

public class GetIntersectionNode {
	
	/**
	 * Method1
	 * Increase headA and headB at the same time. When they reach the tail,
	 * make them point to the other's head. Then they will reach the same
	 * ListNode.
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode1(ListNode headA,ListNode headB)
	{
		ListNode pA = headA;
		ListNode pB = headB;
		if(pA == null||pB == null) return null;
		while(pA!=null && pB!=null && pA!=pB)
		{
			pA = pA.next;
			pB = pB.next;
			if(pA == pB) return pA;
			
			if(pA == null) pA = headB;
			if(pB == null) pB = headA;
		}
		return pA;
	}	
	
	
	/**
	 * Method2
	 * Calculate the length of each ListNode. Move the head of the longer one 
	 * to make the two list be of the same length.then traverse one by one until
	 * both heads reach the same Node.
	 */
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB)
	{
		int lenA = listNodeLen(headA);
		ListNode pA = headA;
		ListNode pB = headB;
		int lenB = listNodeLen(headB);
		if(lenA == 0||lenB == 0) return null;
		while(lenA>lenB)
		{
			pA = pA.next;
			lenA--;
		}
		while(lenB>lenA)
		{
			pB = pB.next;
			lenB--;
		}
		while(pA!=null && pB!=null)
		{
			if(pA == pB) return pA;
			pA = pA.next;
			pB = pB.next;
		}
		return null;
	}
	
	public int listNodeLen(ListNode head)
	{
		ListNode p = head;
		int len = 0;
		while(p!=null)
		{
			len++;
			p = p.next;
		}
		return len;
	}
}
