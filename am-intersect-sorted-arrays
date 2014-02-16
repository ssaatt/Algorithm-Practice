import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Intersection_sorted_Arrays {
	/*
	 * O(m + n) solution to intersect two sorted arrays
	 * 
	 * 考虑a, b均为空的情况
	 */
	public static List<Integer> intersect(int[] a1, int[] a2) {
		int i = 0;
		int j = 0;
		List<Integer> intersection = new ArrayList<Integer>();
		while(i < a1.length && j < a2.length) {
			if(a1[i] < a2[j]) {
				i++;
			} else if(a1[i] == a2[j]) {
				if(!intersection.contains(a1[i])) {
					intersection.add(a1[i]);
				}
				i++;
				j++;
			} else {
				j++;
			}
		}
		return intersection;
	}
	
	public static void main(String args[]){
		int[] a = {0,4,4,4,4,6,8,9,9,9,23};
		int[] b =  {0,1,3,4,4,8,9,9,9,9, 23};
		System.out.println(intersect(a, b));
		
	}
	
}
