import java.util.ArrayList;

/*
 * assume that the array contains integer
 * 
 * if window size is 0, return null
 * 
 * 
 * For the first n-k+1 elements in the array, for each of them, calculate the sum of elements from index i to index i+k-1
 * 
 * 
 * Time:　O(k(n-k))
 * For each element, it will take time O(k) to get the sum. 
 * There are n-k elements needed to deal with.
 * 
 * Space: O(n-k) to keep the result
 * 
 */

public class window_sum {

	
	
	public static ArrayList<Integer> windowSum(int[] a, int k){
		
		ArrayList<Integer> res=new ArrayList<Integer>();
		/*
		 * if window size is bigger than array size or window size is less or equal than 0, return null
		 * 
		 * if the array if empty, return null
		 */
		if(a.length==0||k>a.length||k<=0) return res;
		
		for(int i=0; i<=a.length-k; i++){
			
			int ans=0;
			/*
			 * for each element, calculate the sum of elements from index i to index i+k-1
			 */
			for(int j=i; j<i+k;j++){
				ans+=a[j];
			}
			res.add(ans);
		}
		
		return res;
		
	}
	
	public static void main(String args[]){
		int[] a = {0,4,4,4,4,6,8,9,9,9,23};
		int[] b =  {1,2,3,4,5};
		System.out.println(windowSum(b, 2));
		
	}
	
	
}
