// Problem : Copy List with Random Pointer (LC - 138)

#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Node{
public:
    int val;
    Node* next;
    Node* random;

    Node(int val){
        this->val = val;
        this->next = nullptr;
        this->random = nullptr;
    }
};

class Solution {
public:
    Node* copyRandomList(Node* head) {
        // stores nodes with their index (0 based)
        unordered_map<Node*, int> nodesPosition;
        vector<Node*> track;

        // create a new list with same values
        Node* newHead = nullptr;
        Node* newTail = nullptr;

        int pos = 0;
        Node* itr = head;
        while(itr != nullptr){
            int currNodeValue = itr->val;
            nodesPosition[itr] = pos++;
            itr = itr->next;

            // create a new Node
            Node* newNode = new Node(currNodeValue);

            if(newHead == nullptr){
                newHead = newNode;
                newTail = newNode;
            }
            else{
                newTail->next = newNode;
                newTail = newNode;
            }

            track.push_back(newNode);
        }


        itr = head;
        Node* newItr = newHead;
        while(itr != nullptr){
            if(itr->random != nullptr ){
                int randomIndex = nodesPosition[itr->random];
                newItr->random = track[randomIndex];
            }

            itr = itr->next;
            newItr = newItr->next;
        }

        return newHead;

    }
};