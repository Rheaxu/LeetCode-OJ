package easy;

import datastructure.ListNode;

public class RemoveNodeFromList {

	public static void main(String[] args)
	{
		int[] ns = {1,2};
		ListNode head = new ListNode(ns);
		RemoveNodeFromList rnfl = new RemoveNodeFromList();
		ListNode newhead = rnfl.removeNthFromEnd2(head, 2);
		while(newhead!=null)
		{
			System.out.println(newhead.val);
			newhead = newhead.next;
		}
	}
	
	/**
	 * Concise solution referred to other's
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd2(ListNode head, int n)
	{
		if(head == null || n==0) return head;
		ListNode fast = head,slow = head;
		while(n>0)
		{
			fast = fast.next;
			n--;
		}
		if(fast == null) return slow.next;
		while(fast.next!=null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		
		return head;
	}
	
	/**
	 * My solution
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd1(ListNode head, int n) 
	{
        if(head == null) return null;
        int ind = countlen(head)-n+1;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = dum;
        int count = 0;
        while(count!=ind-1)
        {
        	p = p.next;
        	count++;
        }
        p.next = p.next.next;
        
        return dum.next;
    }
	
	public int countlen(ListNode head)
	{
		int len = 0;
		ListNode p = head;
		while(p!=null)
		{
			len++;
			p=p.next;
		}
		return len;
	}
}
