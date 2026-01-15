package geeksforgeeks.Arrays.LeetCode.LinkedList;


public class IntersectionOfLinkedList
{
    public static void main(String[] args)
    {
        LinkedList list1 = new LinkedList();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);

        LinkedList list2 = new LinkedList();
        list2.insertLast(6);
        list2.insertLast(7);

        // Create the common intersection nodes
        LinkedList.ListNode common = new LinkedList.ListNode(4);
        common.next = new LinkedList.ListNode(5);

        // Attach the intersection part
        list1.tail.next = common;
        list2.tail.next = common;

        System.out.println( list1.getIntersectionNode(list1.head, list2.head));
        // Now both lists share nodes [4 → 5]
        System.out.println("List 1:");
        list1.printList();
        System.out.println("List 2:");
        list2.printList();
    }

}
