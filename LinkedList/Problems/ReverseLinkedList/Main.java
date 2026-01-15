// Problem : Reverse a Linked List (LC 206)

class ListNode{
    public int val;
    public ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}


class Solution{

    // Recursive Method
    public ListNode reverseRecursive(ListNode current, ListNode prev, ListNode nextNode){
        // Base case
        if(current == null) return prev;

        // reverse logic
        current.next = prev;
        prev = current;
        current = nextNode;
        if(nextNode != null) nextNode = nextNode.next;

        return reverseRecursive(current,prev,nextNode);
    }

    // Iterative method
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

    public ListNode reverseList(ListNode head) {
        // if list is empty
        if(head == null) return null;

        //return reverseIterative(head);
        return reverseRecursive(head,null,head.next);
    }


}

public class Main{

    public static void main(String[] args) {
        
    }
}