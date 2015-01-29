package medium;

import java.util.ArrayList;

import datastructure.ListNode;

public class LinkedListSort {

	public ListNode InsertionSort(ListNode head)
	{
		ListNode dummynode = new ListNode(-10);
		ListNode pre = dummynode; // the node that is smaller than cur
		ListNode cur = head;
		while(cur!=null)
		{
			pre = dummynode;
			while(pre.next!=null && pre.next.val < cur.val)
			{
				pre = pre.next;
			}
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
			
		return dummynode.next;
		
	}
	
	/**
	 * 
	 * @param head
	 * Divid and Conquer. 
	 * O(nlogn)
	 */
	public ListNode QuickSort(ListNode head)
	{
		if(head==null || head.next==null) return head;
		ListNode piv = head;
		ListNode cur = head.next;
		ListNode dummynode = new ListNode(0);
		ListNode last = dummynode;
		ListNode largetail = piv;
		while(cur!=null)
		{
			if(cur.val<piv.val)
			{
				largetail.next = cur.next;
				cur.next=piv;
				last.next=cur;
				cur = largetail.next;
				last = last.next;
			}
			else
			{
				if(cur.next!=null && cur.val>=piv.val)
					largetail = largetail.next;
				cur = cur.next;
			}
		}
		last.next = null;
		ListNode sortedlefthead = QuickSort(dummynode.next);
		ListNode sortedrighthead = QuickSort(piv.next);
		piv.next = null;
		dummynode.next = sortedlefthead==null?piv:sortedlefthead;
		ListNode concatnode = dummynode.next;
		while(concatnode.next!=null) concatnode = concatnode.next;
		concatnode.next = piv;
		concatnode = concatnode.next;
		concatnode.next=sortedrighthead;
		
		return dummynode.next;
	}
	
	public ListNode mergeSort(ListNode head)
	{
		ArrayList<ListNode> toSort = new ArrayList<ListNode>();
		
		
		return head;
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head,cur1,cur2;
        if(l1.val<l2.val)
        {
            head = l1;
            cur1 = l1;
            cur2 = l2;
        }
        else
        {
            head = l2;
            cur1 = l2;
            cur2 = l1;
        }

        while(cur1.next!=null)
        {
            if(cur1.next.val > cur2.val)
            {
                ListNode next = cur1.next;
                cur1.next = cur2;
                cur2 = next;
                cur1 = cur1.next;
            }
            else
            {
                cur1 = cur1.next;
            }
        }
        cur1.next = cur2;
        return head;
    }
	
	public void change(int a)
	{
		a += 1;
	}
	
	
	public static void main(String[] args)
	{
		LinkedListSort lls = new LinkedListSort();

		// Insertion Sort
		/*int[] intlist = {6,5,3,1,8,7,2,4};
		ListNode head = new ListNode(intlist[0]);
		ListNode cur = head;
		for(int i=1;i<intlist.length;i++)
		{
			cur.next = new ListNode(intlist[i]);
			cur = cur.next;
		}

		ListNode newhead = lls.InsertionSort(head);
		ListNode track = newhead;
		System.out.print(track.val);
		while(track.next!=null)
		{
			track = track.next;
			System.out.print("->"+track.val);
		}*/
		
		
		// Merger Two Sorted List
		/*int[] intlist1 = {2,3,6,7,9};
		int[] intlist2 = {4,5,8,10,11,12};
		ListNode l1 = intlist1.length>0?new ListNode(intlist1[0]):null;
		ListNode l2 = intlist2.length>0?new ListNode(intlist2[0]):null;
		ListNode cur1 = l1;
		for(int i=1;i<intlist1.length;i++)
		{
			cur1.next = new ListNode(intlist1[i]);
			cur1 = cur1.next;
		}
		ListNode cur2 = l2;
		for(int i=1;i<intlist2.length;i++)
		{
			cur2.next = new ListNode(intlist2[i]);
			cur2 = cur2.next;
		}
		ListNode newhead = lls.mergeTwoLists(l1,l2);
		System.out.print(newhead.val);
		while(newhead.next!=null)
		{
			newhead = newhead.next;
			System.out.print("->"+newhead.val);
		}*/
		
		// QuickSort
		//int[] intlist = {6,5,3,1,8,7,2,4};
		/*int[] intlist = {3,3,1,5,6,2,7};
		ListNode head = new ListNode(intlist[0]);
		ListNode cur = head;
		for(int i=1;i<intlist.length;i++)
		{
			cur.next = new ListNode(intlist[i]);
			cur = cur.next;
		}

		ListNode newhead = lls.QuickSort(head);
		ListNode track = newhead;
		System.out.print(track.val);
		while(track.next!=null)
		{
			track = track.next;
			System.out.print("->"+track.val);
		}*/
		
		int a = 4;
		System.out.println(1<<1);
		int b = 3;
		lls.change(b);
		System.out.println(b);
	}
}
