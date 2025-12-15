"""
Problem : Binary Search using recursion
"""

def binarySearch(arr, start, end, target):
    if start > end :
        return -1
    
    mid = (start + end)//2

    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binarySearch(arr,start,mid-1,target)
    else:
        return binarySearch(arr,mid+1,end,target)
    
arr = [1,2,3,4,5,6,7,8,9,10]
target = 10

foundIndex = binarySearch(arr,0,len(arr)-1,target)

if not(foundIndex == -1):
    print("Target found at index : ",foundIndex)
else:
    print("Target not found")