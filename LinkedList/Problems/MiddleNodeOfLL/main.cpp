// Middle Node of Linked list (LC - 876)

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

// Method 1
ListNode* getMiddleNode1(ListNode* head){
    // calculate total length
    ListNode* itr = head;
    int length = 0;
    while(itr != nullptr){
        length++;
        itr = itr->next;
    }

    int middleNodePosition = length/2; // position start from 0
    ListNode* middleNode = head;
    while(middleNode != nullptr && middleNodePosition){
        middleNode = middleNode->next;
        middleNodePosition--;
    }

    return middleNode;
}

// Method 2
ListNode* getMiddleNode2(ListNode* head){
    // intialize two iterators
    ListNode* slowItr = head;
    ListNode* fastItr = head;

    // fastItr traverse twice the speed of slowItr
    while(fastItr != nullptr && fastItr->next != nullptr){
        slowItr = slowItr->next;
        fastItr = fastItr->next->next;
    }

    return slowItr;
}

ListNode* middleNode(ListNode* head) {
    // return getMiddleNode1(head);
    return getMiddleNode2(head);
}