package geeksforgeeks.Arrays.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Step 2: What is '0' doing here?
 *
 * Characters have numeric values (ASCII / Unicode).
 *
 * Character	Value
 * '0'	48
 * '1'	49
 * '2'	50
 *
 * Now do this subtraction:
 *
 * '1' - '0' = 49 - 48 = 1
 */
public class MobilePad
{
    public static void main(String[] args)
    {
//        padDisplay( "", "7");
//        System.out.println(padDisplayRet("", "23"));
//        System.out.println(letterCombinations("7"));
        System.out.println(displayLetters("" , "78"));
    }
    static void padDisplay(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for(int i= (digit - 1)*3; i< digit*3; i++){
            char ch = (char) ('a'+i);
            padDisplay(p + ch, up.substring(1));
        }
    }

    static ArrayList<String> padDisplayRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; //Convert the digit character into its integer value

        ArrayList<String> list = new ArrayList<>();
        for(int i= (digit - 1)*3; i< digit*3; i++){
            char ch = (char) ('a'+i);
            list.addAll(padDisplayRet(p + ch, up.substring(1))); //addAll(...) → takes all elements of that list and dumps them into list
        }
        return list;
    }

//     Leetcode 17. Letter Combinations of a Phone Number
    public static List<String> letterCombinations(String digits) {
        return (helper(digits, ""));
    }
    public static List<String> helper(String up, String p){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        if(digit == 7 || digit == 9){
            for(int i = (digit -2)*3; i<= (digit-1)*3; i++){
                char c = (char)('a' + i);
                list.addAll(helper(up.substring(1), p+c));
            }
        }else{
            for(int i = (digit -2)*3; i< (digit-1)*3; i++){
                char c = (char)('a' + i);
                list.addAll(helper(up.substring(1), p+c));
            }
        }


        return list;
    }

    public static List<String> displayLetters(String p , String up){
        List<String> letters = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        if(up.isEmpty()){
           List<String> list = new ArrayList<>();
           list.add(p);
            return list;
        }
        List<String> list = new ArrayList<>();
        int c = up.charAt(0) - '0';
        int freq = 3;
        for( int i=0; i<letters.get(c).length(); i++){
            list.addAll(displayLetters(p+ letters.get(c).charAt(i), up.substring(1)));
        }
        return list;
    }
}
