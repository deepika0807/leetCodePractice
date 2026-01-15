package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class RemoveNthNodeFromEndOfList
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.printList();
        LinkedList.ListNode listNode =  list.removeNthFromEnd(list.head, 2);
        LinkedList.ListNode tmp = listNode;
        while(tmp!=null){
            System.out.print(tmp.val + " ->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}
