class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class SinglyLL{
    public Node head;
    public Node tail;

    public SinglyLL(){
        this.head = null;
        this.tail = null;
    }

    // Search in List
    public boolean search(int target){
        Node itr = this.head;
        while(itr != null){
            if(itr.data == target) return true;
            itr = itr.next;
        }
        return false;
    }

    // get list length
    public int getLength(){
        Node itr = this.head;
        int length = 0;
        while(itr != null){
            length++;
            itr = itr.next;
        }
        return length;
    }

    // insert at head
    public void insertAtHead(int value){
        // Create the node to add with given value
        Node newNode = new Node(value);

        // check if both head and tail ptr is null
        if(this.head == null && this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            // attach newnode next to head node
            newNode.next = this.head;
            // move head to new node
            this.head = newNode;
        }
    }

    // insert at tail
    public void insertAtTail(int value){
        // Create the node to add with given value
        Node newNode = new Node(value);

        // check if both head and tail ptr is null
        if(this.head == null && this.tail == null){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            // attach new node to tail
            this.tail.next = newNode;
            // move tail to new node
            this.tail = newNode;
        }
    }

    // Insert At position (0 based)
    public void insertAtPosition(int position, int value){

        // pos < 0 or pos > length -> not a valid position
        if(position < 0 || position >= this.getLength()){
            System.out.println("Not a valid position");
            return;
        }

        // pos = 0 or list empty -> insert at head
        if(position == 0 || (this.head == null && this.tail == null)){
            this.insertAtHead(value);
            return;
        }

        int currPosition = 0; // track current position
        Node currentNode = this.head; // node at current position
        Node previousNode = null; // node previous then current node

        // Traverse the list until position is reached or list end
        while(currPosition < position && currentNode != null){
            currPosition++;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // create the Node to be added
        Node newNode = new Node(value);

        // adding logic (if pos > length of list -> add in the end)
        previousNode.next = newNode;
        newNode.next = currentNode;

        return;
    }

    // Delete node from head
    public void deleteFromHead(){
        
        // check if list is empty
        if(this.head == null && this.tail == null){
            System.out.println("List is Empty");
            return;
        }

        // check if only one node is in list
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }

        // more than one element
        Node newHead = this.head.next;
        this.head.next = null;
        this.head = newHead;
        return;
    }

    // Delete node from tail
    public void deleteFromTail(){
        
        // check if list is empty
        if(this.head == null && this.tail == null){
            System.out.println("List is Empty");
            return;
        }

        // check if only one node is in list
        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
            return;
        }

        // more than one element
        Node newTail = this.head;
        while (newTail.next != this.tail) newTail = newTail.next;

        newTail.next = null;
        this.tail = newTail;
        return;
    }

    // Delete node from pos
    public void deleteFromPosition(int position){
        
        // check if position < 0 -> not a valid position
        if(position < 0 || position >= this.getLength()){
            System.out.println( "Not a valid position");
            return;
        }

        if(position == 0){
            this.deleteFromHead();
            return;
        }

        if(position == this.getLength() - 1){
            this.deleteFromTail();
            return;
        }

        // deletion logic
        int currPos = 0;
        Node currentNode = this.head;
        Node prevNode = this.tail;

        while(currPos < position){
            currPos++;
            prevNode = currentNode;
            currentNode =  currentNode.next;
        }

        prevNode.next = currentNode.next;
        currentNode.next = null;
        return;
    }

    public void deleteByValue(int value){
        
        Node currentNode = this.head;
        Node prevNode = null;
        while(currentNode != null){
            Node nextNode = currentNode.next;

            if(currentNode.data == value){
                if(currentNode == this.head) deleteFromHead();
                else if(currentNode ==  this.tail) deleteFromTail();
                else{
                    prevNode.next = currentNode.next;
                    currentNode.next = null;
                }
            }
            else prevNode = currentNode;
            currentNode = nextNode; 
        }
    }

    public void printList(){
        Node itr = this.head;
        System.out.print("List : ");
        while(itr != null){
            System.out.print(itr.data + "->");
            itr = itr.next;
        }
        System.out.println("N");
    }

}

public class Main {
    public static void main(String[] args) {
        SinglyLL list1 = new SinglyLL();

        list1.insertAtHead(10); // 10 -> N
        list1.insertAtHead(20); // 20 -> 10 -> N
        list1.insertAtHead(30); // 30 -> 20 -> 10 -> N
        list1.insertAtHead(40); // 40 -> 30 -> 20 -> 10 -> N
        list1.printList();

        list1.insertAtTail(50); // 40 -> 30 -> 20 -> 10 -> 50 -> N
        list1.insertAtTail(60); // 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> N
        list1.insertAtTail(70); // 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> 70 -> N
        list1.printList();

        list1.insertAtPosition(2,80); // 40 -> 30 -> 80 -> 20 -> 10 -> 50 -> 60 -> 70 ->  N
        list1.insertAtPosition(5,90); // 40 -> 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
        list1.printList();

        if(list1.search(90)){
            System.out.println("Target Found");
        }
        else{
            System.out.println("Target Not Found");
        }

        list1.deleteFromHead(); // 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
        list1.printList();

        list1.deleteFromTail(); // 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> N
        list1.printList();

        list1.deleteFromPosition(3); // 30 -> 80 -> 20 -> 90 -> 50 -> 60 -> N
        list1.printList();

        list1.deleteFromHead(); // 80 -> 20 -> 90 -> 50 -> 60 -> N
        list1.printList();

        list1.deleteFromTail(); // 80 -> 20 -> 90 -> 50 -> N
        list1.printList();

        list1.deleteFromPosition(3); // 80 -> 20 -> 90 -> N
        list1.printList();

        list1.deleteFromHead(); // 20 -> 90 -> N
        list1.printList();

        list1.deleteFromTail(); // 20 -> N
        list1.printList();

        list1.deleteFromPosition(3); // not valid , 20 -> N
        list1.printList();


    }

    
}
