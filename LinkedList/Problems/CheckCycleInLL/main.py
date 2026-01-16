# Problem : Linked List Cycle (LC 141)

from typing import Optional

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None

class Solution:
    def checkCycle1(self, head: Optional[ListNode]) -> bool:
        # store nodes address in a map
        present = dict()

        itr = head
        while itr != None:
            # check if this node is already traversed
            if present.get(itr) == True: return True
            # else add in map
            present[itr] = True
            itr = itr.next
        
        return False
    
    def checkCycle2(self, head: Optional[ListNode]) -> bool:
        slowItr = head
        fastItr = head

        while fastItr != None and fastItr.next != None :
            slowItr = slowItr.next
            fastItr = fastItr.next.next

            if fastItr == slowItr: return True

        return False

    def hasCycle(self, head: Optional[ListNode]) -> bool:
        return self.checkCycle1(head)
        # return self.checkCycle2(head)
