package geeksforgeeks.Arrays.LeetCode.SlidingWindowFixedSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnangrams
{
    public static void main ( String[] args ){
        String s = "baa", p="aa";
//        System.out.println(findAnagramsBruteForceFrequencyArray(s, p));
//        System.out.println(findAnagramsBruteForceHashMap(s, p));
//        System.out.println(findAnagramsOptimised(s, p));
        System.out.println(findAnagramsOptimised2(s, p));



    }
//    What exactly does .equals() do for arrays in Java?
//
//    Hint:
//    Does it compare element-by-element, or does it check whether both arrays are the exact same object in memory?
//    (Spoiler-but-not-spoiler: it's the second one 😏)
    public  static List<Integer> findAnagramsBruteForceFrequencyArray(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Build frequency map for p
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        // Build first window
        for (int i = 0; i < p.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Compare first window
        if (Arrays.equals(pFreq, windowFreq)) result.add(0);
        // Slide window
        for (int i = p.length(); i < s.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++; // add new char
            windowFreq[s.charAt(i - p.length()) - 'a']--; // remove old char

            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public  static List<Integer> findAnagramsBruteForceHashMap(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> pMap = buildFreqMap(p);
        Map<Character, Integer> windowMap = new HashMap<>();

        // Build initial window
        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        if (pMap.equals(windowMap)) result.add(0);

        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {
            char addChar = s.charAt(i);
            char removeChar = s.charAt(i - p.length());

            windowMap.put(addChar, windowMap.getOrDefault(addChar, 0) + 1);

            if (windowMap.get(removeChar) == 1) {
                windowMap.remove(removeChar);
            } else {
                windowMap.put(removeChar, windowMap.get(removeChar) - 1);
            }

            if (pMap.equals(windowMap)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    private static Map<Character, Integer> buildFreqMap(String str) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
    public static List<Integer> findAnagramsOptimised(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;
        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];
        for (char c: p.toCharArray()){
            pFreq[c - 'a']++;
        }
        int k = p.length();
        for (int i = 0; i < s.length(); i++) {
            // Add current character to window
            windowFreq[s.charAt(i) - 'a']++;
            // Remove character left out of the window
            if (i >= k) {
                windowFreq[s.charAt(i - k) - 'a']--;
            }

            // Compare frequency maps
            if (i >= k - 1 && Arrays.equals(pFreq, windowFreq)) {
                result.add(i - k + 1);
            }

        }
        return result;
    }

    public static List<Integer> findAnagramsOptimised2(String s, String p) {
        List<Integer>  response = new ArrayList<>();
        if(p.length() > s.length()){
            return response;
        }

        int[] freqMap = new int[26];
        int[] windowFreq = new int[26];
        for ( char c: p.toCharArray()){
            freqMap[c-'a'] ++;
        }
        System.out.println(Arrays.toString(freqMap));
        for ( int i=0; i<p.length(); i++){
            windowFreq[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freqMap,windowFreq)){
            response.add(0);
        }

        for(int i=1; i< s.length()-p.length()+1; i++){
            windowFreq[s.charAt(i-1) -'a']--;
            windowFreq[s.charAt(i) -'a']++;
            if(Arrays.equals(freqMap, windowFreq)){
                response.add(i);
            }
        }
        System.out.println(Arrays.toString(windowFreq));


        return response;

    }

    }
