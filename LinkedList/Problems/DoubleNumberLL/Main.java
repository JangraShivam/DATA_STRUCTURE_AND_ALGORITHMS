// Problem : Double a Number Represented as a Linked List (LC - 2816)


class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    // Method 1 recusrsive
    int doubleRecurisively(ListNode head){
        // Base case
        if(head == null) return 0;

        int carry = doubleRecurisively(head.next);
        int product = (head.val)*2 + carry;

        head.val = product%10;
        return product/10;
    }

    ListNode doubleUsingRecursion(ListNode head){
        int carry = doubleRecurisively(head);

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    ListNode reverse(ListNode head){
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode = head.next;

        while(currNode != null){
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            if(nextNode != null) nextNode = nextNode.next;
        }

        return prevNode;
    }
    public ListNode doubleIteratively(ListNode head) {
        // reverse the list
        ListNode reverseHead = reverse(head);

        // Double the list 
        ListNode itr = reverseHead;
        int carry = 0;
        while(itr != null){
            int product = (itr.val)*2 + carry;

            itr.val = (product%10);
            carry = product/10;

            itr = itr.next;
        }

        // reverse the list
        head = reverse(reverseHead);
        if(carry != 0){
            itr = new ListNode(carry);
            itr.next = head;
            head = itr;
        }

        return head;
    }

    public ListNode doubleIt(ListNode head) {
        return doubleUsingRecursion(head);
        //return doubleIteratively(head);

    }
}