package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class ReverseLinkedList
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
       LinkedList.ListNode listNode =  list.reverseListRecursion(list.head);
        LinkedList.ListNode tmp = listNode;
        while(tmp!=null){
            System.out.print(tmp.val + " ->");
            tmp = tmp.next;
        }
        System.out.println("null");

        LinkedList list2 = new LinkedList();
        list2.insertLast(1);
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(3);
        LinkedList.ListNode listNode2 = list2.reverseListIterative(list2.head);
         tmp = listNode2;
        while(tmp!=null){
            System.out.print(tmp.val + " ->");
            tmp = tmp.next;
        }
        System.out.println("null");

    }
}
