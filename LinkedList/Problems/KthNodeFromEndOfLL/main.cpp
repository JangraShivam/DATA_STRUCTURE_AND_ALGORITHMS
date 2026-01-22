// Problem : Kth from End of Linked List (GFG)

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
    // Method 1 -> recursive
    int getKthRecursively(Node* head, int& k){
        // Base case 
        if(head == nullptr) return -1;
        int ans = getKthRecursively(head->next, k);

        // update k
        k--;

        if(k == 0){
            return head->data;
        }
        else{
            return ans;
        }
    }

    // Method 2 iterative
    int getKthIteratively(Node* head, int k){
        /*
            one approach can be to reverse the list and return kth node from start
        */

        // get Length of list
        int len = 0;
        Node* itr = head;

        while(itr != nullptr){
            len++;
            itr = itr->next;
        }

        // check if k is greater than list length
        if(k > len) return -1;

        // kth node from end = (len - k + 1) node from the start
        k = len - k + 1;

        itr = head;
        while(itr != nullptr){
            k--;
            if(k == 0) return itr->data;
            itr = itr->next;
        }

        return -1;
    }
  public:
    int getKthFromLast(Node* head, int k) {
        return getKthRecursively(head,k);
        // return getKthIteratively(head,k);
    }
};