  
            import java.io.BufferedReader;
            import java.io.IOException;
            import java.nio.charset.StandardCharsets;
            import java.nio.file.Files;
            import java.nio.file.Paths;
            import java.util.*;
            import java.util.regex.Pattern;
            import java.io.InputStreamReader;

            public  class Solution {
               
                public static void main(String[] args) {
                  
                  System.out.println(howRandom());
                }
                
                public static float howRandom(){
                	int[] res=new int[100];
                    
                    for(int i=0; i<100000;i++){
                        int num=(int)Math.random()*99+1;
                        res[num-1]++;
                    }
                    double div=0;
                    for(int i=0;i<res.length;i++){
                    	div+=Math.abs(res[i]-1000)/1000000;
                    }
                    return (float)(1-(div/1.08));
                }
                
                
                public static int one2oneHundred(int[] dice) {
                	while(true){
                        int rand36=6*dice[0]+dice[1];
                        //int rand36_2=6*dice[2]+dice[3];
                        int rand216=6*rand36+rand36;
                        if(rand216<=200){
                         return 1+rand216%100;   
                        }     
                    }
                }

                
                public static int[] rollN(int n) {
                    int[] res=new int[n];
                    for(int i=0; i<n; i++){
                     res[i]=(int) Math.floor(Math.random()*6)+1;  
                    }
                    return res;
                }
                
                public static int[] mostFrequentSum(int n) {
                	int[] res1={};
                    if(n<=1||n>=999) return res1;
                	 
                     int[] res2=new int[1];
                     int[] res3=new int[2];
      
                     if(n/2==0){
                    	 res2[0]=(int)(3.5*n);
                         return res2;
                     }else{
                    	 res3[0]=(int)(3.5*n);
                    	 res3[1]=(int)(3.5*n)+1;
                         return res3;
                     }
                }


               
            }
