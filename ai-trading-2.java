import java.util.HashSet;
import java.util.Hashtable;


public class hq {

/*
 * Method 1: store each character's count in a hashtable, then remove those only appear once
 *           Need two pass.
 *           
 * Method 2: Use a hashset to mark each character, if the set contains the character, means appear more than once, 
 *           store it in the hashtable.
 *           Only need one pass, but sacrifice space. 
 */
	
	
	public static Hashtable<Character, Integer> myFunc(String s){
		HashSet<Character> set=new HashSet<Character>(); 
		Hashtable<Character, Integer> table=new Hashtable<Character, Integer>();
		char[] charArray=s.toCharArray();// converting the input string to a char array
		/*
		 * Use a hashset to mark, , if the set contains the character, means appear more than once, 
 *           store it in the hashtable.
		 */
		for(int i=0;i<charArray.length;i++){
			if(set.contains(charArray[i])){//Use a hashset to mark 
				if(table.containsKey(charArray[i])){
					int temp=table.get(charArray[i]);// get the counts of the char, plus 1
					table.put(charArray[i],temp+1);
				}else{
					table.put(charArray[i], 2);// the character already appear in the set once, so put 2 in the hashtable
				}
			}else{
				set.add(charArray[i]);
			}
		}
	
		return table;
	}
	
	
	public static void main(String args[]){
		Hashtable<Character, Integer> table=myFunc(" , ,,,,  aabbc");
		for(Character c: table.keySet()){
			System.out.println(c);
			System.out.println(table.get(c));
		}
		
		
	}
	
	

}
