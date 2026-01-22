// Problem : Copy List with Random Pointer (LC - 138)

import java.util.ArrayList;
import java.util.HashMap;

class Node{
    public int val;
    public Node next;
    public Node random;

    public Node(int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        // stores nodes with their index (0 based)
        HashMap<Node, Integer> nodesPosition = new HashMap<>();
        ArrayList<Node> track =  new ArrayList<>();

        // create a new list with same values
        Node newHead = null;
        Node newTail = null;

        int pos = 0;
        Node itr = head;
        while(itr != null){
            int currNodeValue = itr.val;
            nodesPosition.put(itr, pos++);
            itr = itr.next;

            // create a new Node
            Node newNode = new Node(currNodeValue);

            if(newHead == null){
                newHead = newNode;
                newTail = newNode;
            }
            else{
                newTail.next = newNode;
                newTail = newNode;
            }

            track.add(newNode);
        }


        itr = head;
        Node newItr = newHead;
        while(itr != null){
            if(itr.random != null ){
                int randomIndex = nodesPosition.get(itr.random);
                newItr.random = track.get(randomIndex);
            }

            itr = itr.next;
            newItr = newItr.next;
        }

        return newHead;
    }
}