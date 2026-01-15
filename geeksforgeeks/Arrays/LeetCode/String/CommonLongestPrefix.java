package geeksforgeeks.Arrays.LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonLongestPrefix
{
    public static void main(String[] args)
    {
        String[] strs = {"ab", "a"};
        System.out.println(longestCommonPrefixBruteForce(strs));
        System.out.println(longestCommonPrefixOptimised(strs));
    }

    /***
     * ✅ Final Time Complexity:
     * O(m × n)
     *
     *
     * Where:
     *
     * m = length of the shortest string
     *
     * n = number of strings
     *
     * This is exactly what we expect for a brute-force character-by-character comparison.
     * @param strs
     * @return
     */
    public static String longestCommonPrefixBruteForce(String[] strs) {
        StringBuilder response = new StringBuilder();
        String str = strs[0];
        for(int i=0; i< str.length(); i++){
            int count=1;
            char prefix = str.charAt(i);
            for ( int j=1; j< strs.length; j++){
                if( i < strs[j].length()){
                    if(strs[j].charAt(i) == prefix){
                        count++;
                    }
                }
            }
            if(count == strs.length){
//                response = response + prefix;
//                In Java, this creates a new String each time — since String is immutable.
//
//                This makes your actual code slightly less efficient.
//
//✅ Suggestion: Use StringBuilder for better performance.


                response.append(prefix);   // It changed the time consumed from 9ms to 1ms
            }else{
                break;
            }

        }
        return response.toString();
    }

//    O(n log n + m)
    public static String longestCommonPrefixOptimised(String[] strs) {
        StringBuilder str = new StringBuilder();
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        for( int i=0; i< first.length; i++){
            if(first[i] == last[i]){
                str.append(first[i]);
            }
            else{
                break;
            }
        }
        return str.toString();
    }


}
