"""
Problem: Find First Occurrence of a Target (Binary Search)

Description:
Given a sorted array of integers (in ascending order), 
find the first occurrence of a given target element using Binary Search.

If the target exists in the array, return its first index.
If the target does not exist, return -1.

Example 1:
Input: arr = [1, 2, 2, 2, 3], target = 2
Output: 1

Example 2:
Input: arr = [1, 2, 3, 4, 5], target = 6
Output: -1

Constraints : 
-> Array is sorted in ascending order
-> Array may contain duplicates
-> Size of array can be large (up to 10⁵ or more)
-> Must use O(log n) time complexity

Input
-> An integer n — number of elements
-> n sorted integers
-> An integer target — value to find

Output
-> Index of first occurrence of target
-> Or -1 if the target does not exist

"""
from typing import List

def firstOccurrence(nums: List[int], target: int) -> int:
    startIndex = 0
    endIndex = len(nums)-1

    firstOccurrenceIndex = -1

    while startIndex <= endIndex :
        mid = startIndex + (endIndex - startIndex)//2

        if nums[mid] == target:
            firstOccurrenceIndex = mid # Update and store first occurrence index

            # Continue searching in the left half for earlier occurrence
            endIndex = mid - 1
        elif nums[mid] > target :
            endIndex = mid-1
        else :
            startIndex = mid + 1

    return firstOccurrenceIndex


# Example usage:
print("Enter input in the given format in description :")
n = int(input())
arr = list(map(int, input().split()))[:n] 
target = int(input())

result = firstOccurrence(arr, target)
print(result)