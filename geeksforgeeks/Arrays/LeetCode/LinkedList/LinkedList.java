package geeksforgeeks.Arrays.LeetCode.LinkedList;

public class LinkedList {
    public ListNode head;
    public ListNode tail;
    public int size;

    public LinkedList() {
        this.size = 0;
    }

    public LinkedList(int val) {
        ListNode newNode = new ListNode(val);
        this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Recursive insert at index
    public ListNode insertAtIndexRecursive(int index, int value, ListNode currentNode) {
        if (index == 0) {
            ListNode newNode = new ListNode(value);
            newNode.next = currentNode;
            size++;
            return newNode;
        }

        currentNode.next = insertAtIndexRecursive(index - 1, value, currentNode.next);
        return currentNode;
    }

    // Insert at end (helper)
    public void insertLast(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Print list
    public  void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

        public  void deleteDuplicates(ListNode head) {
            if ( head !=null){
                ListNode temp = head;
                while(temp != null && temp.next != null){
                    if(temp.val == temp.next.val){
                        temp.next = temp.next.next;
                    }else{
                        temp = temp.next;
                    }
                }
            }

        }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Pick the smaller head as the start
        ListNode mergedHead;
        if (head1.val <= head2.val) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        // Keep track of the last node of the merged list
        ListNode tail = mergedHead;

        // Merge process
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next; // move tail forward
        }

        // Attach the remaining nodes
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return mergedHead;
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // dummy head
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // move last pointer
        }

        // Attach remaining nodes (only one of them is non-null)
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next; // merged head
    }

//    Floyd’s Cycle Detection Algorithm, also called the Tortoise and Hare algorithm.
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public ListNode detectStartCycle(ListNode head) {
        ListNode slow = head, fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find start of cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // start of cycle
            }
        }

        return null; // no cycle
    }

    public int detectCycleLength(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast ){
                int count = 1;
                slow = slow.next;
                while (slow != fast){
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
    }

    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;
      do{
          slow= squareOfNumber(slow);
          fast = squareOfNumber(squareOfNumber(fast));
      }while(slow != fast);
      if(slow == 1){
          return true;
      }else{
          return false;
      }

    }
    private static int squareOfNumber(int num){
        if(num/10 == 0){
            return num*num;
        }else{
            int sum = 0;
            while(num > 0){
                int rem = num%10;
                sum = sum+ rem*rem;
                num = num/10;
            }
            return sum;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while(fast!=null && fast.next!=null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(prev != null){
            prev.next = null;
        }
        return slow;

    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
       return mergeTwoLists(left, right);
    }

    public ListNode reverseListRecursion(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

    public ListNode reverseListII(ListNode head, int left, int right){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode leftPre = dummyNode;
        ListNode currNode = head;
        for (int i=0; i< left -1; i++){
            leftPre = leftPre.next;
            currNode = currNode.next;
        }
        ListNode subListHead = currNode;
        ListNode prev = null;
        for(int i=0; i<= right-left; i++){
            ListNode next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        leftPre.next = prev;
        subListHead.next = currNode;


        return dummyNode.next;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = this.middleNode(head);
        ListNode reverseNode = reverseListIterative(middleNode);

        ListNode currentNodeFirstList = head;
        ListNode currentNodeSecondList = reverseNode;
        while(currentNodeFirstList != null){
            if(currentNodeFirstList.val != currentNodeSecondList.val){
                return false;
            }
            currentNodeFirstList = currentNodeFirstList.next;
            currentNodeSecondList = currentNodeSecondList.next;
        }
        return true;

    }

    public ListNode reorderList(ListNode head) {
        ListNode middleNode = this.middleNode(head);
        ListNode reverseNode = reverseListIterative(middleNode);
        ListNode first = head;
        ListNode second = reverseNode;
        ListNode prevNode = second;
        while(first != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next =tmp1;
            first = tmp1;
            prevNode = second;
            second = tmp2;

        }
        if(second != null){
            prevNode.next = second;
        }
        return head;
    }
//    https://www.youtube.com/watch?v=dbRJFnQoKTI
    public ListNode reverseKGroupRecursion(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode startNode = head, endNode = head;
        for(int i=1; i< k; i++){
            endNode = endNode.next;
            if(endNode == null){
                return head;
            }
        }
        ListNode nexHead = reverseKGroupRecursion(endNode.next, k);
       reverseListII(startNode, endNode);
       startNode.next = nexHead;
       return  endNode;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode beforeStartNode = dummyNode, endNode = head;
        int i=0;
        while(endNode != null){
            i++;
            if(i%k ==0){
                ListNode startNode = beforeStartNode.next, tmpNode = endNode.next;
                reverseListII(startNode, endNode);
                beforeStartNode.next = endNode;
                startNode.next = tmpNode;
                beforeStartNode = startNode;
                endNode = tmpNode;

            }else{
                endNode = endNode.next;
            }

        }
        return dummyNode.next;
    }

    public void reverseListII(ListNode startNode, ListNode endNode){
        ListNode prev = null, current = startNode, next = startNode.next;
        while(prev != endNode){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        ListNode tail = current;

        // Step 2: Adjust k
        k %= length;
        if (k == 0) return head;

        // Step 3: Find new tail (length - k - 1 steps)
        current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        // Step 4: Rotate
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;

        return newHead;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpNodeA = headA;
        ListNode tmpNodeB = headB;
        while(tmpNodeA != tmpNodeB ){
        tmpNodeA = (tmpNodeA == null)? headB : tmpNodeA.next;
        tmpNodeB = (tmpNodeB == null)? headA : tmpNodeB.next;

        }
        return tmpNodeA;
    }

    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Find the size of the list
        int size = 0;
        ListNode tmp = head;
        while (tmp != null)
        {
            size++;
            tmp = tmp.next;
        }

        // Step 2: Find the node just before the one we want to remove
        int indexToRemove = size - n;
        tmp = dummy; // start from dummy to make deletion easier
        for (int i = 0; i < indexToRemove; i++)
        {
            tmp = tmp.next;
        }

        // Step 3: Remove the node
        tmp.next = tmp.next.next;

        // Step 4: Return the new head (in case first node was removed)
        return dummy.next;
    }

    public ListNode deleteDuplicatesII(ListNode head) {
        if ( head !=null){
            ListNode temp = head;

            ListNode preNode = new ListNode(-1);
            ListNode dummyNode = preNode;
            while(temp != null && temp.next != null){
                if(temp.val == temp.next.val){
                    temp.next = temp.next.next;
                }else{
                    preNode.next = temp;
                    preNode = preNode.next;
                    temp = temp.next;
                }
            }
            return dummyNode.next;
        }
        return null;
    }
}
