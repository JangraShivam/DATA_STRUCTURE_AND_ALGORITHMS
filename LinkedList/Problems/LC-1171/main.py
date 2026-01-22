# Problem : Remove Zero Sum Consecutive Nodes from Linked List (LC - 1171)

from typing import Optional

class ListNode:
    def __init__(self, val: int) -> None:
        self.val = val
        self.next = None


class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # map to store prefix sum
        prefix = dict()

        itr = head
        sum = 0
        while itr != None:
            sum += itr.val

            if sum == 0 :
                seqEnd = itr
                itr = itr.next
                head = itr

                prefix.clear()
                seqEnd.next = None
                
            elif sum in prefix.keys() :
                seqStart = prefix[sum].next
                seqEnd = itr
                itr = itr.next

                # removing sequence
                prefix[sum].next = itr
                seqEnd.next = None

                # sanitize map
                while seqStart != seqEnd:
                    sum = sum + seqStart.val
                    temp = seqStart
                    seqStart = seqStart.next
                    temp.next = None
                    del temp
                    del prefix[sum]
    
                sum += seqStart.val
                seqStart.next = None
                del seqStart
            else:
                prefix[sum] = itr
                itr = itr.next

        return head