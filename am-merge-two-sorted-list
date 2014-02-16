/*Create a dummy node (copy) as the start of the result list, in this way, appending new nodes is easy. 
 * When we are done, the result is copy.next
 * 
 * Compare the first element of m and first element of n, remove the smaller from its initial list
 * and put it in the merged list. It's next become the new first element. Keep doing this until one 
 * list is empty, then put the remaining elements of the other list in the merged list. 
 * 
 * 
 * If two lists are already sorted, the complexity would be O(n+m) (for the worst case)
 * 
 * If two lists are not sorted, merge sort would be O((n+m)log(n+m)), because it must do the sorting. 
 * Space complexity O(1), Linked List is just reference. 
 * 
 * 
 * Edge cases: 
 * 
 * 1. If A is empty, return B ( if both A and B is empty, return B also works)
 * 2. If A is not empty, B is empty, return A. 
 * 3. During the process, A or B may run out first, we should paste the remaining list 
 * to the tail of the result
 * 
 * 
 * 
 * Method 2: 
 * using recursion. 
 * it will use stack space, not good than the above method. 
 * 
 */


public class Merge_Two_Sorted_List {
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val=x;
			next=null;
		}
		
		public void append(int d){
			ListNode end=new ListNode(d);
			ListNode n=this;
			while(n.next!=null){
				n=n.next;
			}
			n.next=end;
		}
		
		public void print(){
			ListNode n=this;
			while(n!=null){
				System.out.print(n.val+",");
				n=n.next;
			}
		}
		
	}
	
	
	
	public static ListNode merge(ListNode l1, ListNode l2){
		Merge_Two_Sorted_List x=new Merge_Two_Sorted_List();
		
		// create a dummy node
		ListNode cur=x.new ListNode(-1);
		ListNode copy=cur;
		
		if(l1==null) return l2;
		else if(l2==null) return l1;
		
		/*
		 * cur always points to the last node in the result list
		 */
		
		/*
		 * Compare the first element of m and first element of n, remove the smaller from its initial list
		 * and put it in the merged list.
		 * 
		 * It's next become the new first element. Keep doing this until one list is empty
		 */
		while(l1!=null && l2!=null){
			if(l1.val>l2.val) {
				cur.next=l2;
				cur=cur.next;
				l2=l2.next;
			}else{
				cur.next=l1;
				cur=cur.next;
				l1=l1.next;
			}
			
		}
		
		/*
		 *  put the remaining elements of the other list in the merged list. 
		 */
		
		if(l1==null) cur.next=l2;
		if(l2==null) cur.next=l1;
		return copy.next;
		
	}
	
	public static void main(String args[]){
		System.out.print(",");
		Merge_Two_Sorted_List x=new Merge_Two_Sorted_List();
		ListNode A=x.new ListNode(0);
		A.append(1);
		A.append(6);
		A.append(8);
		A.append(10);
		A.append(11);
		ListNode B=x.new ListNode(2);
		B.append(6);
		B.append(7);
		B.append(9);
		B.append(15);
		B.append(17);
		
		ListNode C=merge(A,B);
		C.print();
	}

}
