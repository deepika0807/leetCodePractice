package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        LL list = new LL();
        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertAtLast(7);
        list.insertAtIndex(9, 1);
//        list.deleteFirst();
        list.deleteLast();
        list.displayLL();
    }
}
