// Problem : Flatten a Multilevel Doubly Linked List (LC - 430)

class Node{

    public int val;
    public Node next;
    public Node prev;
    public Node child;

    Node(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
        this.child = null;
    }
}

class CurrentNode{

    public Node itr;

    CurrentNode(){
        this.itr = null;
    }
};

class Solution {
    void flattenList(CurrentNode node){
        // base case
        if(node.itr == null) return;
        
        // check if currentNode has a child 
        if(node.itr.child != null){
            // store nextNode
            Node nextNode = node.itr.next;
            
            // apply flatten logic
            node.itr.next = node.itr.child;
            node.itr.child.prev = node.itr;
            node.itr.child = null;
            node.itr = node.itr.next;

            // recursive call for its child to flatten its child
            flattenList(node);

            // after recusive call attach currentNode to nextNode
            node.itr.next = nextNode;
            if(nextNode != null) nextNode.prev = node.itr;
        }

        // further recursive call for list in same level
        if(node.itr.next != null){
            node.itr = node.itr.next;
            flattenList(node);
        } 
    }

    public Node flatten(Node head) {
        CurrentNode current = new CurrentNode();
        current.itr = head;
        flattenList(current);
        return head;
    }
};

public class Main{

    public static void main(String[] args) {
        
    }
}