// Problem : Remove Zero Sum Consecutive Nodes from Linked List (LC - 1171)

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
public:
    ListNode* removeZeroSumSublists(ListNode* head) {
        // map to store prefix sum
        unordered_map<int,ListNode*> prefix;

        ListNode* itr = head;
        int sum = 0;
        while(itr != nullptr){
            sum += itr->val;
            if(sum == 0){
                ListNode* seqStart = head;
                ListNode* seqEnd = itr;
                itr = itr->next;
                head = itr;

                prefix.clear();
                seqEnd->next = nullptr;
                
            }
            else if(prefix.find(sum) != prefix.end()){
                ListNode* seqStart = prefix[sum]->next;
                ListNode* seqEnd = itr;
                itr = itr->next;

                // removing sequence
                prefix[sum]->next = itr;
                seqEnd->next = nullptr;

                // sanitize map
                while(seqStart != seqEnd){
                    sum = sum + seqStart->val;
                    ListNode* temp = seqStart;
                    seqStart = seqStart->next;
                    temp->next = nullptr;
                    delete temp;
                    prefix.erase(sum);
                }
                sum += seqStart->val;
                seqStart->next = nullptr;
                delete seqStart;

            }
            else{
                prefix[sum] = itr;
                itr = itr->next;
            }
            
        }

        return head;
    }
};