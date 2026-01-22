# Problem : flattening a Linked List (GFG)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.bottom = None

class Solution:
    def merge(self, list1, list2) :
        # base case
        if(list1 == None): return list2
        if(list2 == None): return list1

        if(list1.data <= list2.data) :
            list1.bottom = self.merge(list1.bottom,list2)
            return list1
        else:
            list2.bottom = self.merge(list1,list2.bottom)
            return list2
        
    def flatten(self, root):
        if(root == None): return root

        return self.merge(root,self.flatten(root.next))