"""
Problem: Problem: Single Element in Array With Adjacent Duplicate Pairs

Description
You are given an integer array where:
Every element that appears twice appears in a pair (i.e., next to its duplicate).
Exactly one element appears only once.
The array is not necessarily sorted, but duplicate elements always occur consecutively.
Your task is to return the unique element that appears only once.
You must solve this in O(log n) time and O(1) extra space using Binary Search.

Important Constraint
-> The array is not sorted, but pairs are always adjacent.
-> This special structure still allows a binary-search-based solution.

Input Format
-> First line : an non-negative integer representing array size
-> Second line : n space separated integers

Output:
-> Return the single element that appears only once.

Example 1
Input:
nums = [7, 7, 3, 3, 10, 11, 11]

Output:
10

"""

from typing import List

def oddOccurringElement(arr: List[int]) -> int :

    startIndex = 0
    endIndex = len(arr) - 1

    while startIndex <= endIndex :
        if startIndex == endIndex :
            return arr[startIndex]
        
        midIndex = (startIndex + endIndex)//2

        if arr[midIndex] != arr[midIndex-1] and arr[midIndex] != arr[midIndex+1]:
            return arr[midIndex]
        
        if arr[midIndex] == arr[midIndex-1] :
            if (midIndex-1)&1 == 1:
                endIndex = midIndex - 2
            else :
                startIndex = midIndex + 1
        else :
            if (midIndex)&1 == 1:
                endIndex = midIndex - 1
            else :
                startIndex = midIndex + 2

    return -1


# main program
n = int(input("Enter array size : "))
arr = list(map(int, input().strip().split()))[:n]

result = oddOccurringElement(arr)
print(result)