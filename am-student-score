/*Edge Case:
 * 1. If the List is empty, return null;
 * 2. If a student has less than five scores, his final score is the average of all his scores
 * 
 * Analysis:
 * One method is build a minHeap to hold all the scores for one student, in this case, 
 * 
 * 
 * Steps:
 * 
 * 
 * 
 * 1. Use a HashMap to store the final score for every student. 
 * 2. Build a minHeap of size 5 for each student, this Heap keeps the top 5 highest score for one student. 
 * When a new score is higher than the peek of the Heap, poll the peek and add the new score. 
 * 3. For each student, its final score is the average score in the minHeap
 * 
 * Time complexity: O(nlogk) (here k=5)
 * 
 * Space complexity: 
 * HashMap to hold student's id and score takes O(n)
 * HashMap for final result takes O(n)
 * minHeap takes O(1)
 * The total space is O(n)
 * 
 * 
 */



import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Student_Score {
	public class TestResult{
		int studentId;
		Date testDate;
		int testScore;
		
		public TestResult(int id, int score){
			this.studentId=id;
			this.testScore=score;
		}
	}

	public static Map<Integer, Double> calculateFinalScores (List<TestResult> results){
		if(results == null || results.size() == 0) return null;
		HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer> > ();
		
	    for(TestResult res: results){	
	    	PriorityQueue<Integer> queue=null;
	    	if(map.containsKey(res.studentId)){
	    		queue=map.get(res.studentId);
	    	}else{
	    		queue=new PriorityQueue<Integer>(5);
	    	}
	    	if (queue.size()<5){
	    		queue.add(res.testScore);
		    	map.put(res.studentId, queue);
	    	}else if(queue.peek()<res.testScore){
	    		queue.poll();
	    		queue.add(res.testScore);
		    	map.put(res.studentId, queue);
	    	}
	    }
	
	    Map<Integer, Double> res=new HashMap<Integer, Double>();
	    for(int key: map.keySet()){
	    	PriorityQueue<Integer> q=map.get(key);
	    	double avg=0;
	    	for(int i=0; i<q.size(); i++){
	    		avg+=q.poll();
	    	}
	    	avg/=q.size();
	    	res.put(key, avg);
	    }
	    return res;
	}
	
	public static void main(String[] args){
		Student_Score s=new Student_Score();
		List<TestResult> results=new LinkedList<TestResult>();
			results.add(s.new TestResult(1, 1));
			results.add(s.new TestResult(1, 2));
			results.add(s.new TestResult(1, 3));
			results.add(s.new TestResult(1, 2));
			results.add(s.new TestResult(1, 1));
			results.add(s.new TestResult(2, 0));
			results.add(s.new TestResult(2, 1));
			results.add(s.new TestResult(2, 2));
			results.add(s.new TestResult(3, 0));
			results.add(s.new TestResult(4, 0));
			results.add(s.new TestResult(4, 1));
			results.add(s.new TestResult(4, 2));
			results.add(s.new TestResult(4, 3));
			results.add(s.new TestResult(4, 4));
			results.add(s.new TestResult(4, 5));
			Map<Integer, Double> res=calculateFinalScores(results);
			for(int key: res.keySet()){
				System.out.println(key+" " +res.get(key));
			}
			
	

	}
	
	
	
}
