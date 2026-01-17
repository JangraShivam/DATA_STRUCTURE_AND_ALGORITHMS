# Problem : Add Two Numbers (LC - 2)

from typing import Optional
class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


class Solution:
    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
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

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # reverse both lists
        l1 = self.reverse(l1)
        l2 = self.reverse(l2)

        carry = 0
        sumHead = None
        sumTail = None

        while l1 != None and l2 != None : 
            sum = (l1.val) + (l2.val) + carry

            newNode = ListNode((sum % 10))
            carry = sum//10

            if sumHead == None : 
                sumHead = newNode
                sumTail = newNode
            else :
                sumTail.next = newNode
                sumTail = newNode

            l1 = l1.next
            l2 = l2.next

        while l1 != None : 
            sum = (l1.val) + carry

            newNode = ListNode((sum % 10))
            carry = sum//10

            sumTail.next = newNode
            sumTail = newNode

            l1 = l1.next

        while l2 != None : 
            sum = (l2.val) + carry

            newNode = ListNode((sum % 10))
            carry = sum//10

            sumTail.next = newNode
            sumTail = newNode

            l2 = l2.next

        if carry != 0 : 
            newNode = ListNode(carry)
            sumTail.next = newNode
            sumTail = newNode

        sumHead = self.reverse(sumHead)
        return sumHead