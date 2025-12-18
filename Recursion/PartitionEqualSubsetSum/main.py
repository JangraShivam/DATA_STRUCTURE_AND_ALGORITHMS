"""
Problem : Partition Equal Subset Sum (LeetCode - 416)
"""


def canPartitionHelper(nums,targetSum, index) :
    # Partition found
    if(targetSum == 0) : return True

    # Partition not found
    if(targetSum < 0 or index >= len(nums)) : return False

    # Include in current Partition
    include = canPartitionHelper(nums,targetSum - nums[index], index+1)

    # Exclude in current Partition
    exclude = canPartitionHelper(nums,targetSum, index+1)

    return include or exclude

def canPartition(nums) :
    # Get total Sum 
    totalSum = sum(nums)

    # If total Sum is Odd, then partition cant be done
    if(totalSum&1) : return False

    # Half the totalSum for one partition to target
    targetSum = totalSum//2

    # look for a partition with targetSum
    return canPartitionHelper(nums,targetSum,0)


nums = [1,5,11,5]
print("Can Partition : ",canPartition(nums))
