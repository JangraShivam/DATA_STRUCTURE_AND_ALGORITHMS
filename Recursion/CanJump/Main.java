/*
Problem : Can Jump (LeetCode - 55)
*/

public class Main{
    
    public static boolean canJumpHelper(int[] nums, int index){
        // Check if we reached the end or last index
        if(index >= nums.length - 1) return true;
        
        // Intialize reachedStatus with false
        boolean reachedStatus = false;

        // Iterate for different values possible for jumps at current index for reaching the end
        for(int jump = 1; jump <= nums[index]; jump++){
            reachedStatus = reachedStatus || canJumpHelper(nums,index+jump);
        }

        return reachedStatus;
    }

    public static boolean canJump(int[] nums) {
        return canJumpHelper(nums,0);
    }


    public static void main(String[] args){

        int[] nums = {2,3,1,1,4};

        System.out.println("End reached ? : " + canJump(nums));
        return;
    }
}