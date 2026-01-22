// Problem : Intersection of Two Linked Lists (GFG)

#include <iostream>
#include <unordered_set>
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
    Node* findIntersection(Node* head1, Node* head2) {
        // store list head2 nodes value in a set
        unordered_set<int> st;
        while(head2 != nullptr){
            st.insert(head2->data);
            head2 = head2->next;
        }

        // traverse the list head1 and eliminate node which are not in set st
        Node* itr = head1;
        Node* prevItr = nullptr;
        while(itr != nullptr){
            // check if itr node value is not in set -> delete it
            if(st.find(itr->data) == st.end()){
                // if itr is head node
                if(itr == head1){
                    prevItr = itr;
                    itr = itr->next;
                    prevItr->next = nullptr;
                    delete prevItr;
                    prevItr = nullptr;

                    head1 = itr; // update head
                }
                else{
                    prevItr->next = itr->next;
                    itr->next = nullptr;
                    delete itr;
                    itr = prevItr->next;
                }
            }
            else{
                prevItr = itr;
                itr = itr->next;
            }
        }

        return head1;
    }
};