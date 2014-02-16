import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class find_maximum_repeating_number {
    // Time: O(n)
	// Space: O(n)
	// cann't handle duplicate
	/*
	 * Take a map to map element - > count
        Iterate through array and process the map
        Iterate through map and find out the popular
	 * 
	 * 
	 */
	
	
	/*Method 2: 
	 * 1. Sorting using any nlogn algorithm. 
2. maintain 2 variables max ans s_max. 
3. count the frequency of the first value and store it in max. 
4. when another value is encountered , count it's frequency and compare it with max. 
5. if the frequency is greater than max then s_max= max, and max= frequency of the new value. 
6 if the frequency is less than max then compare it with s_max..if s_max is lesser then s_max=new frequency. 
7. repeat step 4 till all the elements in the array are covered. 
this algorithm has the time complexity of O(nlogn) and space complexity of O(1).
	 * 
	 * 
	 * 
	 * 
	 */
	public static int findPopular1(int[] a){
		// Here, we build a map counting the number of times each number appears:
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i:a){
			 Integer count = map.get(i);
			 map.put(i, count != null ? count+1 : 0);
		}
		
		int max=Integer.MIN_VALUE;
		int popular=Integer.MIN_VALUE;
		//Now, we find the number with the maximum frequency and return it:
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
	        if (m.getValue() > max) {
	        	popular = m.getKey();
	            max = m.getValue();
	        } 
	        }
		return popular;
	    }
	
	
	
	public static ArrayList<Integer> findPopular2(int[] a){
		// Here, we build a map counting the number of times each number appears:
		
		ArrayList<Integer> res=new ArrayList<Integer>();
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i:a){
			 Integer count = map.get(i);
			 map.put(i, count != null ? count+1 : 0);
		}
		
		int max=Integer.MIN_VALUE;
		int popular=Integer.MIN_VALUE;
		//Now, we find the number with the maximum frequency and return it:
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
	        if (m.getValue() > max) {
	        	popular = m.getKey();
	            max = m.getValue();
	        } 
	        }
		
		res.add(popular);
		
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			if(m.getValue()==max && !res.contains(m.getKey())){
				res.add(m.getKey());
			}
		}
		return res;
	    }
	
	
	public static void main(String args[]){
		int[] a = {0,4,4,4,4,6,8,9,9,9,9,23};
		System.out.println(findPopular2(a));
	}
}
