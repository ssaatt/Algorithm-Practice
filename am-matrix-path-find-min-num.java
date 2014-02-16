public class matrix_path_find_min_num {
	
		public static int m_path(int[][] matrix){
			
			int m=matrix.length;
			if(m<=0) return Integer.MAX_VALUE;
			int n=matrix[0].length;
			if(n<=0) return Integer.MAX_VALUE;
			
			return findPath1(matrix,m-1,n-1);
		}
		
		public static int findPath1(int[][] matrix, int m, int n ){
			if(m==0 && n==0){  
				return matrix[m][n];
			}
			
			else{
				int temp1=m>=1?findPath1(matrix,m-1,n):Integer.MIN_VALUE;
				int temp2=n>=1?findPath1(matrix,m,n-1):Integer.MIN_VALUE;
				return Math.min(Math.max(temp1, temp2), matrix[m][n]);
			}
		}
		
		// Method 2: use an array to store our visited cells
		// Time: O(m*n)
		// Space: O(n)
		public static int findPath2(int[][] matrix){
			int m=matrix.length;
			if(m<=0) return Integer.MAX_VALUE;
			int n=matrix[0].length;
			if(n<=0) return Integer.MAX_VALUE;

			int[] dp=new int[n];
			dp[0]=matrix[0][0];
			for(int i=1; i<n; i++) dp[i]=Math.min(dp[i-1], matrix[0][i]);
			for(int i=1; i<m; i++){
				for(int j=0; j<n; j++){
					if(j==0) {
						dp[0]=Math.min(dp[0], matrix[i][0]);
						continue;
					}
					dp[j]=Math.min(Math.max(dp[j-1], dp[j]), matrix[i][j]);
				}
			}
			return dp[n-1];
		}
		
		public static void main(String args[]){
			int m=3;
			int n=3;
			int[][] matrix = new int[m][n];
			 matrix[0][0]=7;
			 matrix[0][1]=8;
		     matrix[0][2]=4;
			 matrix[1][0]=3;
			 matrix[1][1]=9;
		     matrix[1][2]=5;
		     matrix[2][0]=1;
		     matrix[2][1]=0;
		     matrix[2][2]=6;
			 
			 System.out.println(findPath2(matrix));
		            
		}
	}

