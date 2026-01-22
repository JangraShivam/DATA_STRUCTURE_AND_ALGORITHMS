# Problem : Find the Minimum and Maximum Number of Nodes Between Critical Points (LC - 2058)

from typing import Optional, List

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def isCritical(self,prevVal: int, currVal: int, nextVal: int) -> bool:
        return ((prevVal > currVal) and (nextVal > currVal)) or ((prevVal < currVal) and (nextVal < currVal))

    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        # check if list is empty or single node
        if head == None or head.next == None: return [-1,-1]

        # intialize a vector to store critical node position (0 based)
        criticalNodePos = []

        # intialize a iterator to traverse between first and last node
        # because they cant be critical node
        itr = head.next
        prevItr = head
        position = 1
        while itr.next != None :
            # check if it is crictical or not
            if self.isCritical(prevItr.val, itr.val, itr.next.val) :
                criticalNodePos.append(position)
            
            prevItr = itr
            itr = itr.next
            position+=1

        ans = [-1,-1]
        if len(criticalNodePos) <= 1 : return ans

        # maximum dist = back - front
        ans[1] = criticalNodePos[-1] - criticalNodePos[0]
        minDist = ans[1]
        # min dist
        for i in range(1, len(criticalNodePos)):
            minDist = min(minDist, criticalNodePos[i] - criticalNodePos[i-1])

        ans[0] = minDist

        return ans