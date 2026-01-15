

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution{

    // Method 1
    public ListNode getMiddleNode1(ListNode head){
        // calculate total length
        ListNode itr = head;
        int length = 0;
        while(itr != null){
            length++;
            itr = itr.next;
        }

        int middleNodePosition = length/2; // position start from 0
        ListNode middleNode = head;
        while(middleNode != null && middleNodePosition > 0){
            middleNode = middleNode.next;
            middleNodePosition--;
        }

        return middleNode;
    }

    // Method 2
    public ListNode getMiddleNode2(ListNode head){
        // intialize two iterators
        ListNode slowItr = head;
        ListNode fastItr = head;

        // fastItr traverse twice the speed of slowItr
        while(fastItr != null && fastItr.next != null){
            slowItr = slowItr.next;
            fastItr = fastItr.next.next;
        }

        return slowItr;
    }

    public ListNode middleNode(ListNode head) {
        // return getMiddleNode1(head);
        return getMiddleNode2(head);
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}
