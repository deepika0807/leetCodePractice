package geeksforgeeks.Arrays.LeetCode.String;

/***A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

 Given a string s, return true if it is a palindrome, or false otherwise.



 Example 1:

 Input: s = "A man, a plan, a canal: Panama"
 Output: true
 Explanation: "amanaplanacanalpanama" is a palindrome.
 Example 2:

 Input: s = "race a car"
 Output: false
 Explanation: "raceacar" is not a palindrome.
 Example 3:

 Input: s = " "
 Output: true
 Explanation: s is an empty string "" after removing non-alphanumeric characters.
 Since an empty string reads the same forward and backward, it is a palindrome.***/


/***
 * [^a-zA-Z0-9] — the Regex Pattern
 *
 * This part is the heart of the operation. Let's break it down:
 *
 * Part	Meaning
 * [...]	A character class — match any one character listed inside
 * ^ (inside [])	Negation — match any character not listed
 * a-z	All lowercase letters (a to z)
 * A-Z	All uppercase letters (A to Z)
 * 0-9	All digits (0 to 9)
 *
 * So:
 *
 * [^a-zA-Z0-9]
 *
 *
 * matches:
 *
 * Any character that is NOT a letter or digit
 *
 * Includes: spaces, punctuation, symbols (@, !, ,, ., :), etc.
 */
public class ValidPalindrome
{
    public static void main(String[] args)
    {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", ""); //Removes all non-alphanumeric characters from the input string s.
        if(str.length() == 0){
            return true;
        }
        str = str.toLowerCase();
        int p1=0, p2=str.length()-1;
        while(p1 < p2){
            if(str.charAt(p1) == str.charAt(p2)){
                p1++;
                p2--;
            }else{
                return false;
            }

        }
        return true;
    }
}
