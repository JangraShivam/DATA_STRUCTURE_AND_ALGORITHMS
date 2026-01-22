// Problem : Rotate List (LC - 61)

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
    ListNode* rotateRight(ListNode* head, int k) {
        // if list is empty or single return
        if(head == nullptr || head->next == nullptr) return head;

        // get Length of list and end node
        int len = 0;
        ListNode* tail = head;

        while(tail->next != nullptr){
            len++;
            tail = tail->next;
        }
        len++;

        //rotaing logic
        int effectiveRotate = k%len;
        if(effectiveRotate == 0) return head;

        tail->next = head; // join tail to head

        // disattach the list from effectiveRotate node from end
        int fromStart = len - effectiveRotate;
        int nodeNo = 1;

        while(nodeNo < fromStart){
            head = head->next;
            nodeNo++;
        }

        ListNode* newHead = head->next;
        head->next = nullptr;

        return newHead;

    }
};