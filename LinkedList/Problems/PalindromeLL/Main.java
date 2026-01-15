// Problem : Palindrome Linked List (LC 234)

class ListNode{
    public int val;
    public ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution{

    public ListNode reverseIterative(ListNode head){
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

    public boolean isPalindrome(ListNode head) {
        // edge cases (empty or single element list)
        if(head == null || head.next == null) return true;

        // divide the list in two parts from middle
        // if even no of nodes (e.g. 1->2->3->4) -> (1->2) (3->4)
        // odd nodes (1->2->3->4->5) -> (1->2) (4->5) 3 -> either add in both or ignore
        ListNode slowItr = head;
        ListNode fastItr = head;

        while(fastItr.next.next != null && fastItr.next.next.next != null){
            slowItr = slowItr.next;
            fastItr = fastItr.next.next;
        }

        // Intialize two head for two lists
        ListNode head1 = head;
        ListNode head2 = null;

        // even no of nodes
        if(fastItr.next.next == null){
            head2 = slowItr.next;
            slowItr.next = null;
        }
        else{
            head2 = slowItr.next;
            slowItr.next = null;
            slowItr = head2;
            head2 = head2.next;
            slowItr.next = null;
        }

        // reverse the second list
        head2 = this.reverseIterative(head2);

        // now compare for palindrome
        while(head1 != null && head2 != null){
            if(head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

}


public class Main {
    public static void main(String[] args) {
        
    }
}
