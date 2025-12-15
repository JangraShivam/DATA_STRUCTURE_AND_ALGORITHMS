"""
Problem : Search in array (linear Search using recursion)
"""

def linearSearch(arr,index,target):
    if index >= len(arr) :
        return -1
    
    if arr[index] == target:
        return index
    
    answer = linearSearch(arr,index+1,target)
    return answer


arr = [2,5,89,-1,78,32,-98,100]
target = -1

foundIndex = linearSearch(arr,0,target)

if foundIndex != -1:
    print("Target found at index : ",foundIndex)
else:
    print("Target not found")
