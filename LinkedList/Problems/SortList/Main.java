// Problem : Sort List (LC - 148)

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    ListNode mergeSortedLists(ListNode head1, ListNode head2){
        ListNode mergeHead = null;
        ListNode mergeTail = null;

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                ListNode node = head1;
                head1 = head1.next;
                node.next = null;

                if(mergeHead == null){
                    mergeHead = node;
                    mergeTail = node;
                }
                else{
                    mergeTail.next = node;
                    mergeTail = node;
                }
            }
            else{
                ListNode node = head2;
                head2 = head2.next;
                node.next = null;

                if(mergeHead == null){
                    mergeHead = node;
                    mergeTail = node;
                }
                else{
                    mergeTail.next = node;
                    mergeTail = node;
                }
            }
        }

        while(head1 != null){
            ListNode node = head1;
            head1 = head1.next;
            node.next = null;

            mergeTail.next = node;
            mergeTail = node;
        }

        while(head2 != null){
            ListNode node = head2;
            head2 = head2.next;
            node.next = null;

            mergeTail.next = node;
            mergeTail = node;
        }

        return mergeHead;
    }
    ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next.next != null && fast.next.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    ListNode mergeSort(ListNode head){
        if(head.next == null) return head;

        ListNode midNode = getMiddleNode(head);
        ListNode head1 = head;
        ListNode head2 = midNode.next;
        midNode.next = null;

        head1 = mergeSort(head1);
        head2 = mergeSort(head2);

        return mergeSortedLists(head1,head2);
    }
    public ListNode sortList(ListNode head) {
        if(head == null) return head;
        return mergeSort(head);
    }
}