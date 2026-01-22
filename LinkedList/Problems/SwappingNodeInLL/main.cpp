// Problem : Swapping Nodes in a Linked List (LC - 1721)

#include <iostream>
#include <unordered_map>
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
    ListNode* swapNodes2(ListNode* head, int k){
        // check if list is empty or single node
        if(head == nullptr || head->next == nullptr) return head;

        // store nodes in order
        vector<ListNode*> trackNodes = {nullptr};
        ListNode* itr = head;
        int pos = 1; // 1 - indexed
        while(itr != nullptr){
            trackNodes.push_back(itr);
            pos++;
            itr = itr->next;
        }

        // swap nodes
        swap(trackNodes[k], trackNodes[pos-k]);

        // now rearrange the list by traversing the position
        pos--;
        int i = 1;
        while(i < pos){
            trackNodes[i]->next = trackNodes[i+1];
            i++;
        }
        trackNodes[i]->next = nullptr;

        return trackNodes[1];
    }
    ListNode* swapNodes1(ListNode* head, int k) {
        // check if list is empty or single node
        if(head == nullptr || head->next == nullptr) return head;

        // store nodes with their position
        unordered_map<int,ListNode*> trackNodes;
        ListNode* itr = head;
        int pos = 1; // 1 - indexed
        while(itr != nullptr){
            trackNodes[pos] = itr;
            pos++;
            itr = itr->next;
        }

        int totalNodes = --pos;
        int leftNodePos = min(k, totalNodes - k + 1);
        int rightNodePos = max(k, totalNodes - k + 1);
        ListNode* leftNode = trackNodes[leftNodePos];
        ListNode* rightNode = trackNodes[rightNodePos];

        // check if both points to same nodes -> no need to swap
        if(leftNode == rightNode) return head;
        
        // check if list has only two elements 
        if(totalNodes == 2){
            trackNodes[2]->next = trackNodes[1];
            trackNodes[1]->next = nullptr;
            head = trackNodes[2];
            return head;
        }
        
        // check if both nodes are first and last node of list
        if(leftNode == head){
            // detach both of them and attach in right places
            leftNode->next = nullptr;
            trackNodes[rightNodePos-1]->next = leftNode;
            rightNode->next = trackNodes[leftNodePos+1];

            head = rightNode;
            return head;
        }
        
        // check if both nodes are consecutive nodes
        if(leftNodePos + 1 == rightNodePos){
            leftNode->next = rightNode->next;
            rightNode->next = leftNode;
            trackNodes[leftNodePos-1]->next = rightNode;

            return head;
        }
        
        // if both nodes are not consecutive
        leftNode->next = rightNode->next;
        rightNode->next = trackNodes[leftNodePos+1];
        trackNodes[leftNodePos-1]->next = rightNode;
        trackNodes[rightNodePos-1]->next = leftNode;
        
        return head;
    }

    ListNode* swapNodes(ListNode* head, int k) {
        //return swapNodes1(head,k);
        return swapNodes2(head, k);
    }
};