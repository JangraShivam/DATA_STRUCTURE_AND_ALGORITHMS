// Problem : lattening a Linked List (GFG)

#include <iostream>
#include <unordered_set>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* bottom;

    Node(int data)
    {
        this->data = data;
        this->next = nullptr;
        this->bottom = nullptr;
    }
};


class Solution {
    Node* merge(Node* list1, Node* list2){
        // base case
        if(list1 == nullptr) return list2;
        if(list2 == nullptr) return list1;

        if(list1->data <= list2->data){
            list1->bottom = merge(list1->bottom,list2);
            return list1;
        }
        else{
            list2->bottom = merge(list1,list2->bottom);
            return list2;
        }
    }
  public:
    Node *flatten(Node *root) {
        if(root == nullptr) return root;

        return merge(root,flatten(root->next));
        
    }
};