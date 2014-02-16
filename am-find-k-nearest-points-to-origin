/*Assumptions: if x or y is too big, x*x may overflow. 
 * 
 * Analysis:the time consuming part is calculating x*x+y*y, one method is sort the points according to max(x, y), 
 * when the heap peek's x*x+y*y<= max(x,y)*max(x,y) , stop calculating. The points in the heap is what we are looking for. 
 * 
 * 
 * 0. 
 * caculate x*x+y*y takes O(n) time
 * 
 * 
 * 1. Use PriorityQueue to build a Max Heap. Implement a comparator based on the distance to the origin
 * For the first k points, add them to the Max Heap; 
 * For the remaining points, compare their distances to origin with the peek. If smaller, remove the peek and add it to the heap
 * 
 * The time cost for a point to find the right position in the Priority Queue is log(k)
 * 
 * The total time complexity is O(n) + O(nlog(k)), 
 * If n is much larger than k, the time complexity is almost O(n)
 * 
 * 
 * 2. Space complexity O(k)---used by PriorityQueue to keep the top k points
 * also need space to keep the distance O(n)
 * 
 * 
 * Method 2: 
 * Trivial sorting method, 
 * 
 * calculate all the distances in an array, sort the array, then get the k smallest from there. 
 * 
 * 
 * will take O(nlgn). If n is very large and k is small, 
 * the sort is very inefficient. 
 * 
 * Method 3: 
 * quick select algorithm
 * 
 * First, build an array with the distances to the origin and the corresponding point O(n)
 * Then, find the Kth largest distance using Selection algorithm, O(n)
 * Use quick sort, the K-1 smallest distances are to the left of K th distance, in no particular order
 * 
 * So the total is O(N)
 * 
 * 
 * In the partition step of quicksort, all the elements are splitted into those 
 * smaller than a chose pivot and those biggers, so finally the pivot lands in the proper place. 
 * 
 * Then we can see if the pivot value equals to K
 * 
 * 
 * 
 * Time: O(n)
 * Space: O(n)
 * 
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Find_k_nearest_points_to_origin {
	public static class Point{

		public double x;
		public double y;
		
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double distance(){
			return (this.x*this.x + this.y*this.y); //no need to compute the square root
		}
	} 

	public static Point[] closestk( Point  myList[], int k ) {
		Comparator<Point> cop=new Comparator<Point>(){
			public int compare(Point p1, Point p2){
				double dist1 = p1.distance();
				double dist2 = p2.distance();
				if(dist1 < dist2) return 1;
				else if(dist1 > dist2) return -1;
				else return 0;
			}
		};
		PriorityQueue<Point> PQ = new PriorityQueue<Point>(k, cop);
		Point[] ret = new Point[k];
		
		if(myList.length==0|| myList.length<k) return ret; 
		
		
		for(int i=0;i<myList.length;i++){
			if(PQ.size()<k) PQ.add(myList[i]);
			else if(PQ.peek().distance()>myList[i].distance()){
				PQ.poll();
				PQ.add(myList[i]);
			}

		}
		for(int i=0;i<k;i++){
			ret[i] = PQ.poll();
		}
		return ret;
	}

	public static void main(String[] args){
	
		Point[] p = new Point[15];
			p[0] = new Point(0,1);
			p[1] = new Point(0,5);
			p[2] = new Point(0,15);
			p[3] = new Point(0,19);
			p[4] = new Point(0,10);
			p[5] = new Point(0,8);
			p[6] = new Point(0,3);
			p[7] = new Point(0,7);
			p[8] = new Point(0,12);
			p[9] = new Point(0,6);
			p[10] = new Point(0,7);
			p[11] = new Point(0,0);
			p[12] = new Point(0,14);
			p[13] = new Point(0,12);
			p[14] = new Point(0,2);
			
		
		Point[] q = closestk(p, 5);

		for(int i=0;i<q.length;i++){
			System.out.println(q[i].toString() );
		}
	}

}
