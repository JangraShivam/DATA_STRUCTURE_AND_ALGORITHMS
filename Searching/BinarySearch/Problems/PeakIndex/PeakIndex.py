"""
Problem : Find Peak Index in a Mountain Array

Description:
Given an array arr that is a mountain (strictly increasing then strictly decreasing, length ≥ 3), 
return the index i such that arr[i] is the peak (largest element).
Your task is to solve it in O(log(n)) time complexity.

Constraints:
-> arr.length >= 3
-> There exists some i with 0 < i < arr.length - 1 such that:
   arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example:
Input: arr = [0,2,1,0]
Output: 1

Explanation:
The peak element is 2 at index 1.

Example 2:
Input: arr = [0,1,3,5,6,8,2]
Output: 5

Explanation:
The peak element is 8 at index 5.

Input Format:
First line contains an integer n, the size of the array.
Second line contains n space-separated integers representing the elements of the array.

Output Format:
Output a single integer, the index of the peak element in the mountain array.

"""
from typing import List

def peakIndexInMountainArray(arr: List[int]) -> int:
    start = 0
    end = len(arr) - 1

    while start <= end :
        mid = (start + end)//2

        if arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]:
            return mid
        elif arr[mid] > arr[mid-1] :
            start = mid + 1
        else :
            end = mid
        
    return -1


# Example usage:
print("Enter input as specified in the Input Format:")
n = int(input().strip())
arr = list(map(int, input().strip().split()))[:n]

solution = peakIndexInMountainArray(arr)
print(solution)