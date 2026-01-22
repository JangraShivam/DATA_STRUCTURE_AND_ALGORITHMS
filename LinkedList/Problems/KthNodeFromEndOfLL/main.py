# Problem : Kth from End of Linked List (GFG)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    k = None
    # Method 1 -> recursive
    def getKthRecursively(self,head) -> int:
        # Base case 
        if head == None: return -1
        ans = self.getKthRecursively(head.next)

        # update k
        self.k-=1

        if self.k == 0 :
            return head.data
        else :
            return ans
        

    # Method 2 iterative
    def getKthIteratively(self,head) -> int:
        """
            one approach can be to reverse the list and return kth node from start
        """

        # get Length of list
        len = 0
        itr = head

        while itr != None :
            len+=1
            itr = itr.next

        # check if k is greater than list length
        if self.k > len: return -1

        # kth node from end = (len - k + 1) node from the start
        self.k = len - self.k + 1

        itr = head
        while itr != None:
            self.k-=1
            if self.k == 0: return itr.data
            itr = itr.next

        return -1

    def getKthFromLast(self, head, k):
        self.k = k
        return self.getKthIteratively(head)
        # return self.getKthRecursively(head)