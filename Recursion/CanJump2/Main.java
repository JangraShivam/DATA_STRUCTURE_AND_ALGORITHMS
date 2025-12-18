/*
Problem : Jump Game II (Leetcode - 45)
*/

public class Main{

    public static int getMinimumJumps(int[] nums, int index){
        // return 0 jumps as we reach the end
        if(index >= nums.length - 1) return 0;

        // Intialize jumpsNeeded to reach the end 
        int jumpsNeeded = Integer.MAX_VALUE;

        // Iterate for diff values of jumps possible at current index
        // and store the minimum jumps needed to reach the end
        for(int jump = 1; jump <= nums[index]; jump++){
            // get minimum jumps 
            int jumps = getMinimumJumps(nums,index+jump);

            if(jumps != Integer.MAX_VALUE){
                jumpsNeeded = Math.min(jumpsNeeded,1+jumps);
            }
        }

        return jumpsNeeded;
    }

    public static int jump(int[] nums) {
        return getMinimumJumps(nums,0);
    }
    public static void main(String[] args){

        int[] nums = {2,3,1,1,4};
        System.out.println("Min jumps needed : " + jump(nums));

        return;
    }
}