// Problem : Add Two Numbers 2 (LC - 445)

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode reverse(ListNode head){
        // check if list is empty or single node (yes -> no need to reverse)
        if(head == null || head.next == null) return head;

        // Intialize three iterators
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = head.next; 

        // Iterate until current becomes null or on whole list
        while(current != null){
            // reverse logic
            current.next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != null) nextNode = nextNode.next;
        }

        // reverse list head
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse both lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        // add both lists
        int carry = 0;
        ListNode sumHead = null;
        ListNode sumTail = null;

        while(l1 != null && l2 != null){
            int sum = (l1.val) + (l2.val) + carry;

            ListNode newNode = new ListNode((sum % 10));
            carry = sum/10;

            if(sumHead == null){
                sumHead = newNode;
                sumTail = newNode;
            }
            else{
                sumTail.next = newNode;
                sumTail = newNode;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = (l1.val) + carry;

            ListNode newNode = new ListNode((sum % 10));
            carry = sum/10;

            sumTail.next = newNode;
            sumTail = newNode;

            l1 = l1.next;
        }

        while(l2 != null){
            int sum = (l2.val) + carry;

            ListNode newNode = new ListNode((sum % 10));
            carry = sum/10;

            sumTail.next = newNode;
            sumTail = newNode;

            l2 = l2.next;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            sumTail.next = newNode;
            sumTail = newNode;
        }

        sumHead = reverse(sumHead);
        return sumHead;
    }
}
