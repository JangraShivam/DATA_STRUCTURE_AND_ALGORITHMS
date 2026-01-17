# Problem : Flatten a Multilevel Doubly Linked List (LC - 430)

from typing import Optional

class Node:
    def __init__(self, val: int):
        self.val = val
        self.next = None
        self.prev = None
        self.child = None

class CurrentNode:
    def __init__(self):
        self.itr = None


class Solution:
    def flattenList(self,node: CurrentNode) -> None:
        # base case
        if node.itr == None: return
        
        # check if currentNode has a child 
        if node.itr.child != None :
            # store nextNode
            nextNode = node.itr.next
            
            # apply flatten logic
            node.itr.next = node.itr.child
            node.itr.child.prev = node.itr
            node.itr.child = None
            node.itr = node.itr.next

            # recursive call for its child to flatten its child
            self.flattenList(node)

            # after recusive call attach currentNode to nextNode
            node.itr.next = nextNode
            if nextNode != None : nextNode.prev = node.itr
    

        # further recursive call for list in same level
        if node.itr.next != None :
            node.itr = node.itr.next
            self.flattenList(node)
        

    def flatten(self, head: Optional[Node]) -> Optional[Node]:
        node = CurrentNode()
        node.itr = head
        self.flattenList(node)
        return head
        