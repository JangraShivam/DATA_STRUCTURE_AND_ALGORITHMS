// Problem : Add Two Numbers (LC - 2)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

        return sumHead;
    }
}
