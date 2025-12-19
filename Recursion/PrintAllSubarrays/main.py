"""
Problem : Given an array, print all subarrays
"""

def printAllSubArrays(arr,start,end) :
    # Base Case
    if(end >= len(arr)) :
        return

    # Print the current subarray
    for i in range(start, end+1) :
        print(arr[i],end=" ")
    
    print()

    # recusrion print all subarray with same start 
    printAllSubArrays(arr,start,end+1)

    # return to find the start
    if(start != end) :
        return

    # Increment start 
    start += 1
    end = start

    # Print all subarray with next start index
    printAllSubArrays(arr,start,end)


arr = [1,2,3,4,5]
printAllSubArrays(arr,0,0)
