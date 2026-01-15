
from typing import Optional

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None



# Recursive Method
def reverseRecursive(current : Optional[ListNode], prev: Optional[ListNode], nextNode: Optional[ListNode]) -> Optional[ListNode]:
    # Base case
    if current == None: return prev

    # reverse logic
    current.next = prev
    prev = current
    current = nextNode
    if(nextNode != None) : nextNode = nextNode.next

    return reverseRecursive(current,prev,nextNode)


# Iterative method
def reverseIterative(head: Optional[ListNode]) -> Optional[ListNode]:
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


def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    # if list is empty
    if head == None : return None

    # return reverseIterative(head);
    return reverseRecursive(head,None,head.next)