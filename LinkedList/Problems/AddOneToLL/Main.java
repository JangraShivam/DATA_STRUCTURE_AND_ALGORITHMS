// Problem : Add 1 to a Linked List Number (GFG)

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
    public int addOneRecursive(Node head){
        // Base case return 1 to add 
        if(head == null) return 1;

        int carry = addOneRecursive(head.next);
        int sum = (head.data) + carry;

        head.data = (sum % 10);
        return (sum/10);
    }

    public Node addOneRecursively(Node head){
        // recusively
        int carry = addOneRecursive(head);
        if(carry != 0){
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
    public Node addOneIterative(Node head) {
        // reverse the list 
        Node prev = null;
        Node current = head;
        Node nextNode = head.next;

        while(current != null){
            current.next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != null) nextNode = nextNode.next;
        }

        // update head
        head = prev;

        // add 1 to LL 
        int carry = 1; 
        while(prev != null && carry != 0){
            int sum = (prev.data) + carry;

            prev.data = (sum % 10);
            carry = (sum / 10);

            prev = prev.next;
        }

        // reverse the list again
        prev = null;
        current = head;
        nextNode = head.next;
        while(current != null){
            current.next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != null) nextNode = nextNode.next;
        }

        //update head
        head = prev;

        // check if carry is not equal to zero
        if(carry != 0){
            Node newNode = new Node(carry);
            // insert at head
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public Node addOne(Node head) {
        // return addOneIterative(head);
        return addOneRecursively(head);  
    }
}

public class Main {

}
