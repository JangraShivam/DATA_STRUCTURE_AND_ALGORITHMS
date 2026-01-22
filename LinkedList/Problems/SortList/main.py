# Problem : Sort List (LC - 148)

from typing import Optional

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def mergeSortedLists(self, head1: ListNode, head2: ListNode) -> ListNode:
        mergeHead = None
        mergeTail = None

        while(head1 != None and head2 != None) :
            if(head1.val <= head2.val):
                node = head1
                head1 = head1.next
                node.next = None

                if(mergeHead == None):
                    mergeHead = node
                    mergeTail = node
                else:
                    mergeTail.next = node
                    mergeTail = node
            else:
                node = head2
                head2 = head2.next
                node.next = None

                if(mergeHead == None):
                    mergeHead = node
                    mergeTail = node
                else:
                    mergeTail.next = node
                    mergeTail = node

        while(head1 != None):
            node = head1
            head1 = head1.next
            node.next = None

            mergeTail.next = node
            mergeTail = node

        while(head2 != None):
            node = head2
            head2 = head2.next
            node.next = None

            mergeTail.next = node
            mergeTail = node

        return mergeHead
    
    def getMiddleNode(self, head: ListNode) -> ListNode:
        slow = head
        fast = head

        while(fast.next.next != None and fast.next.next.next != None) :
            slow = slow.next
            fast = fast.next.next

        return slow
    
    def mergeSort(self, head: ListNode) -> ListNode:
        if(head.next == None): return head

        midNode = self.getMiddleNode(head)
        head1 = head
        head2 = midNode.next
        midNode.next = None

        head1 = self.mergeSort(head1)
        head2 = self.mergeSort(head2)

        return self.mergeSortedLists(head1,head2)
    
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None : return head
        return self.mergeSort(head)