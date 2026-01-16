// Problem : Add Two Numbers (LC - 2)

#include <iostream>
using namespace std;

class ListNode {
public:
    int val;
    ListNode* next;

    ListNode(int val)
    {
        this->val = val;
        this->next = nullptr;
    }
};


class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        
        int carry = 0;
        ListNode* sumHead = nullptr;
        ListNode* sumTail = nullptr;

        while(l1 != nullptr && l2 != nullptr){
            int sum = (l1->val) + (l2->val) + carry;

            ListNode* newNode = new ListNode((sum % 10));
            carry = sum/10;

            if(sumHead == nullptr){
                sumHead = newNode;
                sumTail = newNode;
            }
            else{
                sumTail->next = newNode;
                sumTail = newNode;
            }

            l1 = l1->next;
            l2 = l2->next;
        }

        while(l1 != nullptr){
            int sum = (l1->val) + carry;

            ListNode* newNode = new ListNode((sum % 10));
            carry = sum/10;

            sumTail->next = newNode;
            sumTail = newNode;

            l1 = l1->next;
        }

        while(l2 != nullptr){
            int sum = (l2->val) + carry;

            ListNode* newNode = new ListNode((sum % 10));
            carry = sum/10;

            sumTail->next = newNode;
            sumTail = newNode;

            l2 = l2->next;
        }

        if(carry != 0){
            ListNode* newNode = new ListNode(carry);
            sumTail->next = newNode;
            sumTail = newNode;
        }

        return sumHead;
    }
};