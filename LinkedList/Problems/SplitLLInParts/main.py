# Problem : Problem : Split Linked List in Parts (LC - 725)

from typing import Optional, List

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None


class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        # get length of list
        len = 0
        itr = head

        while itr != None :
            len+=1
            itr = itr.next

        # split the list
        minNodes = len//k # each part will get this much nodes
        extraNodes = len%k # will be distributed one by one from staring

        # intialize vector to store list parts head
        parts = []
        for i in range(k): parts.append(None)

        # allocate nodes for each part
        for i in range(k):
            # check if list is empty
            if(head == None): break

            # allocate nodes for current part
            parts[i] = head
            itr = None
            currentPartNodes = minNodes 
            if extraNodes > 0:
                currentPartNodes += 1
                extraNodes -= 1

            # allocate current part Nodes
            while currentPartNodes > 0 :
                itr = head
                currentPartNodes-=1
                head = head.next
            
            # disconnect current part
            itr.next = None

        return parts