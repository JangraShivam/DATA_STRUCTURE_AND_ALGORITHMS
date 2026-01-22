// Problem : Odd Even Linked List (LC - 328)

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
    ListNode* oddEvenList(ListNode* head) {
        // if list is empty or single node
        if(head == nullptr || head->next == nullptr) return head;

        // intialize two list odd and even
        ListNode* oddHead = head;
        ListNode* oddTail =  head;
        head = head->next;
        oddHead->next = nullptr;

        ListNode* evenHead = head;
        ListNode* evenTail = head;
        head = head->next;
        evenHead->next = nullptr;

        while(head != nullptr){
            // add to odd list
            oddTail->next = head;
            oddTail = head;
            head = head->next;
            oddTail->next = nullptr;

            if(head == nullptr) break;

            // add to even list
            evenTail->next = head;
            evenTail = head;
            head = head->next;
            evenTail->next = nullptr;
        }

        // join odd and even
        oddTail->next = evenHead;

        return oddHead;
    }
};