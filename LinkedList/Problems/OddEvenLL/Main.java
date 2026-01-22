// Problem : Odd Even Linked List (LC - 328)


class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // if list is empty or single node
        if(head == null || head.next == null) return head;

        // intialize two list odd and even
        ListNode oddHead = head;
        ListNode oddTail =  head;
        head = head.next;
        oddHead.next = null;

        ListNode evenHead = head;
        ListNode evenTail = head;
        head = head.next;
        evenHead.next = null;

        while(head != null){
            // add to odd list
            oddTail.next = head;
            oddTail = head;
            head = head.next;
            oddTail.next = null;

            if(head == null) break;

            // add to even list
            evenTail.next = head;
            evenTail = head;
            head = head.next;
            evenTail.next = null;
        }

        // join odd and even
        oddTail.next = evenHead;

        return oddHead;
    }
}