/*
Problem : Partition Equal Subset Sum (LeetCode - 416)
*/

public class Main{

    public static boolean canPartitionHelper(int[] nums,int targetSum, int index){
        // Partition found
        if(targetSum == 0) return true;

        // Partition not found
        if(targetSum < 0 || index >= nums.length) return false;

        // Include in current Partition
        boolean include = canPartitionHelper(nums,targetSum - nums[index], index+1);

        // Exclude in current Partition
        boolean exclude = canPartitionHelper(nums,targetSum, index+1);

        return include || exclude;
    }

    public static boolean canPartition(int[] nums) {
        // Get total Sum 
        int totalSum = 0;
        for(int i : nums) totalSum += i;

        // If total Sum is Odd, then partition cant be done
        if((totalSum&1) == 1) return false;

        // Half the totalSum for one partition to target
        int targetSum = totalSum/2;

        // look for a partition with targetSum
        return canPartitionHelper(nums,targetSum,0);
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};

        System.out.println("Can partition : " + canPartition(nums));
    }
}