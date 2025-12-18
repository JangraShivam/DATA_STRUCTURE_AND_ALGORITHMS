"""
Problem : Triangle (LeetCode - 120)
"""

from typing import List

def getMinimumTotal(triangle: List[List[int]], row: int, index: int) -> int :
    # Base Case
    if(row >= len(triangle)) :
        return 0

    # Move to adjacent left 
    adjacentLeft = triangle[row][index] + getMinimumTotal(triangle,row+1,index);

    # Move to adjacent right 
    adjacentRight = triangle[row][index] + getMinimumTotal(triangle,row+1,index+1);

    return min(adjacentLeft,adjacentRight)


def minimumTotal(triangle: List[List[int]]) -> int :
    return getMinimumTotal(triangle,0,0)


triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
print("Minimum Total : ",minimumTotal(triangle))