# Problem : Merge Two Sorted Lists (LC - 21)

from typing import Optional, List

class ListNode:
    def __init__(self, val: int):
        self.val = val
        self.next = None


class Solution:
    mergeHead = None
    mergeTail = None

    def insertNodeToMergeList(self, list: Optional[ListNode]) -> Optional[ListNode] :
        # detach node from list
        node =  list
        list = list.next
        node.next = None
    
        # add to merged one
        if self.mergeHead == None :
            self.mergeHead = node
            self.mergeTail = node
        else :
            self.mergeTail.next = node
            self.mergeTail = node
        
        return list

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        # check if one or both the lists are empty
        if list1 == None and list2 == None : return None
        if list1 == None and list2 != None : return list2
        if list1 != None and list2 == None : return list1

        # Intialize merged list head and tail
        self.mergeHead = None
        self.mergeTail = None

        # traverse on both lists together
        while list1 != None and list2 != None :
            # find the which list node is lesser and add into merged list
            if(list1.val < list2.val): list1 = self.insertNodeToMergeList(list1)
            else: list2 = self.insertNodeToMergeList(list2)
        
        # check if there are some nodes remaining in one of list
        if list1 != None : self.mergeTail.next = list1
        if list2 != None : self.mergeTail.next = list2

        return self.mergeHead