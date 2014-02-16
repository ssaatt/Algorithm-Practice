import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Method 1:
 * Assumption: if the array/sets are different sizes, it makes sense to begin with the smallest
 * 
 * Converting the Array/List to Sets and using retainAll() 
 * 
 * Time :
 * The time for running containAll() should be O(n*m), because this function iterates 
 * over the collection, checking each element returned by the iterator in turn to see 
 * if it's contained in the collection. 
 * 
 * Space:
 * O(m) for the hashset to keep elements in a
 * 
 * 
 * Method 2:
 * Use HashSet to store all data from first List/array. Then for every element in the second List/array, 
 * check if the HashSet contains() the element. 
 * 
 * Space:
 * O(m) for the hashset to keep elements in a
 * O(n) for the hashset to keep elements in b
 * Total: O(m+n)
 * 
 * 
 * Time: O(n+m) in total. 
 * One pass to add a's elements into hashset.
 * One pass to check b's elements.
 * 
 * Method 3:
 * Sort the two arrays in O(nlgn), then see Intersection_sorted_Arrays
 * 
 * Space: depends
 * O(1) for intersect sorted arrays, 
 * extra space will be needed for sort the arrays, the space depends on which kind of sort algorithm we use. 
 */

public class Array_Intersection {
	// method 1:Converting the Array/List to Sets and using retainAll() 
	public static List<Integer> intersection1 (List<Integer> a, List<Integer> b) {
		Set<Integer> s1 = new HashSet<Integer>(a);
		s1.retainAll(b);
		List<Integer> answer = new ArrayList<Integer>(s1);
		return answer;
	}
	
	// method 2: if retainAll() is not allowed, 
	public static List<Integer> intersection2 (List<Integer> a, List<Integer> b) {
		Set<Integer> answer = new HashSet<Integer>();
		Set<Integer> aSet = new HashSet<Integer>(a);
		// To avoid duplicates
		Set<Integer> bSet = new HashSet<Integer>(b);
		for(Integer i:bSet) {
			if(aSet.contains(i)) answer.add(i);// hashSet.contains() runs in constant time
		}
		return new ArrayList<Integer>(answer);
	}
	public static void main(String args[]){
		Integer a[] = {2, 9, 0, 6, 7, 4, 23,0,0};
		Integer b[] =  {9, 3, 4, 23, 1, 8, 0};
		System.out.println(intersection1(Arrays.asList(a), Arrays.asList(b)));
		
	}
}
