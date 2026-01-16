// Problem : Reverse Nodes in k-Group (LC - 25)

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
    
    void reverseGroup(ListNode* head){

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
    }
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        
        ListNode* itr = head;
        ListNode* prevGrpEnd = nullptr;

        while(itr != nullptr){
            // identify group
            ListNode* grpStart = itr;
            ListNode* grpEnd = itr;
            int grpCount = 0;

            while(itr != nullptr && grpCount < k){
                grpEnd = itr;
                grpCount++;
                itr = itr->next;
            }

            if(grpCount < k) break;

            // separate the group
            grpEnd->next = nullptr;
            if(prevGrpEnd != nullptr) prevGrpEnd->next = nullptr;

            // reverse the group
            reverseGroup(grpStart);

            // join the grp
            grpStart->next = itr;
            if(prevGrpEnd != nullptr) prevGrpEnd->next = grpEnd;
            else head = grpEnd; // update head for first group reverse

            prevGrpEnd = grpStart; // update previous group end
        }

        return head;
    }
};