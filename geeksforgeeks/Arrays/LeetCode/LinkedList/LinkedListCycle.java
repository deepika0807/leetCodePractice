package geeksforgeeks.Arrays.LeetCode.LinkedList;


public class LinkedListCycle
{
    public static void main(String[] args)
    {
      LinkedList list = new LinkedList();
      list.insertLast(3);
      list.insertLast(2);
      list.insertLast(0);
      list.insertLast(-4);
        LinkedList.ListNode n1 = list.head;

    list.tail.next = n1;
        System.out.println( list.hasCycle(list.head));

      LinkedList.ListNode node=  list.detectStartCycle(list.head);
        System.out.println(node.val);
       int count = list.detectCycleLength(list.head);
        System.out.println("Cycle length: "+ count);
    }
}
