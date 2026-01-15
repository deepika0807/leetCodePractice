package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class MergeTwoSortedLists
{
    public static void main(String[] args)
    {

        LinkedList list1 = new LinkedList();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(4);
        list1.printList();

        LinkedList list2 = new LinkedList();

        list2.insertLast(4);
        list2.insertLast(5);
        list2.insertLast(6);
        list2.printList();

        LinkedList.ListNode mergedHead = LinkedList.mergeTwoLists(list1.head, list2.head);
        LinkedList result = new LinkedList();
        result.head = mergedHead;
        result.printList();
    }
}
