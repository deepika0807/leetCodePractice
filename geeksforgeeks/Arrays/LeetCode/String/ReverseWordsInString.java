package geeksforgeeks.Arrays.LeetCode.String;

public class ReverseWordsInString
{
    public static void main(String[] args)
    {
        String str = "the sky is blue";
        System.out.println(reverseWords(str));
        System.out.println(reverseWordsOptimal(str));
    }

//    Time complexity: O(n)  Space complexity: O(n)
    public static String reverseWords(String s) {
        StringBuilder response = new StringBuilder();
        String str = s.trim().replaceAll("\\s+", " ");
        String[] strArray = str.split(" ");
        for( int i= strArray.length-1; i>=0; i--){
            response.append(strArray[i]);
            response.append(" ");
        }
        return response.toString().trim();
    }

//    Time complexity: O(n)  Space complexity: O(n) Little faster
    public static String reverseWordsOptimal(String s) {
        int i = s.length() - 1;
        StringBuilder result = new StringBuilder();

        while (i >= 0) {
            // Skip trailing spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            int end = i;

            // Move i to the start of the word
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // Append word
            result.append(s.substring(i + 1, end + 1));
            result.append(' ');
        }

        // Remove last space
        return result.toString().trim();
    }
}
