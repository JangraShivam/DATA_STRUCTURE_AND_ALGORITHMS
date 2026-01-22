# Problem : Merge Nodes in Between Zeros (LC - 2181)

from typing import Optional, List

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # simulate the question descp

        modifiedHead = None
        modifiedTail = None
        sum = 0

        itr = head.next
        while itr != None :
            if itr.val == 0 :
                newNode = ListNode(sum)

                if modifiedHead == None :
                    modifiedHead = newNode
                    modifiedTail = newNode
                else :
                    modifiedTail.next = newNode
                    modifiedTail = newNode

                sum = 0

            sum += (itr.val)
            itr = itr.next

        return modifiedHead