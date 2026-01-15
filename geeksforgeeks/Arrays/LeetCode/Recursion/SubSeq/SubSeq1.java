package geeksforgeeks.Arrays.LeetCode.Recursion.SubSeq;

public class SubSeq1
{
    public static void main(String[] args)
    {
        String str = "abc";
        subSeq1("", str);
    }
    static void subSeq1(String newString, String oldString)
    {
        if (oldString.isEmpty())
        {
            System.out.println(newString);
            return;
        }
        subSeq1(newString + oldString.charAt(0), oldString.substring(1));
        subSeq1(newString, oldString.substring(1));
    }
}
