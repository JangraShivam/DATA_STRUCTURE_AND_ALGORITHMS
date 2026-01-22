# Problem : Swapping Nodes in a Linked List (LC - 1721)

from typing import Optional

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def swapNodes2(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # check if list is empty or single node
        if(head == None or head.next == None): return head

        # store nodes in order
        trackNodes = [None]
        itr = head
        pos = 1 # 1 - indexed
        while(itr != None) :
            trackNodes.append(itr)
            pos+=1
            itr = itr.next

        # swap nodes
        trackNodes[k], trackNodes[pos-k] = trackNodes[pos-k], trackNodes[k]

        # now rearrange the list by traversing the position
        pos-=1
        i = 1
        while(i < pos) :
            trackNodes[i].next = trackNodes[i+1]
            i+=1
        trackNodes[i].next = None

        return trackNodes[1]
    
    def swapNodes1(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        # check if list is empty or single node
        if(head == None or head.next == None): return head

        # store nodes with their position
        trackNodes = dict()
        itr = head
        pos = 1 # 1 - indexed
        while(itr != None) :
            trackNodes[pos] = itr
            pos+=1
            itr = itr.next

        pos-=1
        totalNodes = pos
        leftNodePos = min(k, totalNodes - k + 1)
        rightNodePos = max(k, totalNodes - k + 1)
        leftNode = trackNodes[leftNodePos]
        rightNode = trackNodes[rightNodePos]

        # check if both points to same nodes . no need to swap
        if(leftNode == rightNode): return head
        
        # check if list has only two elements 
        if(totalNodes == 2) :
            trackNodes[2].next = trackNodes[1]
            trackNodes[1].next = None
            head = trackNodes[2]
            return head
        
        
        # check if both nodes are first and last node of list
        if(leftNode == head) :
            # detach both of them and attach in right places
            leftNode.next = None
            trackNodes[rightNodePos-1].next = leftNode
            rightNode.next = trackNodes[leftNodePos+1]

            head = rightNode
            return head
        
        
        # check if both nodes are consecutive nodes
        if(leftNodePos + 1 == rightNodePos):
            leftNode.next = rightNode.next
            rightNode.next = leftNode
            trackNodes[leftNodePos-1].next = rightNode

            return head
        
        
        # if both nodes are not consecutive
        leftNode.next = rightNode.next
        rightNode.next = trackNodes[leftNodePos+1]
        trackNodes[leftNodePos-1].next = rightNode
        trackNodes[rightNodePos-1].next = leftNode
        
        return head

    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        return self.swapNodes1(head,k)
        #return self.swapNodes2(head,k)