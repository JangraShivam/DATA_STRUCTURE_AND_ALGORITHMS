# Problem : Remove Duplicates from Sorted List (LC - 83)

from typing import Optional

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # check if list is empty or single node in list
        if head == None or head.next == None : return head

        # Intialize two iterators
        prevNode = head
        currentNode = head.next

        # Iterate on list
        while currentNode != None :
            # check if currentnode val == prevNode val if true delete currentNode
            if currentNode.val == prevNode.val :
                prevNode.next = currentNode.next
                currentNode.next = None
                del currentNode
                currentNode = prevNode.next
            else:
                prevNode = currentNode
                currentNode = prevNode.next

        return head