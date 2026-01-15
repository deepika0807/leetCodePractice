package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class RemoveDuplicatedSortedLinkedList
{
    public static void main(String[] args)
    {

        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.printList();

        // Insert 3 at index 2 using recursion
        list.deleteDuplicates(list.head);

        list.printList();
    }
}
