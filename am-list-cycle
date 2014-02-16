import java.util.LinkedList;

/* 1. Detect if a linked list has a loop, use fast/slow runner approach. 
 * One pointer jump two steps at a time, one pointer jump only one step at a time. 
 * If there is no loop, the two pointers will never meet. 
 * 
 * Time complexity O(n), this is the best we can do.
 * 
 * 2. Find the start List Node of the cycle. If there is no cycle, return null
 * 
 * Assume from the myList to the start node of loop(not include the start node of loop), there are x nodes;
 * the loop has y nodes, therefore the linked list has x+y nodes in total.  
 * 
 * If there is a loop, after two pointers entering the loop, assume that the slow one move k steps, 
 * the fast one move 2k step. When they meet, 2k-k=ty  (t is an int). 
 * 
 * This means for the slow pointer, every y step, it will meet the fast pointer. 
 * 
 * Also, we know that the first time the two pointers meet is after y steps. And the number of nodes between 
 * the meet point(included) and the loop start point is y-x.
 * 
 * So initial two new pointers, one start from myList, the other start from the meet point, the new meet
 * point is the start of the loop. 
 * 
 * Time complexity O(n).
 * 
 * Total Time complexity O(n)
 * 
 */


public class List_Cycle {
    // definition for single-linked list
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
			next=null;
		}
	}
	
	// check whether a LinkedList has cycle 
	public boolean hasLoops(ListNode myList){
		ListNode fast=myList;
		ListNode slow=myList;
		
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) return true;
		}
		return false;
		
	}
	
	// find the start list node for the loop
	public ListNode findStart(ListNode myList){
		ListNode copy=myList;
		ListNode fast=myList;
		ListNode slow=myList;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				while(myList!=slow){
					myList=myList.next;
					slow=slow.next;
				}
				return myList;
			}
		}
		return null;
	}
	
	public static void main(String args[]){
		
		
	}
	
	
	
	
}
