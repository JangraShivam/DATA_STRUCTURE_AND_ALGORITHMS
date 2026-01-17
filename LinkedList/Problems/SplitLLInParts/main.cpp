// Problem : Split Linked List in Parts (LC - 725)

#include <iostream>
#include <vector>
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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        // get length of list
        int len = 0;
        ListNode* itr = head;

        while(itr != nullptr){
            len++;
            itr = itr->next;
        }

        // split the list
        int minNodes = len/k; // each part will get this much nodes
        int extraNodes = len%k; // will be distributed one by one from staring

        // intialize vector to store list parts head
        vector<ListNode*> parts(k,nullptr);

        // allocate nodes for each part
        for(int i = 0; i < k; i++){
            // check if list is empty
            if(head == nullptr) break;

            // allocate nodes for current part
            parts[i] = head;
            ListNode* itr = nullptr;
            int currentPartNodes = minNodes + (extraNodes > 0);

            // allocate current part Nodes
            while(currentPartNodes > 0){
                itr = head;
                currentPartNodes--;
                head = head->next;
            }
            
            // disconnect current part
            itr->next = nullptr;
        }

        return parts;
    }
};