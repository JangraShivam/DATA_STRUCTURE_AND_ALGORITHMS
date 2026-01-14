// Singly Circular Linked List

#include <iostream>
using namespace std;

class Node{
public:
    int data;
    Node* next;

    Node(int data){
        this->data = data;
        this->next = this;
    }
};

class SinglyCircularLL{
    Node* iterator;
public:
    
    SinglyCircularLL(){
        this->iterator = NULL;
    }

    int getLength(){
        Node* itr = this->iterator;
        itr = itr->next;
        int length = 1;

        while(itr != this->iterator){
            length++;
            itr = itr->next;
        }

        return length;
    }

    bool search(int target){
        Node* itr = this->iterator;
        int length = this->getLength();

        for(int i = 0; i < length; i++){
            if(itr->data == target) return true;
            itr = itr->next;
        }

        return false;
    }

    void insert(int value){
        Node* newNode = new Node(value);

        if(this->iterator == NULL){
            this->iterator = newNode;
        }
        else{
            newNode->next = this->iterator->next;
            this->iterator->next = newNode;
        }
    }

    void deleteByValue(int value){

        if(this->iterator == NULL){
            cout << "List is empty" << endl;
            return;
        }

        if(this->iterator->next == this->iterator && this->iterator->data == value){
            delete this->iterator;
            this->iterator = NULL;
            return;
        }

        Node* current = this->iterator;
        Node* nextNode = current->next;

        while(nextNode != this->iterator){
            if(nextNode->data == value){
                current->next = nextNode->next;
                nextNode->next = NULL;
                delete nextNode;

                nextNode = current->next;
            }
            else{
                current = nextNode;
                nextNode = nextNode->next;
            }
        }

    }

    void print(){
        int length = this->getLength();
        cout << "List : ";
        for(int i = 0; i < length; i++){
            cout << (this->iterator->data) << "->";
            this->iterator = this->iterator->next;
        }
        cout << (this->iterator->data) << endl;
    }
};

int main(){

    SinglyCircularLL* list1 = new SinglyCircularLL();

    list1->insert(10);
    list1->insert(20);
    list1->insert(30);
    list1->insert(20);
    list1->print();

    if(list1->search(-1)){
        cout << "Target found" << endl;
    } 
    else{
        cout << "Target not found" << endl;
    } 

    list1->deleteByValue(20);
    list1->print();

    delete list1;
    return 0;
}