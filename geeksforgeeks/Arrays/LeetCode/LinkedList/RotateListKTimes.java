package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class RotateListKTimes
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertLast(1);
        list.insertLast(2);
        LinkedList.ListNode listNode =  list.rotateRight(list.head, 2);
        LinkedList.ListNode tmp = listNode;
        while(tmp!=null){
            System.out.print(tmp.val + " ->");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
}
