// Problem : Kth from End of Linked List (GFG)

class Node {
    public int data;
    public Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}


class Solution {
    private int k;
    // Method 1 -> recursive
    int getKthRecursively(Node head){
        // Base case 
        if(head == null) return -1;
        int ans = this.getKthRecursively(head.next);

        // update k
        k--;

        if(k == 0){
            return head.data;
        }
        else{
            return ans;
        }
    }

    // Method 2 iterative
    int getKthIteratively(Node head){
        /*
            one approach can be to reverse the list and return kth node from start
        */

        // get Length of list
        int len = 0;
        Node itr = head;

        while(itr != null){
            len++;
            itr = itr.next;
        }

        // check if k is greater than list length
        if(k > len) return -1;

        // kth node from end = (len - k + 1) node from the start
        k = len - k + 1;

        itr = head;
        while(itr != null){
            k--;
            if(k == 0) return itr.data;
            itr = itr.next;
        }

        return -1;
    }
    int getKthFromLast(Node head, int k) {
        this.k = k;
        return this.getKthIteratively(head);
        // return this.getKthRecursively(head);
    }
}