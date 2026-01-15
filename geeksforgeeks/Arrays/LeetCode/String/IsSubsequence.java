package geeksforgeeks.Arrays.LeetCode.String;

/***
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 */
public class IsSubsequence
{
    public static void main(String[] args)
    {
        String s="axc";
        String t="ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean isSubsequence(String s, String t) {
        int p1=0, p2=0, count=0;
        while(p1 < t.length() && p2 < s.length()){
            if(t.charAt(p1) == s.charAt(p2)){
                count++;
                p1++;
                p2++;
            }else{
                p1++;
            }
        }
        if( count == s.length()){
            return true;
        }
        return false;
    }
}
