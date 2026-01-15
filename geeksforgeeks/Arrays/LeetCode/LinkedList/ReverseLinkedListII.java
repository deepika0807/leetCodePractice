package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class ReverseLinkedListII
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        LinkedList.ListNode listNode =  list.reverseListII(list.head, 2, 4);
        LinkedList.ListNode tmp = listNode;
        while(tmp!=null){
            System.out.print(tmp.val + " ->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}
