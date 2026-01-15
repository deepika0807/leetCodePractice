package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class SortLinkedList
{
    public static void main(String[] args)
    {
        LinkedList list1 = new LinkedList();
        list1.insertLast(4);
        list1.insertLast(2);
        list1.insertLast(1);
        list1.insertLast(3);

        list1.head = list1.sortList(list1.head);
        list1.printList();
    }
}
