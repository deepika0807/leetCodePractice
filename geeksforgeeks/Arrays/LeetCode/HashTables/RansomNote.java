package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.HashMap;
import java.util.Map;

public class RansomNote
{
    public static void main(String[] args)
    {
        String ransomNote="aaa";
        String magazine="aab";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstructOptimised(ransomNote, magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character, Integer> magazineFeqMap = new HashMap<>();
        Map<Character, Integer> ransomFreqMap = new HashMap<>();
        for ( Character c: magazine.toCharArray()){
            magazineFeqMap.put(c, (magazineFeqMap.getOrDefault(c, 0) + 1));
        }

        for ( int i=0; i< ransomNote.length(); i++){
            ransomFreqMap.put(ransomNote.charAt(i), (ransomFreqMap.getOrDefault(ransomNote.charAt(i), 0) + 1));
        }

        for (char c : ransomFreqMap.keySet()) {
            if (magazineFeqMap.getOrDefault(c, 0) < ransomFreqMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructOptimised(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();

        // Step 1: Count all characters from magazine
        for (char c : magazine.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Subtract counts for ransomNote characters
        for (char c : ransomNote.toCharArray()) {
            if (!freq.containsKey(c) || freq.get(c) == 0) {
                return false; // Not enough characters
            }
            freq.put(c, freq.get(c) - 1);
        }

        return true;
    }
}
