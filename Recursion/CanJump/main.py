"""
Problem : Can Jump (LeetCode - 55)
"""

from typing import List

def canJumpHelper(nums: List[int], index : int) -> bool :
    # Check if we reached the end or last index
    if(index >= len(nums) - 1) :
        return True
    
    # Intialize reachedStatus with false
    reachedStatus = False

    # Iterate for different values possible for jumps at current index for reaching the end
    for jump in range(1, nums[index] + 1):
        reachedStatus = reachedStatus or canJumpHelper(nums,index+jump)

    return reachedStatus


def canJump(nums: List[int]) -> bool :
    return canJumpHelper(nums,0)



nums = [3,2,1,0,4]
print("End Reached ? : ",canJump(nums))
