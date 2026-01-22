# Problem : Rotate List (LC - 61)

from typing import Optional

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # if list is empty or single return
        if head == None or head.next == None: return head

        # get Length of list and end node
        len = 0
        tail = head

        while tail.next != None :
            len+=1
            tail = tail.next
        len+=1

        #rotaing logic
        effectiveRotate = k%len
        if effectiveRotate == 0: return head

        tail.next = head # join tail to head

        # disattach the list from effectiveRotate node from end
        fromStart = len - effectiveRotate
        nodeNo = 1

        while nodeNo < fromStart:
            head = head.next
            nodeNo+=1

        newHead = head.next
        head.next = None

        return newHead
