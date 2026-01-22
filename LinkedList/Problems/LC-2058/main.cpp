// Problem : Find the Minimum and Maximum Number of Nodes Between Critical Points (LC - 2058)

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
    bool isCritical(int prevVal, int currVal, int nextVal){
        return ((prevVal > currVal) && (nextVal > currVal)) || ((prevVal < currVal) && (nextVal < currVal));
    }
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        // check if list is empty or single node
        if(head == nullptr || head->next == nullptr) return {-1,-1};

        // intialize a vector to store critical node position (0 based)
        vector<int> criticalNodePos;

        // intialize a iterator to traverse between first and last node
        // because they cant be critical node
        ListNode* itr = head->next;
        ListNode* prevItr = head;
        int position = 1;
        while(itr->next != nullptr){
            // check if it is crictical or not
            if(this->isCritical(prevItr->val, itr->val, itr->next->val)){
                criticalNodePos.push_back(position);
            }
            
            prevItr = itr;
            itr = itr->next;
            position++;
        }

        vector<int> ans = {-1,-1};
        if(criticalNodePos.size() <= 1) return ans;

        // maximum dist = back - front;
        ans[1] = criticalNodePos.back() - criticalNodePos.front();
        int minDist = ans[1];
        // min dist
        for(int i = 1; i < criticalNodePos.size(); i++){
            minDist = min(minDist, criticalNodePos[i] - criticalNodePos[i-1]);
        }

        ans[0] = minDist;

        return ans;

    }
};