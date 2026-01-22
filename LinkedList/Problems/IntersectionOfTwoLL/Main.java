// Problem : Intersection of Two Linked Lists (GFG)

import java.util.HashSet;

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
    
    public Node findIntersection(Node head1, Node head2) {
        // store list head2 nodes value in a set
        HashSet<Integer> st = new HashSet<>();

        while(head2 != null){
            st.add(head2.data);
            head2 = head2.next;
        }

        // traverse the list head1 and eliminate node which are not in set st
        Node itr = head1;
        Node prevItr = null;
        while(itr != null){
            // check if itr node value is not in set -> delete it
            if(!st.contains(itr.data)){
                // if itr is head node
                if(itr == head1){
                    prevItr = itr;
                    itr = itr.next;
                    prevItr.next = null;
                    prevItr = null;

                    head1 = itr; // update head
                }
                else{
                    prevItr.next = itr.next;
                    itr.next = null;
                    itr = prevItr.next;
                }
            }
            else{
                prevItr = itr;
                itr = itr.next;
            }
        }

        return head1;
    }
}