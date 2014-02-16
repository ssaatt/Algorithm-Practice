
/*Assumption:
 * linked list size is unknown. 
 * 
 * If the size is known, we can just iterate through the linked list to find the (length-k) element. 
 * 
 * 
 * 
 * Method 1: 
 * use two pointers runner approach, one pass of the linked list is enough.
 * 
 * We could have two pointers, p1 and p2; p1 at the head of the linked list. 
 * We place p1 and p2 k nodes apart by moving p2 k nodes into the list. 
 * Then, we move p1 and p2 at the same pace.
 * When p2 hits the end of the linked list, p1 will point exactly to the kth nodes from the end. 
 * Return p1. 
 * 
 * 
 * Time: O(n)  --(pointer p2 runs k nodes first, takes O(k), then p1 and p2 runs together, takes O(n-k), in total 
 * the time is O(n))
 * Space: O(1)
 * 
 * 
 * 
 * Method 2: Recursive
 * Create a wrapper class and run recursively. 
 * 
 * Recursive method will takes O(n) extra space due to recursive calls. 
 * 
 * 
 * 
 */

public class kth_to_last {
	public class ListNode{
		int customerId;
		ListNode next;
		ListNode(int x){
			customerId=x;
			next=null;
		}
		
		void append(int d){
			ListNode end=new ListNode(d);
			ListNode n=this;
			while(n.next!=null) n=n.next;
			n.next=end;
		}
		
		public void print(){
			ListNode n=this;
			while(n!=null){
				System.out.print(n.customerId+",");
				n=n.next;
			}
		}
	}
	
	public static ListNode customersToNotify(ListNode myList, int k){  
        ListNode p1=myList;  
        ListNode p2=myList;  
        if(myList==null||k<=0) return null;   
        // move p2 k nodes into the list
        for(int i=0;i<k-1;i++){
            if(p2==null) return null; // error check
            p2=p2.next;  
        }  
        if(p2==null) return null; // error check
        
        // move p1 and p2 at the same speed, when p2 hits the end, p1 is what we want
        while(p2.next!=null){  
            p1=p1.next;  
            p2=p2.next;  
        }  
        
        System.out.println(k+"th to last node is "+p1.customerId);  
        return p1;
    }  
	
	public static void main(String args[]) {  
		kth_to_last k=new kth_to_last();
		ListNode list = k.new ListNode(0);  
      /*  list.append(1);  
        list.append(2);  
        list.append(2);  
        list.append(3);  
        list.append(3);  
        list.append(4);  
        list.append(1);  
        list.append(2);  
        list.append(0);  
        list.print(); 
        */
        ListNode myList=list;  
        customersToNotify(myList,1);  
    }  
	
	
   
}
