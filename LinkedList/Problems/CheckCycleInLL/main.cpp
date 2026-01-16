// Problem : Linked List Cycle (LC 141)

#include <iostream>
#include <unordered_map>
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


class Solution{
    bool checkCycle1(ListNode* head){
        // store nodes address in a map
        unordered_map<ListNode* , bool> present;

        ListNode* itr = head;
        while(itr != nullptr){
            // check if this node is already traversed
            if(present[itr]) return true;
            // else add in map
            present[itr] = true;
            itr = itr->next;
        }
        return false;
    }

    bool checkCycle2(ListNode* head){
        ListNode* slowItr = head;
        ListNode* fastItr = head;

        while(fastItr != nullptr && fastItr->next != nullptr){
            slowItr = slowItr->next;
            fastItr = fastItr->next->next;

            if(fastItr == slowItr) return true;
        }

        return false;
    }
public:
    bool hasCycle(ListNode *head) {
        // return checkCycle1(head);
        return checkCycle2(head);
    }
};