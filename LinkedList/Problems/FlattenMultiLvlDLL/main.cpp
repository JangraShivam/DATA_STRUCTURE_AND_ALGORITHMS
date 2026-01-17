// Problem : Flatten a Multilevel Doubly Linked List (LC - 430)

#include <iostream>
#include <vector>
using namespace std;

class Node{
public:
    int val;
    Node* next;
    Node* prev;
    Node* child;

    Node(int val){
        this->val = val;
        this->next = nullptr;
        this->prev = nullptr;
        this->child = nullptr;
    }
};

class CurrentNode{
public:
    Node* itr;

    CurrentNode(){
        this->itr = nullptr;
    }
};

class Solution {
    void flattenList(CurrentNode* &node){
        // base case
        if(node->itr == nullptr) return;
        
        // check if currentNode has a child 
        if(node->itr->child != nullptr){
            // store nextNode
            Node* nextNode = node->itr->next;
            
            // apply flatten logic
            node->itr->next = node->itr->child;
            node->itr->child->prev = node->itr;
            node->itr->child = nullptr;
            node->itr = node->itr->next;

            // recursive call for its child to flatten its child
            flattenList(node);

            // after recusive call attach currentNode to nextNode
            node->itr->next = nextNode;
            if(nextNode != nullptr) nextNode->prev = node->itr;
        }

        // further recursive call for list in same level
        if(node->itr->next != nullptr){
            node->itr = node->itr->next;
            flattenList(node);
        } 
    }
public:
    Node* flatten(Node* head) {
        CurrentNode* current = new CurrentNode();
        current->itr = head;
        flattenList(current);
        return head;
    }
};