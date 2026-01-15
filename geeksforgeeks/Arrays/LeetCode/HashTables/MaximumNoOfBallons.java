package geeksforgeeks.Arrays.LeetCode.HashTables;

import java.util.HashMap;
import java.util.Map;

public class MaximumNoOfBallons
{
    public static void main(String[] args)
    {
        String text = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text));
    }

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for ( Character c: text.toCharArray()){
            if(c=='b' || c=='a' || c=='n' || c=='l' || c=='o'){
                freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
            }
        }
        int x = Math.min(freqMap.getOrDefault('b', 0), Math.min(freqMap.getOrDefault('a', 0), freqMap.getOrDefault('n', 0)));
        int xx = Math.min(freqMap.getOrDefault('l', 0), freqMap.getOrDefault('o', 0));
        return Math.min(xx/2, x);

    }
}
