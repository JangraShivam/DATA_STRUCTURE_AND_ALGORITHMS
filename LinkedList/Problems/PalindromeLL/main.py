# Problem : Palindrome Linked List (LC 234)

from typing import Optional

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None

class Solution:

    def reverseIterative(self,head: Optional[ListNode]) -> Optional[ListNode]:
        # check if list is empty or single node (yes -> no need to reverse)
        if head == None or head.next == None: return head

        # Intialize three iterators
        prev = None
        current = head
        nextNode = head.next

        # Iterate until current becomes null or on whole list
        while current != None :
            # reverse logic
            current.next = prev
            prev = current
            current = nextNode
            if(nextNode != None) : nextNode = nextNode.next
        
        # reverse list head
        return prev
    
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # edge cases (empty or single element list)
        if head == None or head.next == None: return True

        # divide the list in two parts from middle
        # if even no of nodes (e.g. 1->2->3->4) -> (1->2) (3->4)
        # odd nodes (1->2->3->4->5) -> (1->2) (4->5) 3 -> either add in both or ignore
        slowItr = head
        fastItr = head

        while fastItr.next.next != None and fastItr.next.next.next != None :
            slowItr = slowItr.next
            fastItr = fastItr.next.next

        # Intialize two head for two lists
        head1 = head
        head2 = None

        # even no of nodes
        if fastItr.next.next == None:
            head2 = slowItr.next
            slowItr.next = None
        else :
            head2 = slowItr.next
            slowItr.next = None
            slowItr = head2
            head2 = head2.next
            slowItr.next = None

        # reverse the second list
        head2 = self.reverseIterative(head2)

        # now compare for palindrome
        while head1 != None and head2 != None:
            if head1.val != head2.val: return False
            head1 = head1.next
            head2 = head2.next

        return True
