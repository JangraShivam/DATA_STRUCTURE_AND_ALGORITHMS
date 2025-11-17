"""
Problem: Find total Occurrences of a Target (Binary Search)

Description:
Given a sorted array of integers (in ascending order), 
find the total occurrences of a given target element using Binary Search.

Return the count of occurrences of the target in the array.

Example 1:
Input: arr = [1, 2, 2, 2, 2, 3, 6, 10], target = 2
Output: 4

Example 2:
Input: arr = [1, 3, 3, 4, 5], target = 6
Output: 0

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
-> print total occurrences of target

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

def lastOccurrence(nums: List[int], target: int) -> int:
    startIndex = 0
    endIndex = len(nums)-1

    lastOccurrenceIndex = -1

    while startIndex <= endIndex :
        midIndex = startIndex + (endIndex - startIndex)//2

        # Check if midIndex is the target
        if nums[midIndex] == target:
            lastOccurrenceIndex = midIndex # Update and store last occurrence index

            # Move to the right half to find a later occurrence
            startIndex = midIndex + 1
        elif nums[midIndex] > target :
            endIndex = midIndex-1
        else :
            startIndex = midIndex + 1

    return lastOccurrenceIndex

# Example usage:
print("Enter input in the given format in description :")
n = int(input())
arr = list(map(int, input().split()))[:n] 
target = int(input())

# Find first and last occurrences
firstIndex = firstOccurrence(arr, target)
lastIndex = lastOccurrence(arr, target)

if firstIndex == -1 or lastIndex == -1:
    print(0)  # Target not found
    exit()

# Calculate total occurrences
totalOccurrences = lastIndex - firstIndex + 1
print(totalOccurrences)