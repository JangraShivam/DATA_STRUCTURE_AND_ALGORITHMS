// Problem : Sort List (LC - 148)

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
    ListNode* mergeSortedLists(ListNode* head1, ListNode* head2){
        ListNode* mergeHead = nullptr;
        ListNode* mergeTail = nullptr;

        while(head1 != nullptr && head2 != nullptr){
            if(head1->val <= head2->val){
                ListNode* node = head1;
                head1 = head1->next;
                node->next = nullptr;

                if(mergeHead == nullptr){
                    mergeHead = node;
                    mergeTail = node;
                }
                else{
                    mergeTail->next = node;
                    mergeTail = node;
                }
            }
            else{
                ListNode* node = head2;
                head2 = head2->next;
                node->next = nullptr;

                if(mergeHead == nullptr){
                    mergeHead = node;
                    mergeTail = node;
                }
                else{
                    mergeTail->next = node;
                    mergeTail = node;
                }
            }
        }

        while(head1 != nullptr){
            ListNode* node = head1;
            head1 = head1->next;
            node->next = nullptr;

            mergeTail->next = node;
            mergeTail = node;
        }

        while(head2 != nullptr){
            ListNode* node = head2;
            head2 = head2->next;
            node->next = nullptr;

            mergeTail->next = node;
            mergeTail = node;
        }

        return mergeHead;
    }
    ListNode* getMiddleNode(ListNode* head){
        ListNode* slow = head;
        ListNode* fast = head;

        while(fast->next->next != nullptr && fast->next->next->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;
        }

        return slow;
    }
    ListNode* mergeSort(ListNode* head){
        if(head->next == nullptr) return head;

        ListNode* midNode = getMiddleNode(head);
        ListNode* head1 = head;
        ListNode* head2 = midNode->next;
        midNode->next = nullptr;

        head1 = mergeSort(head1);
        head2 = mergeSort(head2);

        return mergeSortedLists(head1,head2);
    }
public:
    ListNode* sortList(ListNode* head) {
        if(head == nullptr) return head;
        return mergeSort(head);
    }
};