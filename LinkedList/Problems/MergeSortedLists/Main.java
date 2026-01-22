// Problem : Merge Two Sorted Lists (LC - 21)

class ListNode{
    public int val;
    public ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    ListNode mergeHead;
    ListNode mergeTail;

    ListNode insertNodeToMergeList(ListNode list){
        // detach node from list
        ListNode node =  list;
        list = list.next;
        node.next = null;
    
        // add to merged one
        if(mergeHead == null){
            mergeHead = node;
            mergeTail = node;
        }
        else{
            mergeTail.next = node;
            mergeTail = node;
        }
        return list;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // check if one or both the lists are empty
        if(list1 == null && list2 == null) return null;
        if(list1 == null && list2 != null) return list2;
        if(list1 != null && list2 == null) return list1;

        // Intialize merged list head and tail
        this.mergeHead = null;
        this.mergeTail = null;

        // traverse on both lists together
        while(list1 != null && list2 != null){
            // find the which list node is lesser and add into merged list
            if(list1.val < list2.val) list1 = this.insertNodeToMergeList(list1);
            else list2 = this.insertNodeToMergeList(list2);
        }

        // check if there are some nodes remaining in one of list
        if(list1 != null) mergeTail.next = list1;
        if(list2 != null) mergeTail.next = list2;

        return mergeHead;
    }
}