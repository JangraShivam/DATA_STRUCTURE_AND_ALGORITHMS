// Problem : Palindrome Linked List (LC 234)

# include <iostream>
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

    ListNode* reverseIterative(ListNode* head){
        // check if list is empty or single node (yes -> no need to reverse)
        if(head == nullptr || head->next == nullptr) return head;

        // Intialize three iterators
        ListNode* prev = nullptr;
        ListNode* current = head;
        ListNode* nextNode = head->next; 

        // Iterate until current becomes null or on whole list
        while(current != nullptr){
            // reverse logic
            current->next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != nullptr) nextNode = nextNode->next;
        }

        // reverse list head
        return prev;
    }
    
    bool isPalindrome(ListNode* head) {
        // edge cases (empty or single element list)
        if(head == nullptr || head->next == nullptr) return true;

        // divide the list in two parts from middle
        // if even no of nodes (e.g. 1->2->3->4) -> (1->2) (3->4)
        // odd nodes (1->2->3->4->5) -> (1->2) (4->5) 3 -> either add in both or ignore
        ListNode* slowItr = head;
        ListNode* fastItr = head;

        while(fastItr->next->next != nullptr && fastItr->next->next->next != nullptr){
            slowItr = slowItr->next;
            fastItr = fastItr->next->next;
        }

        // Intialize two head for two lists
        ListNode* head1 = head;
        ListNode* head2 = nullptr;

        // even no of nodes
        if(fastItr->next->next == nullptr){
            head2 = slowItr->next;
            slowItr->next = nullptr;
        }
        else{
            head2 = slowItr->next;
            slowItr->next = nullptr;
            slowItr = head2;
            head2 = head2->next;
            slowItr->next = nullptr;
        }

        // reverse the second list
        head2 = this->reverseIterative(head2);

        // now compare for palindrome
        while(head1 != nullptr && head2 != nullptr){
            if(head1->val != head2->val) return false;
            head1 = head1->next;
            head2 = head2->next;
        }

        return true;
    }
};