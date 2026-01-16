# Problem : Reverse Nodes in k-Group (LC - 25)

from typing import Optional
class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


class Solution:
    def reverseGroup(self,head: Optional[ListNode]) -> None:

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
        

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        itr = head
        prevGrpEnd = None

        while itr != None :
            # identify group
            grpStart = itr
            grpEnd = itr
            grpCount = 0

            while itr != None and grpCount < k :
                grpEnd = itr
                grpCount+=1
                itr = itr.next

            if(grpCount < k) : break

            # separate the group
            grpEnd.next = None
            if prevGrpEnd != None : prevGrpEnd.next = None

            # reverse the group
            self.reverseGroup(grpStart)

            # join the grp
            grpStart.next = itr
            if(prevGrpEnd != None) : prevGrpEnd.next = grpEnd
            else: head = grpEnd # update head for first group reverse

            prevGrpEnd = grpStart # update previous group end

        return head