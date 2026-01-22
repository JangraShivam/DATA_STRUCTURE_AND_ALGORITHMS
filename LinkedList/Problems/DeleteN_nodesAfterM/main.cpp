// Problem : Delete N nodes after M nodes of a linked list (GFG)

#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;

    Node(int data)
    {
        this->data = data;
        this->next = nullptr;
    }
};


class Solution {
  public:
    Node* linkdelete(Node* head, int n, int m) {
        // Intialize a iterator to traverse
        Node* itr = head;

        // traverse on list
        while(itr != nullptr){
            // skip m nodes
            int skip = 0;

            // reach at end of m nodes
            while(skip < m-1){
                // node skipped
                itr = itr->next;
                skip++;
                if(itr == nullptr) return head; // nothing to skip so return
            }

            // delete n nodes
            int deleted = 0;
            while(deleted < n){
                // check if there is node next to delete
                if(itr->next == nullptr) return head;

                Node* delNode = itr->next; // node to be deleted
                itr->next = delNode->next;
                delNode->next = nullptr;
                delete delNode;

                deleted++;
            }

            // move itr
            itr = itr->next;
        }
        
        return head;
    }
};