# Problem : Linked List Cycle 2(LC 142)

from typing import Optional

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None


class Solution:
    # Method 1
    def detectCycle1(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Intialize a set to store nodes which we have traversed or visited
        vis = set()

        # Traverse List
        while head != None:
            # check if already visited -> starting node of cycle
            if head in vis : return head

            # insert head in vis
            vis.add(head)
            head = head.next

        # no cycle
        return None

    # Method 2
    def detectCycle2(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Intialize two itr
        slowItr = head
        fastItr = head

        # traverse the list with tortoise approach
        while fastItr != None and fastItr.next != None :
            slowItr = slowItr.next
            fastItr = fastItr.next.next

            # cycle present
            if(fastItr == slowItr): break

        # cycle not present
        if(fastItr == None or fastItr.next == None): return None

        # now we know cycle is present
        # so to find starting node in cycle
        slowItr = head # set SlowItr to head

        # traverse the list with tortoise approach again
        """
            How this approach is working?
            lets say list has m (1 to m) nodes outside of cycle part and n(1 to n) nodes in cycle part of list
            now when we first use the tortoise approach and slowItr and fastItr meet at rth node of cycle part
            so slowItr covered = m + r nodes
            and fastItr covered = m + r + kn nodes (k is how many times it traversed the cycle whole k > 0)
            now as fastItr moves twice as slowItr
            2(m+r) = m+r+kn -> m + r = kn -> m = kn - r

            now we put slowItr to head again and fastItr is at rth node of cycle
            if they move with same speed , to reach the starting node of cycle
            slowItr need to cover m nodes, and fastItr need to cover (n-r) remaining nodes of current cycle
            and complete cycles any number of time like (k-1)times
            so m = kn -r
            
        """
        while fastItr != slowItr :
            slowItr = slowItr.next
            fastItr = fastItr.next
        
        # starting node of cycle
        return slowItr

    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.detectCycle1(head)
        # return self.detectCycle2(head)