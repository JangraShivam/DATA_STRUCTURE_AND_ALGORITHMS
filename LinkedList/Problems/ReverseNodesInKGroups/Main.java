// Problem : Reverse Nodes in k-Group (LC - 25)

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public void reverseGroup(ListNode head){

        // Intialize three iterators
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = head.next; 

        // Iterate until current becomes null or on whole list
        while(current != null){
            // reverse logic
            current.next = prev;
            prev = current;
            current = nextNode;
            if(nextNode != null) nextNode = nextNode.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode itr = head;
        ListNode prevGrpEnd = null;

        while(itr != null){
            // identify group
            ListNode grpStart = itr;
            ListNode grpEnd = itr;
            int grpCount = 0;

            while(itr != null && grpCount < k){
                grpEnd = itr;
                grpCount++;
                itr = itr.next;
            }

            if(grpCount < k) break;

            // separate the group
            grpEnd.next = null;
            if(prevGrpEnd != null) prevGrpEnd.next = null;

            // reverse the group
            reverseGroup(grpStart);

            // join the grp
            grpStart.next = itr;
            if(prevGrpEnd != null) prevGrpEnd.next = grpEnd;
            else head = grpEnd; // update head for first group reverse

            prevGrpEnd = grpStart; // update previous group end
        }

        return head;
    }
}