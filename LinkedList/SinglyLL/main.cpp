// Singly Linked List

#include<iostream>
using namespace std;

class Node{
public:
    int data;
    Node* next;

    Node(int data){
        this->data = data;
        this->next = NULL;
    }
};

class SinglyLL{
public:
    Node* head;
    Node* tail;

    SinglyLL(){
        this->head = NULL;
        this->tail = NULL;
    }

    // Search in List
    bool search(int target){
        Node* itr = this->head;
        while(itr != NULL){
            if(itr->data == target) return true;
            itr = itr->next;
        }
        return false;
    }

    // get list length
    int getLength(){
        Node* itr = this->head;
        int length = 0;
        while(itr != NULL){
            length++;
            itr = itr->next;
        }
        return length;
    }

    // insert at head
    void insertAtHead(int value){
        // Create the node to add with given value
        Node* newNode = new Node(value);

        // check if both head and tail ptr is null
        if(this->head == NULL && this->tail == NULL){
            this->head = newNode;
            this->tail = newNode;
        }
        else{
            // attach newnode next to head node
            newNode->next = this->head;
            // move head to new node
            this->head = newNode;
        }
    }

    // insert at tail
    void insertAtTail(int value){
        // Create the node to add with given value
        Node* newNode = new Node(value);

        // check if both head and tail ptr is null
        if(this->head == NULL && this->tail == NULL){
            this->head = newNode;
            this->tail = newNode;
        }
        else{
            // attach new node to tail
            this->tail->next = newNode;
            // move tail to new node
            this->tail = newNode;
        }
    }

    // Insert At position (0 based)
    void insertAtPosition(int position, int value){

        // pos < 0 or pos > length -> not a valid position
        if(position < 0 || position >= this->getLength()){
            cout << "Not a valid position" << endl;
            return;
        }

        // pos = 0 or list empty -> insert at head
        if(position == 0 || (this->head == NULL && this->tail == NULL)){
            this->insertAtHead(value);
            return;
        }

        int currPosition = 0; // track current position
        Node* currentNode = head; // node at current position
        Node* previousNode = NULL; // node previous then current node

        // Traverse the list until position is reached or list end
        while(currPosition < position && currentNode != NULL){
            currPosition++;
            previousNode = currentNode;
            currentNode = currentNode->next;
        }

        // create the Node to be added
        Node* newNode = new Node(value);

        // adding logic (if pos > length of list -> add in the end)
        previousNode->next = newNode;
        newNode->next = currentNode;

        return;
    }


    // Delete node from head
    void deleteFromHead(){
        
        // check if list is empty
        if(this->head == NULL && this->tail == NULL){
            cout << "List is Empty" << endl;
            return;
        }

        // check if only one node is in list
        if(this->head == this->tail){
            delete this->head;
            this->head = NULL;
            this->tail = NULL;
            return;
        }

        // more than one element
        Node* newHead = this->head->next;
        this->head->next = NULL;
        delete this->head;
        this->head = newHead;
        return;
    }

    // Delete node from tail
    void deleteFromTail(){
        
        // check if list is empty
        if(this->head == NULL && this->tail == NULL){
            cout << "List is Empty" << endl;
            return;
        }

        // check if only one node is in list
        if(this->head == this->tail){
            delete this->head;
            this->head = NULL;
            this->tail = NULL;
            return;
        }

        // more than one element
        Node* newTail = this->head;
        while (newTail->next != this->tail) newTail = newTail->next;

        newTail->next = NULL;
        delete this->tail;
        this->tail = newTail;
    }

    // Delete node from pos
    void deleteFromPosition(int position){
        
        // check if position < 0 -> not a valid position
        if(position < 0 || position >= this->getLength()){
            cout << "Not a valid position" << endl;
            return;
        }

        if(position == 0){
            this->deleteFromHead();
            return;
        }

        if(position == getLength() - 1){
            this->deleteFromTail();
            return;
        }

        // deletion logic
        int currPos = 0;
        Node* currentNode = this->head;
        Node* prevNode = this->tail;

        while(currPos < position){
            currPos++;
            prevNode = currentNode;
            currentNode =  currentNode->next;
        }

        prevNode->next = currentNode->next;
        currentNode->next = NULL;
        delete currentNode;
    }

    // delete by value
    void deleteByValue(int value){
        
        Node* currentNode = this->head;
        Node* prevNode = NULL;
        while(currentNode != NULL){
            Node* nextNode = currentNode->next;

            if(currentNode->data == value){
                if(currentNode == this->head) deleteFromHead();
                else if(currentNode ==  this->tail) deleteFromTail();
                else{
                    prevNode->next = currentNode->next;
                    currentNode->next = NULL;
                    delete currentNode;
                }
            }
            else prevNode = currentNode;
            currentNode = nextNode; 
        }
    }


    void printList(){
        Node* itr = this->head;
        cout << "List : " ;
        while(itr != NULL){
            cout << itr->data << "->";
            itr = itr->next;
        }
        cout << "N" << endl;
    }

};


int main(){

    SinglyLL* list1 = new SinglyLL();

    list1->insertAtHead(10); // 10 -> N
    list1->insertAtHead(20); // 20 -> 10 -> N
    list1->insertAtHead(30); // 30 -> 20 -> 10 -> N
    list1->insertAtHead(40); // 40 -> 30 -> 20 -> 10 -> N
    list1->printList();

    list1->insertAtTail(50); // 40 -> 30 -> 20 -> 10 -> 50 -> N
    list1->insertAtTail(60); // 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> N
    list1->insertAtTail(70); // 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> 70 -> N
    list1->printList();

    list1->insertAtPosition(2,80); // 40 -> 30 -> 80 -> 20 -> 10 -> 50 -> 60 -> 70 ->  N
    list1->insertAtPosition(5,90); // 40 -> 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
    list1->printList();

    if(list1->search(90)){
        cout << "Target Found" << endl;
    }
    else{
        cout << "Target Not Found" << endl;
    }

    list1->deleteFromHead(); // 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
    list1->printList();

    list1->deleteFromTail(); // 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> N
    list1->printList();

    list1->deleteFromPosition(3); // 30 -> 80 -> 20 -> 90 -> 50 -> 60 -> N
    list1->printList();

    list1->deleteFromHead(); // 80 -> 20 -> 90 -> 50 -> 60 -> N
    list1->printList();

    list1->deleteFromTail(); // 80 -> 20 -> 90 -> 50 -> N
    list1->printList();

    list1->deleteFromPosition(3); // 80 -> 20 -> 90 -> N
    list1->printList();

    list1->deleteFromHead(); // 20 -> 90 -> N
    list1->printList();

    list1->deleteFromTail(); // 20 -> N
    list1->printList();

    list1->deleteFromPosition(3); // not valid , 20 -> N
    list1->printList();

    list1->insertAtHead(20);
    list1->insertAtHead(30);
    list1->insertAtHead(20);
    list1->printList();

    list1->deleteByValue(20);
    list1->printList();

    delete list1;


    return 0;
}