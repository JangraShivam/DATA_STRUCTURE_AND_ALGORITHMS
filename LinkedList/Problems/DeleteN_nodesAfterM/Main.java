// Problem : Delete N nodes after M nodes of a linked list (GFG)

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
    static void linkdelete(Node head, int n, int m) {
        // Intialize a iterator to traverse
        Node itr = head;

        // traverse on list
        while(itr != null){
            // skip m nodes
            int skip = 0;

            // reach at end of m nodes
            while(skip < m-1){
                // node skipped
                itr = itr.next;
                skip++;
                if(itr == null) return; // nothing to skip so return
            }

            // delete n nodes
            int deleted = 0;
            while(deleted < n){
                // check if there is node next to delete
                if(itr.next == null) return;

                Node delNode = itr.next; // node to be deleted
                itr.next = delNode.next;
                delNode.next = null;

                deleted++;
            }

            // move itr
            itr = itr.next;
        }
        
        return;
        
    }
}