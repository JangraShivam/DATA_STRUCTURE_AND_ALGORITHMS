// Doubly Circular Linked List

class Node{
    public int data;
    public Node next;
    public Node prev;

    Node(int data){
        this.data = data;
        this.next = this;
        this.prev = this;
    }
}

class DoublyCircularLL{
    private Node iterator;
    
    public DoublyCircularLL(){
        this.iterator = null;
    }

    public int getLength(){
        Node itr = this.iterator;
        itr = itr.next;
        int length = 1;

        while(itr != this.iterator){
            length++;
            itr = itr.next;
        }

        return length;
    }

    public boolean search(int target){
        Node itr = this.iterator;
        int length = this.getLength();

        for(int i = 0; i < length; i++){
            if(itr.data == target) return true;
            itr = itr.next;
        }

        return false;
    }

    public void insert(int value){
        Node newNode = new Node(value);

        if(this.iterator == null){
            this.iterator = newNode;
        }
        else{
            newNode.next = this.iterator.next;
            newNode.next.prev = newNode;
            this.iterator.next = newNode;
            newNode.prev = this.iterator;
        }
    }

    public void deleteByValue(int value){

        if(this.iterator == null){
            System.out.println("List is empty");
            return;
        }

        if(this.iterator.next == this.iterator && this.iterator.data == value){
            this.iterator = null;
            return;
        }

        Node current = this.iterator.next;

        while(current != this.iterator){
            Node nextNode = current.next;
            if(current.data == value){
                current.prev.next = nextNode;
                nextNode.prev = current.prev;
                current.next = null;
                current.prev = null;
            }
            
            current = nextNode;
        }

    }

    public void print(){
        int length = this.getLength();
        System.out.print("List : ");
        for(int i = 0; i < length; i++){
            System.out.print((this.iterator.data + "->"));
            this.iterator = this.iterator.next;
        }
        System.out.println(this.iterator.data);
    }

    public void printReverse(){
        int length = this.getLength();
        System.out.print("List : ");
        for(int i = 0; i < length; i++){
            System.out.print((this.iterator.data + "->"));
            this.iterator = this.iterator.prev;
        }
        System.out.println(this.iterator.data);
    }
}

public class Main {

    public static void main(String[] args) {
        DoublyCircularLL list1 = new DoublyCircularLL();

        list1.insert(10);
        list1.insert(40);
        list1.insert(30);
        list1.insert(20);
        list1.print();
        list1.printReverse();

        if(list1.search(-1)){
            System.out.println("Target found");
        } 
        else{
            System.out.println("Target not found");
        } 

        list1.deleteByValue(20);
        list1.print();
        list1.printReverse();
    }
}
