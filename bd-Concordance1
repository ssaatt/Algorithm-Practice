/*
input: text
output: 输出单词和频率,tab隔开,每个单词一行,按字母顺序排列
 
*/

/*
For Question 1:

Corner cases: 
1. "I can do"  && "i can do" :  output is same(All based on lower case)
2. "fish, fish: fish, fish." :  output should be "fish 4"
3. words with apostrophe (don't, I'm...)
4. words with hyphen(T-shirt, do-it-yourself....) ( a little unsure about this case, is "do-it-yourself" one word or three words?) 
5. abbreviations (e.g. , i.e. ....)

Thoughts:
1.Use a tree map<String, Integer> to hold the final result 
2.Process the file line by line. For each word
1)if it does not exist in Map, add it to the map and set its frequency to 1. 
2)if it already exists in Map, add one to its frequency. 

Time Complexity: 
O(nlgn)--n is the total number of words in the inputstream
For tree map, the average operation time is O(lgn), so total time is O(nlgn)

Space Complexity:
Extra Structure needed: O(k)-- k is the number of unique words in the inputstream
A tree map to keep the words and their frequencies. 

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.io.InputStreamReader;

            public  class Solution {
                public static final Pattern SPLIT = Pattern.compile("[^((A-Za-z0-9')|([-']))]");
            	
            	
                public static void main(String[] args) {
                    try{
                        // input
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    	//BufferedReader br = Files.newBufferedReader(Paths.get("./text.txt"), StandardCharsets.UTF_8);   
                    	Map<String, Integer> wordFreq = new TreeMap<>();
                        String line;
                      
                        while ((line = br.readLine()) != null) {
                            if (!line.isEmpty()) {    
                            	
                           	String[] sentences = SPLIT.split(line);
                                    List<String> loweredWords = lower(sentences);
                                    wordFreq = countFreq(loweredWords, wordFreq);
                            }
                        }
                        
                        // print result
                        Set<String> words = wordFreq.keySet();
                        for(String word:words){
                        	System.out.println(word+"\t"+wordFreq.get(word));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                
                //convert words to lowercase
                public static List<String> lower(String[] rawWords) {

                	List<String> loweredWords = new ArrayList<String>(rawWords.length);
                    for (String word : rawWords) {
                        
                            word =word.toLowerCase();
                            if (!word.isEmpty()) { // avoid fake "words"
                            loweredWords.add(word);
                        }
                    }
                    return loweredWords;
                }
                
                // count frequency for each word
                public static Map<String, Integer> countFreq(List<String> loweredWords,
                                                                       Map<String, Integer> wordFrequency) {
                    for (String word : loweredWords) {
                        if (wordFrequency.get(word) != null) {
                            wordFrequency.put(word, 1 + wordFrequency.get(word));
                        } else {
                            wordFrequency.put(word, 1);
                        }
                    }
                    return wordFrequency;
                }
            }
