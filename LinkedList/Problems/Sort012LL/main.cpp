// Problem : Sort a linked list of 0s, 1s and 2s (GFG)

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
    void insert(Node* &currentNode, Node* &head, Node* &tail){
        if(head == nullptr && tail == nullptr){
            head = tail = currentNode;
        }
        else{
            tail->next = currentNode;
            tail = currentNode;
        }
    }
public:
    Node* segregate(Node* head) {
        // Intialize iterators for 0 1 2 list separately
        Node* zeroHead = nullptr;
        Node* zeroTail = nullptr;

        Node* oneHead = nullptr;
        Node* oneTail = nullptr;

        Node* twoHead = nullptr;
        Node* twoTail = nullptr;

        // Iterate over whole list and separate 0 1 2 to their own list
        while(head != nullptr){
            // separate current node from main list
            Node* currentNode = head;
            head = head->next;
            currentNode->next = nullptr;

            // add currentNode to right list
            if(currentNode->data == 0) insert(currentNode, zeroHead, zeroTail);
            else if(currentNode->data == 1) insert(currentNode, oneHead, oneTail);
            else insert(currentNode, twoHead, twoTail);
        }

        // merge 0 1 2 lists
        Node* newHead = nullptr;
        Node* newTail = nullptr;

        if(zeroHead != nullptr){
            newHead = zeroHead;
            newTail = zeroTail;
        }

        if(oneHead != nullptr){
            if(newHead == nullptr){
                newHead = oneHead;
                newTail = oneTail;
            }
            else{
                newTail->next = oneHead;
                newTail = oneTail;
            }
        }

        if(twoHead != nullptr){
            if(newHead == nullptr){
                newHead = twoHead;
                newTail = twoTail;
            }
            else{
                newTail->next = twoHead;
                newTail = twoTail;
            }
        }

        return newHead;
    }
};