package geeksforgeeks.Arrays.LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicacy
{
    public static void main(String[] args)
    {
        String str = "abcdef";
        BruteForce(str);
        optimal(str);
    }
    public static void BruteForce(String str){
        int maxLength = 0;
        HashMap<Character, Integer> freqMap= new HashMap<>();
        int count =0;
        for(int i=0; i<str.length(); i++){
            if(freqMap.containsKey(str.charAt(i)) ){
                maxLength = Math.max(maxLength, count);
                freqMap = new HashMap<>();
                freqMap.put(str.charAt(i), 1);
                count = 1;
            }else{
                count++;
                freqMap.put(str.charAt(i), 1);
            }
        }
        maxLength = Math.max(maxLength, count);
        System.out.println(maxLength);
    }


//     Use two pointer and window to shrink the window when you get duplicates
    public static void optimal(String s){
        int left=0, maxLength=0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for ( int right=0; right< s.length(); right++){
            while(freqMap.containsKey(s.charAt(right))){
                freqMap.remove(s.charAt(left++));
            }
            freqMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, (right-left)+1);
        }
        System.out.println(maxLength); ;
        }



}
