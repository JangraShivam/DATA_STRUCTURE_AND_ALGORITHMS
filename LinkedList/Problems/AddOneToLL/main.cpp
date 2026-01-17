// Problem : Add 1 to a Linked List Number (GFG)

#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int data)
    {
        this->data = data;
        this->next = nullptr;
    }
};


class Solution {
  public:
    int addOneRecursive(Node* head){
        // Base case return 1 to add 
        if(head == nullptr) return 1;

        int carry = addOneRecursive(head->next);
        int sum = (head->data) + carry;

        head->data = (sum % 10);
        return (sum/10);
    }

    Node* addOneRecursively(Node* head){
        // recusively
        int carry = addOneRecursive(head);
        if(carry != 0){
            Node* newNode = new Node(carry);
            newNode->next = head;
            head = newNode;
        }

        return head;
    }

    Node* addOneIterative(Node* head) {
        // reverse the list 
        Node* prev = nullptr;
        Node* current = head;
        Node* nextNode = head->next;

        while(current != nullptr){
            current->next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != nullptr) nextNode = nextNode->next;
        }

        // update head
        head = prev;

        // add 1 to LL 
        int carry = 1; 
        while(prev != nullptr && carry != 0){
            int sum = (prev->data) + carry;

            prev->data = (sum % 10);
            carry = (sum / 10);

            prev = prev->next;
        }

        // reverse the list again
        prev = nullptr;
        current = head;
        nextNode = head->next;
        while(current != nullptr){
            current->next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != nullptr) nextNode = nextNode->next;
        }

        //update head
        head = prev;

        // check if carry is not equal to zero
        if(carry != 0){
            Node* newNode = new Node(carry);
            // insert at head
            newNode->next = head;
            head = newNode;
        }

        return head;
    }

    Node* addOne(Node* head) {
        // return addOneIterative(head);
        return addOneRecursively(head);  
    }
};