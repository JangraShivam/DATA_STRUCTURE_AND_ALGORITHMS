// Problem : Linked List Cycle 2(LC 142)

#include <iostream>
#include <unordered_set>
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
    // Method 1
    ListNode* detectCycle1(ListNode* head){
        // Intialize a set to store nodes which we have traversed or visited
        unordered_set<ListNode*> vis;

        // Traverse List
        while(head != nullptr){
            // check if already visited -> starting node of cycle
            if(vis.find(head) != vis.end()) return head;

            // insert head in vis
            vis.insert(head);
            head = head->next;
        }

        // no cycle
        return nullptr;
    }

    // Method 2
    ListNode* detectCycle2(ListNode* head){
        // Intialize two itr
        ListNode* slowItr = head;
        ListNode* fastItr = head;

        // traverse the list with tortoise approach
        while(fastItr != nullptr && fastItr->next != nullptr){
            slowItr = slowItr->next;
            fastItr = fastItr->next->next;

            // cycle present
            if(fastItr == slowItr) break;
        }

        // cycle not present
        if(fastItr == nullptr || fastItr->next == nullptr) return nullptr;

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
        while(fastItr != slowItr){
            slowItr = slowItr->next;
            fastItr = fastItr->next;
        }
        // starting node of cycle
        return slowItr;
    }
public:
    ListNode *detectCycle(ListNode *head) {
        // return detectCycle1(head);
        return detectCycle2(head);
    }
};