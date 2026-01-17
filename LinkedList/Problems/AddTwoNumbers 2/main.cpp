// Problem : Add Two Numbers 2 (LC - 445)

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
    ListNode* reverse(ListNode* head){
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
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // reverse both lists
        l1 = reverse(l1);
        l2 = reverse(l2);

        //add both lists
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

        // reverse sum list
        sumHead = reverse(sumHead);

        return sumHead;
    }
};