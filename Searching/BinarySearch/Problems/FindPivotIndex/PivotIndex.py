"""
Problem : Find Peak Index in a rotated sorted array

Description:
Given a rotated sorted array without duplicates, 
return the index of the minimum element, i.e., the pivot.

A rotated sorted array is an array that was originally sorted in ascending order, 
then rotated at some pivot index.

Original array:   [1, 2, 3, 4, 5, 6]
Rotated array:    [4, 5, 6, 1, 2, 3]

Constraints:
-> Array length >= 1
-> No duplicate elements
-> The array was originally sorted in ascending order and then rotated.

Your task is to solve it in O(log(n)) time complexity.

Example:
Input: arr = [4,5,6,1,2,3]
Output: 3

Explanation:
The minimum element is 1 at index 3.

Example 2:
Input: arr = [3,4,5,6,1,2]
Output: 4

Explanation:
The minimum element is 1 at index 4.

Input Format:
First line contains an integer n, the size of the array.
Second line contains n space-separated integers representing the elements of the array.

Output Format:
Output a single integer, the index of the minimum element in the rotated sorted array.

"""

from typing import List

# Function to find the pivot index in a rotated sorted array
def find_pivot_index(arr: List[int]) -> int:
    startIndex = 0
    endIndex = len(arr) - 1

    while startIndex < endIndex:
        midIndex = startIndex + (endIndex - startIndex) // 2

        # check if mid element is greater than the end element
        if arr[midIndex] > arr[endIndex]:
            # minimum must be in the right half
            startIndex = midIndex + 1
        else:
            # minimum must be in the left half including mid
            endIndex = midIndex

    # At the end of the loop, startIndex will point to the minimum element
    return startIndex


# Example usage:
print("Enter input as specified in the problem statement:")
n = int(input().strip())
arr = list(map(int, input().strip().split()))[:n]
pivot_index = find_pivot_index(arr)
print(pivot_index)
