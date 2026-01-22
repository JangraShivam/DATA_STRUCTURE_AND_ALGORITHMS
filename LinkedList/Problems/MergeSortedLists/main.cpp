// Problem : Merge Two Sorted Lists (LC - 21)

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
    void insertNodeToMergeList(ListNode* &mergeHead, ListNode* &mergeTail, ListNode* &list){
        // detach node from list
        ListNode* node =  list;
        list = list->next;
        node->next = nullptr;
    
        // add to merged one
        if(mergeHead == nullptr){
            mergeHead = node;
            mergeTail = node;
        }
        else{
            mergeTail->next = node;
            mergeTail = node;
        }

    }
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // check if one or both the lists are empty
        if(list1 == nullptr && list2 == nullptr) return nullptr;
        if(list1 == nullptr && list2 != nullptr) return list2;
        if(list1 != nullptr && list2 == nullptr) return list1;

        // Intialize merged list head and tail
        ListNode* mergeHead = nullptr;
        ListNode* mergeTail = nullptr;

        // traverse on both lists together
        while(list1 != nullptr && list2 != nullptr){
            // find the which list node is lesser and add into merged list
            if(list1->val < list2->val) insertNodeToMergeList(mergeHead, mergeTail, list1);
            else insertNodeToMergeList(mergeHead,mergeTail, list2);
        }

        // check if there are some nodes remaining in one of list
        if(list1 != nullptr) mergeTail->next = list1;
        if(list2 != nullptr) mergeTail->next = list2;

        return mergeHead;
    }
};