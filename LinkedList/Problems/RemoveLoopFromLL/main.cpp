// Problem : Remove loop in Linked List (GFG)

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
    void removeLoop(Node* head) {
       // Intialize two itr
        Node* slowItr = head;
        Node* fastItr = head;
        Node* fastItrPrev = nullptr;
        // traverse the list with tortoise approach
        while(fastItr != nullptr && fastItr->next != nullptr){
            slowItr = slowItr->next;
            fastItr = fastItr->next;
            fastItrPrev = fastItr;
            fastItr = fastItr->next;
            
            // cycle present
            if(fastItr == slowItr) break;
        }

        // cycle not present
        if(fastItr == nullptr || fastItr->next == nullptr) return ;

        // now we know cycle is present
        // so to find starting node in cycle
        slowItr = head; // set SlowItr to head

        // traverse the list with tortoise approach again
        /*
            How this approach is working?
            lets say list has m (1 to m) nodes outside of cycle part and n(1 to n) nodes in cycle part of list
            now when we first use the tortoise approach and slowItr and fastItr meet at rth node of cycle part
            so slowItr covered = m + r nodes
            and fastItr covered = m + r + kn nodes (k is how many times it traversed the cycle whole k > 0)
            now as fastItr moves twice as slowItr
            2(m+r) = m+r+kn -> m + r = kn -> m = kn - r

            now we put slowItr to head again and fastItr is at rth node of cycle
            if they move with same speed , to reach the starting node of cycle
            slowItr need to cover m nodes, and fastItr need to cover (n-r) remaining nodes of current cycle
            and complete cycles any number of time like (k-1)times
            so m = kn -r
            
        */
        
        
        // starting node of cycle
        while(fastItr != slowItr){
            slowItr = slowItr->next;
            fastItrPrev = fastItr;
            fastItr = fastItr->next;
        }
        
        fastItrPrev->next = nullptr;
        
    }
};