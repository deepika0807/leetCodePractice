package geeksforgeeks.Arrays.LeetCode.SlidingWindowFixedSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationAllWords
{
    public static void main(String[] args){
        String s="barfoothefoobarman";
        String[] words= {"foo","bar"};
        System.out.println( findSubstringBruteForce(s, words));
        System.out.println( findSubstringOptimisedCode(s, words));

    }

//    Java substring(start, end) — How it works
//    It includes the character at start
    public static List<Integer> findSubstringBruteForce(String s, String[] words) {
        List<Integer> response = new ArrayList<>();
        Map<String, Integer> wordsFreq = new HashMap<>();
        for(String word: words){
            if(wordsFreq.containsKey(word)){
               int value =  wordsFreq.get(word);
               wordsFreq.put(word, ++value);
            }else{
                wordsFreq.put(word, 1);
            }
        }
        int windowSize = words[0].length() * words.length;

        for(int i=0; i<= s.length()-windowSize; i++){
            Map<String, Integer> sFreq = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int wordStart = i + j * words[0].length();
                String word = s.substring(wordStart, wordStart + words[0].length());
                    if(sFreq.containsKey(word)){
                        int value = sFreq.get(word);
                        sFreq.put(word, ++value);
                    }else{
                        sFreq.put(word, 1);
                    }
                }
            if(wordsFreq.equals(sFreq)){
                response.add(i);
            }
            }
        return response;
        }

    public static List<Integer> findSubstringOptimisedCode(String s, String[] words)
    {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;

        if (s.length() < windowSize) return result;

        // Step 1: Build word frequency map
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        // Step 2: Loop over each offset
        for (int offset = 0; offset < wordLength; offset++) {
            int left = offset, right = offset;
            Map<String, Integer> currentWindow = new HashMap<>();
            int wordsMatched = 0;
            // Step 3: Slide window in steps of wordLength
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (wordCount.containsKey(word)) {
                    currentWindow.put(word, currentWindow.getOrDefault(word, 0) + 1);
                    wordsMatched++;

                    // If frequency exceeds, shrink window
                    while (currentWindow.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentWindow.put(leftWord, currentWindow.get(leftWord) - 1);
                        left += wordLength;
                        wordsMatched--;
                    }
                    // If matched all words
                    if (wordsMatched == totalWords) {
                        result.add(left);
                    }
                } else {
                // Reset window
                currentWindow.clear();
                wordsMatched = 0;
                left = right;
            }
            }
        }
        return result;
    }
    }
