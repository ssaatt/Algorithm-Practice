/*

input: text
output:　word frequency sentence number. 按字母顺序. 输出格式为  happy 3 1,4,5; (tab, comma)

*/


/*
Corner cases: 

This part is same as Question 1
1. "I can do"  && "i can do" :  output is same(All based on lower case)
2. "fish, fish: fish, fish." :  output should be "fish 4"
3. words with apostrophe (don't, I'm...)
4. words with hyphen(T-shirt, do-it-yourself....) ( a little unsure about this case, is "do-it-yourself" one word or three words?) 
5. abbreviations (e.g. , i.e. ....)

This part is different from Question 1　
A valid sentence should either: 
1. start with a UpperCase or number, end with [.!?], the end may have multiple punctuations (e.g. ?!, ...)
2. included in "" or() or[] or {} or <> and has a post teminator [.!?] (not sure here)


1. "I never drink... wine."  is one sentence. 
2. "She said what?!  I don't believe it..."  is two sentences. 




Thoughts:
1.Use a tree map<String, Integer> to hold the word and frequencies
2.Use another tree map<String, Integer> to hold word and (frequency+sentence numbers)

3.Parse the file to sentences. 
For each sentence, parse it to words;
For each word, count its frequencies and record the sentence numbers. 

4.The result is stored in the second map, which is build up based on the first map. 

Time Complexity: 
O(nlgn)--n is the total number of words in the inputstream
For tree map, the average operation time is O(lgn), so total time is O(nlgn)

Space Complexity:
Extra Structure needed: O(k)-- k is the number of unique words in the inputstream
Two tree maps are needed, one is for (word, frequency), the other is for(word, frequency+sentence numbers)

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
                public static final Pattern SPECIALCHARS = Pattern.compile("[!,?,:,;,\\,\\.,#,\",_,~,(,),{,},$,%,@,/,*,([0-9]+(?:\\.[0-9]*)?),\\[,\\]]");

                public static void main(String[] args) {
                    try{
                   // load input
                   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                   // 	BufferedReader br = Files.newBufferedReader(Paths.get("./text.txt"), StandardCharsets.UTF_8);   
                    	
                        // create one TreeMap for <word, frequencies>
                        // create another TreeMap for< word, frequencies+sentence numbers>
                        Map<String, Integer> wordFreq = new TreeMap<>();
                        Map<String, String> lineNums = new TreeMap<>();
                        String line;
                        // There may be abbreviations (e.g. , i.e. ....)
                        List<String> exceptionWord = getExceptionWord();

                        while ((line = br.readLine()) != null) {
                            if (!line.isEmpty()) {    
                            	
                                /*
                               A valid sentence should either: 
                               1. start with a UpperCase or number, end with [.!?], the end may have multiple punctuations (e.g. ?!, ...)
                               2. included in "" or() or[] or {} or <> and has a post teminator [.!?](not sure here)
                                */
                                
                                String[] sentences = line.split("(?<=[.?!])\\s+(?=[A-Z0-9])");
                                int sentencesLength = sentences.length;
                                for (int i = 0; i < sentencesLength; i++) {
                                    String[] rawWords = sentences[i].split("\\s");
                                    List<String> filteredWords = filter(rawWords, exceptionWord);
                                    wordFreq = countFreq(filteredWords, wordFreq);
                                    lineNums = countLineNums(filteredWords, lineNums, i);
                                }
                            }
                        }
                        
                       
                        Map<String, String> concordance = build(wordFreq, lineNums);
                         // print result
                        Set<String> words = concordance.keySet();
                        for(String word:words){
                        	System.out.println(word+"\t"+concordance.get(word));
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                
                // check abbreviations 
                public static List<String> getExceptionWord() {
                    
                    final List<String> exceptions = new ArrayList<>();
                    exceptions.add("e.g.");
                    exceptions.add("i.e.");
                    exceptions.add("a.s.a.p");
                    exceptions.add("a.k.a");
                    return exceptions;
                }
                
                //second map(final result)is build up based on the first map. 

                public static Map<String, String> build(Map<String, Integer> wordFrequency,
                                                                    Map<String, String> lineNums) {

                   Map<String, String> concordance = new TreeMap<>();
                   Set<String> words = wordFrequency.keySet();

                    final StringBuilder sb = new StringBuilder();
                    for (final String word : words) {
                        sb.append(wordFrequency.get(word));
                        sb.append("\t");
                        sb.append(lineNums.get(word));
                        concordance.put(word, sb.toString());
                        sb.setLength(0);
                    }
                    return concordance;
                }

                // convert to lower case
                public static List<String> filter(String[] rawWords, Collection<String> exceptionWord) {

                	List<String> filteredWords = new ArrayList<>(rawWords.length);
                    for (String word : rawWords) {
                        if (!exceptionWord.contains(word)) {
                            word = SPECIALCHARS.matcher(word.toLowerCase()).replaceAll("");
                        }

                        if (!word.isEmpty()) { // avoid fake "words"
                            filteredWords.add(word);
                        }
                    }
                    return filteredWords;
                }
                
                // count frequencies

                public static Map<String, Integer> countFreq(List<String> filteredWords,
                                                                       Map<String, Integer> wordFrequency) {
                    for (String word : filteredWords) {
                        if (wordFrequency.get(word) != null) {
                            wordFrequency.put(word, 1 + wordFrequency.get(word));
                        } else {
                            wordFrequency.put(word, 1);
                        }
                    }
                    return wordFrequency;
                }
                
                // record line numbers
                public static Map<String, String> countLineNums(List<String> filteredWords,
                                                                           Map<String, String> lineNums,
                                                                            int lineNum) {
                    StringBuilder sb = new StringBuilder();
                    for (String word : filteredWords) {
                        if (lineNums.get(word) != null) {
                            sb.append(lineNums.get(word));
                            sb.append(",");
                            sb.append(lineNum + 1);
                            lineNums.put(word, sb.toString());
                            sb.setLength(0);
                        } else {
                            lineNums.put(word, String.valueOf(lineNum + 1));
                        }
                    }
                    return lineNums;
                }


            }
