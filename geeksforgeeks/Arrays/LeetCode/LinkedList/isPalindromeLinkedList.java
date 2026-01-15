package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class isPalindromeLinkedList
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(1);
        System.out.println(list.isPalindrome(list.head));
    }
}
