/*
面试时间: 6: 03-6:47
Share Google Doc: 6:10.
Clear Questions (input & output) : 6:10-6:18/6:20
Time for coding:6:20-6:42

问题: 
1. 不需要sort, 时间复杂了, 只要keep max就好. 而且在加入的时候就能keep max, 不用one pass. 
2. 这么几行, 写这么久!!!!
*/


/*
Input: thiisiisgoodd
Function F(input)
output: i i o d

input2: this
Function F(input2)
output: t h i s

input: thiiisiisgoodd
Function F
output: i

input: thiiisiisgooodd
Funtion F
output: i o

*/

public class NumWithCount implements Comparator{
  Char c;
  int count;
  
  public NumWithCount(Char c, int count){
    this.c=c;
    this.count=count;
}
 
   public int compare(NumWithCount n1, NumWithCount n2){
    return n1.count>n2.count;
}
 
}

public String highest(String s){
       char[] chars=s.toCharArray();
      ArrayList<NumWithCount> al=new ArrayList<NumWithCount>();
     
      for(int i=0; i<chars.length; i++){
               int count=1;
               while (chars[i]==chars[i+1]){
                   count++;
                   i++;
                }
       NumWithCount nwc=new NumWithCount(chars[i], count);
       al.add(nwc);
      }
 Collections.sort(al);
StringBuffer res=new String Buffer();
int max=al.get(0).count;
for(NumWithCount n: al){
   if(n.count==max) res.add(n.c);
}
return res.toString();
}
