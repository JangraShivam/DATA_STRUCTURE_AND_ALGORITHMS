"""
Problem : Minimize the Difference Between Target and Chosen Elements (LC - 1981)
"""
import sys
from typing import List

def minimize(mat: List[List[int]], target: int, row: int) :
    # return the absolute difference
    if(row >= len(mat)) :
        return abs(target)
    

    # Intialize min dff
    minDiff = sys.maxsize

    # Iterate on current row for minimum diff
    for col in range(0, len(mat[row])) :
        minDiff = min(minDiff,minimize(mat,target-mat[row][col], row+1))

    return minDiff


def minimizeTheDifference(mat: List[List[int]], target: int) :
    return minimize(mat,target, 0)




mat = [[1,2,3],
       [4,5,6],
       [7,8,9]]

target = 13

print("Minimum difference : ", minimizeTheDifference(mat,target))
