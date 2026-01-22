# Problem : Odd Even Linked List (LC - 328)

from typing import Optional, List

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # if list is empty or single node
        if head == None or head.next == None : return head

        # intialize two list odd and even
        oddHead = head
        oddTail =  head
        head = head.next
        oddHead.next = None

        evenHead = head
        evenTail = head
        head = head.next
        evenHead.next = None

        while head != None :
            # add to odd list
            oddTail.next = head
            oddTail = head
            head = head.next
            oddTail.next = None

            if head == None: break

            # add to even list
            evenTail.next = head
            evenTail = head
            head = head.next
            evenTail.next = None

        # join odd and even
        oddTail.next = evenHead

        return oddHead