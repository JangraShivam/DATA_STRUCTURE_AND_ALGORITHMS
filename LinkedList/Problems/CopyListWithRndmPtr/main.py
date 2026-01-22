# Problem : Copy List with Random Pointer (LC - 138)

from typing import Optional

class Node:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None
        self.random = None
    

class Solution:
    def copyRandomList(self, head: Optional[Node]) -> Optional[Node]:
        # stores nodes with their index (0 based)
        nodesPosition = dict()
        track = []

        # create a new list with same values
        newHead = None
        newTail = None

        pos = 0
        itr = head
        while(itr != None) :
            currNodeValue = itr.val
            nodesPosition[itr] = pos
            pos+=1
            itr = itr.next

            # create a new Node
            newNode = Node(currNodeValue)

            if(newHead == None) :
                newHead = newNode
                newTail = newNode
            else :
                newTail.next = newNode
                newTail = newNode

            track.append(newNode)


        itr = head
        newItr = newHead
        while(itr != None) :
            if(itr.random != None):
                randomIndex = nodesPosition[itr.random]
                newItr.random = track[randomIndex]

            itr = itr.next
            newItr = newItr.next

        return newHead