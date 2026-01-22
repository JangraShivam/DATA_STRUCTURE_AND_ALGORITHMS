# Problem : Intersection of Two Linked Lists (GFG)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    def findIntersection(self, head1, head2):
        # store list head2 nodes value in a set
        st = set()
        while head2 != None :
            st.add(head2.data)
            head2 = head2.next

        # traverse the list head1 and eliminate node which are not in set st
        itr = head1
        prevItr = None
        while itr != None:
            # check if itr node value is not in set -> delete it
            if itr.data not in st :
                # if itr is head node
                if itr == head1 :
                    prevItr = itr
                    itr = itr.next
                    prevItr.next = None
                    del prevItr
                    prevItr = None

                    head1 = itr # update head
                else:
                    prevItr.next = itr.next
                    itr.next = None
                    del itr
                    itr = prevItr.next
            else :
                prevItr = itr
                itr = itr.next
        

        return head1