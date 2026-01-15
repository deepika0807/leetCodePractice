package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class DeleteDuplicatesFromList
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(4);
        list.insertLast(5);
        list.printList();
        LinkedList.ListNode listNode =  list.deleteDuplicatesII(list.head);
        LinkedList.ListNode tmp = listNode;
        while(tmp!=null){
            System.out.print(tmp.val + " ->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}
