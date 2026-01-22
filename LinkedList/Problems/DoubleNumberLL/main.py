# Problem : Double a Number Represented as a Linked List (LC - 2816)

from typing import Optional

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    # Method 1 recusrsive
    def doubleRecurisively(self, head: Optional[ListNode]) -> int:
        # Base case
        if head == None: return 0

        carry = self.doubleRecurisively(head.next)
        product = (head.val)*2 + carry

        head.val = product%10
        return product//10
    

    def doubleUsingRecursion(self, head: Optional[ListNode]) -> Optional[ListNode]:
        carry = self.doubleRecurisively(head)

        if carry != 0 :
            newNode = ListNode(carry)
            newNode.next = head
            head = newNode

        return head

    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
        currNode = head
        prevNode = None
        nextNode = head.next

        while currNode != None :
            currNode.next = prevNode
            prevNode = currNode
            currNode = nextNode
            if nextNode != None: nextNode = nextNode.next

        return prevNode

    def doubleIteratively(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # reverse the list
        reverseHead = self.reverse(head)

        # Double the list 
        itr = reverseHead
        carry = 0
        while itr != None:
            product = (itr.val)*2 + carry

            itr.val = (product%10)
            carry = product//10

            itr = itr.next

        # reverse the list
        head = self.reverse(reverseHead)
        if carry != 0 :
            itr = ListNode(carry)
            itr.next = head
            head = itr

        return head
    
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.doubleUsingRecursion(head)
        # return self.doubleIteratively(head)