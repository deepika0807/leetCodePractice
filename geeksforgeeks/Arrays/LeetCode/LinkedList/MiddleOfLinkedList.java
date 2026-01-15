package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class MiddleOfLinkedList
{
    public static void main(String[] args)
    {
        LinkedList list1 = new LinkedList();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.insertLast(4);
        list1.insertLast(5);

        LinkedList.ListNode node = list1.middleNode(list1.head);
        System.out.println(node.val);
    }
}
