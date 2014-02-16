import java.util.ArrayList;
import java.util.Arrays;


/*Assume that the solution is unique, if not unique, should be ArrayList<ArrayList<Integer>>
 * 
 * Analysis: 
 * 
 * 
 * The only way to move to spot(m,n) is by moving to one of the adjacent spots: (n-1, m) or (n, m-1)
 * To reach spot(n-1, m), we need to reach (n-2,m) or (n-1,m-1)
 * To reach spot(n, m-1), we need to reach (n-1,m-1) or (n,m-2)
 * 
 * (n-1, m-1) appears twice. To avoid duplicate effort, we will remember that we 
 * already visited (n-1, m-1) to save time.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
 * 
 * So to find a path from the origin, we just start from the last cell, try to find a path to each of its adjacent cells
 * 
 * Time: O(n*m)
 * Space: O(n), n is the size of the array for holding the solution
 */


public class matrix_path {

	
	public static int m_path(int[][] matrix){
		
		int m=matrix.length;
		if(m<=0) return Integer.MAX_VALUE;
		int n=matrix[0].length;
		if(n<=0) return Integer.MAX_VALUE;
		
		
		ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		int r=findPath(matrix, res,temp, m,n);
		System.out.println(res);
		return r;
	}
	
	
	public static int findPath(int[][] matrix, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int m, int n ){
		
	    int[] dp=new int[n];
	    dp[0]=matrix[0][0];
		
	    temp.add(matrix[0][0]);
		res.add(new ArrayList<Integer>(temp));
	    
		for(int i=1; i<n; i++){
			temp.add(matrix[0][i]);
			res.add(new ArrayList<Integer>(temp));
		    dp[i]=Math.min(dp[i-1], matrix[0][i]);
		}
		
		for(int i=1; i<m; i++){
			for(int j=0; j<n; j++){
				if(j==0) {
					ArrayList<Integer> temp1=res.get(0);
					temp1.add(matrix[i][0]);
					dp[0]=Math.min(dp[0], matrix[i][0]);
					
				}
				else if(dp[j]>=dp[j-1]){
					res.get(j).add(matrix[i][j]);
					dp[j]=Math.min(dp[j], matrix[i][j]);
					
				}else{
					ArrayList<Integer> temp3=new ArrayList<Integer>(res.get(j-1));
					temp3.add(matrix[i][j]);
					res.set(j,temp3);
					dp[j]=Math.min(dp[j-1], matrix[i][j]);
				}
			   
			}
		}
		 return dp[n-1];
		
	}
	
	
	
	public static void main(String args[]){
	 /*  int m=2;
		int n=2;
		int[][] matrix = new int[m][n];
		 matrix[0][0]=7;
		 matrix[0][1]=8;
	     matrix[1][0]=3;
		 matrix[1][1]=9;
		
		
		
		
		int m=2;
		int n=3;
		int[][] matrix = new int[m][n];
		 matrix[0][0]=7;
		 matrix[0][1]=8;
	     matrix[0][2]=4;
		 matrix[1][0]=3;
		 matrix[1][1]=9;
	     matrix[1][2]=5;
	   //  matrix[2][0]=1;
	    // matrix[2][1]=0;
	    // matrix[2][2]=6;
		
		*/
		
	    int m=3;
		int n=5;
		int[][] matrix = new int[m][n];
		 matrix[0][0]=7;
		 matrix[0][1]=8;
	     matrix[0][2]=4;
		 matrix[0][3]=5;
		 matrix[0][4]=2;
		 matrix[1][0]=1;
		 matrix[1][1]=2;
	     matrix[1][2]=9;
		 matrix[1][3]=3;
		 matrix[1][4]=7;
		 matrix[2][0]=6;
		 matrix[2][1]=6;
	     matrix[2][2]=5;
		 matrix[2][3]=4;
		 matrix[2][4]=10;
	
		
		 System.out.println(m_path(matrix));
	            
	}
}
