// Problem : Reverse a Linked List (LC 206)

#include <iostream>
using namespace std;

class ListNode{
public:
    int val;
    ListNode* next;

    ListNode(int val){
        this->val = val;
        this->next = nullptr;
    }
};

// Recursive Method
ListNode* reverseRecursive(ListNode* current, ListNode* prev, ListNode* nextNode){
    // Base case
    if(current == nullptr) return prev;

    // reverse logic
    current->next = prev;
    prev = current;
    current = nextNode;
    if(nextNode != nullptr) nextNode = nextNode->next;

    return reverseRecursive(current,prev,nextNode);
}

// Iterative method
ListNode* reverseIterative(ListNode* head){
    // check if list is empty or single node (yes -> no need to reverse)
    if(head == nullptr || head->next == nullptr) return head;

    // Intialize three iterators
    ListNode* prev = nullptr;
    ListNode* current = head;
    ListNode* nextNode = head->next; 

    // Iterate until current becomes null or on whole list
    while(current != nullptr){
        // reverse logic
        current->next = prev;
        prev = current;
        current = nextNode;
        if(nextNode != nullptr) nextNode = nextNode->next;
    }

    // reverse list head
    return prev;
}

ListNode* reverseList(ListNode* head) {
    // if list is empty
    if(head == nullptr) return nullptr;

    //return reverseIterative(head);
    return reverseRecursive(head,nullptr,head->next);
}



