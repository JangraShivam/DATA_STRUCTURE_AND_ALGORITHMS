// Problem : Remove Duplicates from Sorted List (LC - 83)

class ListNode{
    public int val;
    public ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // check if list is empty or single node in list
        if(head == null || head.next == null) return head;

        // Intialize two iterators
        ListNode prevNode = head;
        ListNode currentNode = head.next;

        // Iterate on list
        while(currentNode != null){
            // check if currentnode val == prevNode val if true delete currentNode
            if(currentNode.val == prevNode.val){
                prevNode.next = currentNode.next;
                currentNode.next = null;
                currentNode = prevNode.next;
            }
            else{
                prevNode = currentNode;
                currentNode = prevNode.next;
            }
        }

        return head;
    }
}

public class Main {

}
