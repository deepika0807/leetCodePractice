package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next=head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size+=1;
    }

    /***
     * You did not set this.next = null;
     *
     * That means, technically, next will default to null in Java because:
     *
     * In Java, object reference fields are automatically initialized to null if not explicitly assigned.
     * @param value
     */
    public void insertAtLast(int value){
        if (tail == null)
        {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }
    public void insertAtIndex(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        if(index == size){
            insertAtLast(value);
            return;
        }
        Node node = new Node(value);
        Node tmp = head;
        int counter =0;
        while(counter < index-1){
            tmp = tmp.next;
            counter++;
        }
        node.next = tmp.next;
        tmp.next=node;
        size++;
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
        if(head == null){ // If we have only one value in a LinkedList
            tail = null;
        }
        size--;
    }

    public void deleteLast(){
        if(tail == null){
            System.out.println("List is empty.");
            return;
        }
        if(size<=1){
            deleteFirst();
            return;
        }
        Node tmp = getNode(size-2);
        tmp.next = null;
        tail = tmp;
        size--;
    }

    public Node getNode(int index){
        Node tmp = head;
        for ( int i=0; i< index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }

    public void displayLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+ " ->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node{
        private int value;
        private Node next;
        public Node( int value){
        this.value = value;
        }
        public Node( int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
