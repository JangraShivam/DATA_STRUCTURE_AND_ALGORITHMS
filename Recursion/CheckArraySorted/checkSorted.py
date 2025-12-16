"""
Problem : Check Array is sorted or not.
"""

def isSorted(arr,index):
    # Base Case
    if index >= len(arr):
        return True
    
    # 2nd Base Case
    if arr[index] < arr[index-1]:
        return False
    
    return isSorted(arr,index+1)


arr = [1,2,3,4,5,6,7]

if isSorted(arr,1):
    print("Array is Sorted")
else :
    print("Array is not Sorted")