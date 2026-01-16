// Problem : Sort a linked list of 0s, 1s and 2s (GFG)

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

    public Node segregate(Node head) {
        // Intialize iterators for 0 1 2 list separately
        Node zeroHead = null;
        Node zeroTail = null;

        Node oneHead = null;
        Node oneTail = null;

        Node twoHead = null;
        Node twoTail = null;

        // Iterate over whole list and separate 0 1 2 to their own list
        while(head != null){
            // separate current node from main list
            Node currentNode = head;
            head = head.next;
            currentNode.next = null;

            // add currentNode to right list
            if(currentNode.data == 0){
                if(zeroHead == null){
                    zeroHead = currentNode;
                    zeroTail = currentNode;
                }
                else{
                    zeroTail.next = currentNode;
                    zeroTail = currentNode;
                }
            }
            else if(currentNode.data == 1){
                if(oneHead == null){
                    oneHead = currentNode;
                    oneTail = currentNode;
                }
                else{
                    oneTail.next = currentNode;
                    oneTail = currentNode;
                }
            }
            else {
                if(twoHead == null){
                    twoHead = currentNode;
                    twoTail = currentNode;
                }
                else{
                    twoTail.next = currentNode;
                    twoTail = currentNode;
                }
            }
        }
        
        // merge 0 1 2 lists
        Node newHead = null;
        Node newTail = null;

        if(zeroHead != null){
            newHead = zeroHead;
            newTail = zeroTail;
        }

        if(oneHead != null){
            if(newHead == null){
                newHead = oneHead;
                newTail = oneTail;
            }
            else{
                newTail.next = oneHead;
                newTail = oneTail;
            }
        }

        if(twoHead != null){
            if(newHead == null){
                newHead = twoHead;
                newTail = twoTail;
            }
            else{
                newTail.next = twoHead;
                newTail = twoTail;
            }
        }

        return newHead;
    }
};

public class Main {

}
