# Problem : Sort a linked list of 0s, 1s and 2s (GFG)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    def segregate(self, head):
        # Intialize iterators for 0 1 2 list separately
        zeroHead = None
        zeroTail = None

        oneHead = None
        oneTail = None

        twoHead = None
        twoTail = None

        # Iterate over whole list and separate 0 1 2 to their own list
        while head != None :
            # separate current node from main list
            currentNode = head
            head = head.next
            currentNode.next = None

            # add currentNode to right list
            if(currentNode.data == 0) :
                if zeroHead == None:
                    zeroHead = currentNode
                    zeroTail = currentNode
                else:
                    zeroTail.next = currentNode
                    zeroTail = currentNode

            elif currentNode.data == 1 : 
                if oneHead == None:
                    oneHead = currentNode
                    oneTail = currentNode
                else:
                    oneTail.next = currentNode
                    oneTail = currentNode
            else :
                if twoHead == None:
                    twoHead = currentNode
                    twoTail = currentNode
                else:
                    twoTail.next = currentNode
                    twoTail = currentNode
        

        # merge 0 1 2 lists
        newHead = None
        newTail = None

        if zeroHead != None :
            newHead = zeroHead
            newTail = zeroTail

        if oneHead != None: 
            if newHead == None: 
                newHead = oneHead
                newTail = oneTail
            else :
                newTail.next = oneHead
                newTail = oneTail


        if twoHead != None: 
            if newHead == None: 
                newHead = twoHead
                newTail = twoTail
            else :
                newTail.next = twoHead
                newTail = twoTail


        return newHead