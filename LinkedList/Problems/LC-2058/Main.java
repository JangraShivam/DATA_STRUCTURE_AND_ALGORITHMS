// Problem : Find the Minimum and Maximum Number of Nodes Between Critical Points (LC - 2058)

import java.util.ArrayList;
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
    boolean isCritical(int prevVal, int currVal, int nextVal){
        return ((prevVal > currVal) && (nextVal > currVal)) || ((prevVal < currVal) && (nextVal < currVal));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // check if list is empty or single node
        int ans[] = {-1,-1};
        if(head == null || head.next == null) return ans;

        // intialize a vector to store critical node position (0 based)
        List<Integer> criticalNodePos = new ArrayList<>();

        // intialize a iterator to traverse between first and last node
        // because they cant be critical node
        ListNode itr = head.next;
        ListNode prevItr = head;
        int position = 1;
        while(itr.next != null){
            // check if it is crictical or not
            if(this.isCritical(prevItr.val, itr.val, itr.next.val)){
                criticalNodePos.add(position);
            }
            
            prevItr = itr;
            itr = itr.next;
            position++;
        }

        if(criticalNodePos.size() <= 1) return ans;

        // maximum dist = back - front;
        ans[1] = criticalNodePos.get(criticalNodePos.size()-1) - criticalNodePos.get(0);
        int minDist = ans[1];
        // min dist
        for(int i = 1; i < criticalNodePos.size(); i++){
            minDist = Math.min(minDist, criticalNodePos.get(i) - criticalNodePos.get(i-1));
        }

        ans[0] = minDist;

        return ans;
    }
}