
public class h {

	/*
	 * Taken the array as input.
	 * Calculate the square sum 
	 */
	public static float myFunc(float[] array){
		double square_sum=0;
		for(int i=0;i<array.length;i++){
			for(int j=i+1; j<array.length;j++){// The minuend is always behind the subtrahend
				square_sum+=Math.pow(array[i]-array[j], 2);
			}
		}
		return (float) square_sum;
		
	}
	
	
	/*
	 * Take the input, put them in an array
	 */
	public static float[] createArray (float a, float b, float c, float d, float e){
		float[] res=new float[5];
		res[0]=a;
		res[1]=b;
		res[2]=c;
		res[3]=d;
		res[4]=e;
		return res;	
	}
	
	
	public static void main(String args[]){
		System.out.println(myFunc(createArray(5,4,3,2,1)));
		
	}
	
	
}
