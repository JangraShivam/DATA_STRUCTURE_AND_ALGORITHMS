// Doubly Linked List

class Node{
    public int data;
    public Node next;
    public Node prev;

    public Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLL{
    public Node head;
    public Node tail;

    public DoublyLL(){
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
            this.head.prev = newNode;
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
            newNode.prev = this.tail;
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

        // position = last -> insert at tail
        if(position == this.getLength()){
            this.insertAtTail(value);
            return;
        }

        int currPosition = 0; // track current position
        Node currentNode = this.head; // node at current position

        // Traverse the list until position is reached or list end
        while(currPosition < position && currentNode != null){
            currPosition++;
            currentNode = currentNode.next;
        }

        // create the Node to be added
        Node newNode = new Node(value);

        // adding logic (if pos > length of list -> add in the end)
        newNode.prev = currentNode.prev;
        currentNode.prev.next = newNode;
        newNode.next = currentNode;
        currentNode.prev = newNode;

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
        newHead.prev = null;
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
        Node newTail = this.tail.prev;
        newTail.next = null;
        this.tail.prev = null;
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

        while(currPos < position){
            currPos++;
            currentNode =  currentNode.next;
        }

        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        currentNode.prev = null;
        currentNode.next = null;
        return;
    }

    // Delete node by value
    void deleteByValue(int value){
        
        Node currentNode = this.head;

        while(currentNode != null){
            Node nextNode = currentNode.next;
            if(currentNode.data == value){
                if(currentNode == this.head) deleteFromHead();
                else if(currentNode ==  this.tail) deleteFromTail();
                else{
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                    currentNode.prev = null;
                    currentNode.next = null;
                }
            }

            currentNode = nextNode;
        }
    }


    void printList(){
        Node itr = this.head;
        System.out.print("List : ");
        while(itr != null){
            System.out.print(itr.data + "->");
            itr = itr.next;
        }
        System.out.println("N");
    }

    void printReverseList(){
        Node itr = this.tail;
        while(itr != null){
            System.out.print(itr.data + "->");
            itr = itr.prev;
        }
        System.out.println("N");
    }

}

public class Main {
    public static void main(String[] args) {
        DoublyLL list1 = new DoublyLL();

        list1.insertAtHead(10); // 10 -> N
        list1.insertAtHead(20); // 20 -> 10 -> N
        list1.insertAtHead(30); // 30 -> 20 -> 10 -> N
        list1.insertAtHead(40); // 40 -> 30 -> 20 -> 10 -> N
        list1.printList();
        list1.printReverseList();

        list1.insertAtTail(50); // 40 -> 30 -> 20 -> 10 -> 50 -> N
        list1.insertAtTail(60); // 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> N
        list1.insertAtTail(70); // 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> 70 -> N
        list1.printList();
        list1.printReverseList();

        list1.insertAtPosition(2,80); // 40 -> 30 -> 80 -> 20 -> 10 -> 50 -> 60 -> 70 ->  N
        list1.insertAtPosition(5,90); // 40 -> 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
        list1.printList();
        list1.printReverseList();

        if(list1.search(90)){
            System.out.println("Target Found");
        }
        else{
            System.out.println("Target Not Found");
        }

        list1.deleteFromHead(); // 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromTail(); // 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromPosition(3); // 30 -> 80 -> 20 -> 90 -> 50 -> 60 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromHead(); // 80 -> 20 -> 90 -> 50 -> 60 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromTail(); // 80 -> 20 -> 90 -> 50 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromPosition(3); // 80 -> 20 -> 90 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromHead(); // 20 -> 90 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromTail(); // 20 -> N
        list1.printList();
        list1.printReverseList();

        list1.deleteFromPosition(3); // not valid , 20 -> N
        list1.printList();
        list1.printReverseList();

        list1.insertAtHead(20);
        list1.insertAtTail(30);
        list1.printList();
        list1.deleteByValue(20);
        list1.printList();


    }

    
}
