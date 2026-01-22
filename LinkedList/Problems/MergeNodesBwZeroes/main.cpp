// Problem : Merge Nodes in Between Zeros (LC - 2181)

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
    ListNode* mergeNodes(ListNode* head) {
        // simulate the question descp

        ListNode* modifiedHead = nullptr;
        ListNode* modifiedTail = nullptr;
        int sum = 0;

        ListNode* itr = head->next;
        while(itr != nullptr){
            if(itr->val == 0){
                ListNode* newNode = new ListNode(sum);

                if(modifiedHead == nullptr){
                    modifiedHead = newNode;
                    modifiedTail = newNode;
                }
                else{
                    modifiedTail->next = newNode;
                    modifiedTail = newNode;
                }

                sum = 0;
            }

            sum += (itr->val);
            itr = itr->next;
        }

        return modifiedHead;
    }
};