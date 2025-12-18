"""
Problem : Jump Game II (Leetcode - 45)
"""

from typing import List
import sys

def getMinimumJumps(nums: List[int], index: int) -> int:
    # return 0 jumps as we reach the end
    if(index >= len(nums) - 1) :
        return 0

    # Intialize jumpsNeeded to reach the end 
    jumpsNeeded = sys.maxsize

    # Iterate for diff values of jumps possible at current index
    # and store the minimum jumps needed to reach the end
    for jump in range(1,nums[index] + 1) :
        # get minimum jumps 
        jumps = getMinimumJumps(nums,index+jump)

        if(jumps != sys.maxsize) :
            jumpsNeeded = min(jumpsNeeded,1+jumps)
        
    return jumpsNeeded


def jump(nums: List[int]) -> int:
    return getMinimumJumps(nums,0)

nums = [2,3,1,1,4]
print("Min jumps Needed : ",jump(nums))