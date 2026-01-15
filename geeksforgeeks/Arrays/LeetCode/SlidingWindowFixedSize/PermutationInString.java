package geeksforgeeks.Arrays.LeetCode.SlidingWindowFixedSize;

import java.util.Arrays;

public class PermutationInString
{
    public static void main(String[] args)
    {
        String s1 = "abc", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
        //        System.out.println(checkInclusion(s1,s2));
    }

    public static Boolean checkInclusion(String s1, String s2)
    {
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];
//         Cover this edge case
        if(s2.length() < s1.length()){
            return false;
        }
        for (char c : s1.toCharArray())
        {
            s1Freq[c - 'a']++;
        }
        int k=s1.length();
        for (int i = 0; i < k; i++)
        {
            windowFreq[s2.charAt(i) - 'a']++;
        }
        if( Arrays.equals(s1Freq, windowFreq)){
            return true;
        }
        for ( int i= k; i< s2.length(); i++ ){
            windowFreq[s2.charAt(i) - 'a'] ++;
            windowFreq[s2.charAt(i-k) - 'a']--;
            if( Arrays.equals(s1Freq, windowFreq)){
                return true;
            }
        }
        return false;


    }

}
