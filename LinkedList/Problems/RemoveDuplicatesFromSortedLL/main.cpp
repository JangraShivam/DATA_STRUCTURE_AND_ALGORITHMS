// Problem : Remove Duplicates from Sorted List (LC - 83)

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


class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        // check if list is empty or single node in list
        if(head == nullptr || head->next == nullptr) return head;

        // Intialize two iterators
        ListNode* prevNode = head;
        ListNode* currentNode = head->next;

        // Iterate on list
        while(currentNode != nullptr){
            // check if currentnode val == prevNode val if true delete currentNode
            if(currentNode->val == prevNode->val){
                prevNode->next = currentNode->next;
                currentNode->next = nullptr;
                delete currentNode;
                currentNode = prevNode->next;
            }
            else{
                prevNode = currentNode;
                currentNode = prevNode->next;
            }
        }

        return head;
    }
};