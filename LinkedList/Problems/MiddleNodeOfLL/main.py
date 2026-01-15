# Middle Node of Linked list (LC - 876)

from typing import Optional
class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None

# Method 1
def getMiddleNode1(head: Optional[ListNode]) -> Optional[ListNode]:
    # calculate total length
    itr = head
    length = 0
    while itr != None :
        length+=1
        itr = itr.next

    middleNodePosition = length//2 # position start from 0
    middleNode = head
    while middleNode != None and middleNodePosition :
        middleNode = middleNode.next
        middleNodePosition-=1

    return middleNode


# Method 2
def getMiddleNode2(head: Optional[ListNode]) -> Optional[ListNode]:
    # intialize two iterators
    slowItr = head
    fastItr = head

    # fastItr traverse twice the speed of slowItr
    while fastItr != None and fastItr.next != None :
        slowItr = slowItr.next
        fastItr = fastItr.next.next

    return slowItr


def middleNode(head: Optional[ListNode]) -> Optional[ListNode]:
    return getMiddleNode1(head)
    # return getMiddleNode2(head)