# Problem : Delete N nodes after M nodes of a linked list (GFG)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    def linkdelete(self, head, n, m):
        # Intialize a iterator to traverse
        itr = head

        # traverse on list
        while itr != None:
            # skip m nodes
            skip = 0

            # reach at end of m nodes
            while skip < m-1 :
                # node skipped
                itr = itr.next
                skip+=1
                if itr == None: return # nothing to skip so return

            # delete n nodes
            deleted = 0
            while deleted < n :
                # check if there is node next to delete
                if itr.next == None: return

                delNode = itr.next # node to be deleted
                itr.next = delNode.next
                delNode.next = None
                del delNode

                deleted+=1

            # move itr
            itr = itr.next
        
        return