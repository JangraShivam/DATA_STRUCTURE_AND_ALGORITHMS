// Problem : Swapping Nodes in a Linked List (LC - 1721)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

class Solution {
    ListNode swapNodes2(ListNode head, int k){
        // check if list is empty or single node
        if(head == null || head.next == null) return head;

        // store nodes in order
        List<ListNode> trackNodes = new ArrayList<>();
        trackNodes.add(null);

        ListNode itr = head;
        int pos = 1; // 1 - indexed
        while(itr != null){
            trackNodes.add(itr);
            pos++;
            itr = itr.next;
        }

        // swap nodes
        ListNode leftNode = trackNodes.get(k);
        ListNode rightNode = trackNodes.get(pos-k);
        trackNodes.set(k, rightNode);
        trackNodes.set(pos-k, leftNode);


        // now rearrange the list by traversing the position
        pos--;
        int i = 1;
        while(i < pos){
            trackNodes.get(i).next = trackNodes.get(i+1);
            i++;
        }
        trackNodes.get(i).next = null;

        return trackNodes.get(1);
    }
    ListNode swapNodes1(ListNode head, int k) {
        // check if list is empty or single node
        if(head == null || head.next == null) return head;

        // store nodes with their position
        HashMap<Integer,ListNode> trackNodes = new HashMap<>();
        ListNode itr = head;
        int pos = 1; // 1 - indexed
        while(itr != null){
            trackNodes.put(pos,itr);
            pos++;
            itr = itr.next;
        }

        int totalNodes = --pos;
        int leftNodePos = Math.min(k, totalNodes - k + 1);
        int rightNodePos = Math.max(k, totalNodes - k + 1);
        ListNode leftNode = trackNodes.get(leftNodePos);
        ListNode rightNode = trackNodes.get(rightNodePos);

        // check if both points to same nodes . no need to swap
        if(leftNode == rightNode) return head;
        
        // check if list has only two elements 
        if(totalNodes == 2){
            trackNodes.get(2).next = trackNodes.get(1);
            trackNodes.get(1).next = null;
            head = trackNodes.get(2);
            return head;
        }
        
        // check if both nodes are first and last node of list
        if(leftNode == head){
            // detach both of them and attach in right places
            leftNode.next = null;
            trackNodes.get(rightNodePos-1).next = leftNode;
            rightNode.next = trackNodes.get(leftNodePos+1);

            head = rightNode;
            return head;
        }
        
        // check if both nodes are consecutive nodes
        if(leftNodePos + 1 == rightNodePos){
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            trackNodes.get(leftNodePos-1).next = rightNode;

            return head;
        }
        
        // if both nodes are not consecutive
        leftNode.next = rightNode.next;
        rightNode.next = trackNodes.get(leftNodePos+1);
        trackNodes.get(leftNodePos-1).next = rightNode;
        trackNodes.get(rightNodePos-1).next = leftNode;
        
        return head;
    }

    public ListNode swapNodes(ListNode head, int k) {
        return swapNodes1(head, k);
        //return swapNodes2(head, k);
    }
}