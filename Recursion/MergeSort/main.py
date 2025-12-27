"""
Problem : Merge Sort
"""

def mergeSortedArrays(arr: list[int], start: int, end: int) :

    mid = (start + end)//2

    # Create two empty arrays
    leftArray = []
    rightArray = []

    # copy left and right array value into their respective array
    for i in range(start, mid+1) :
        leftArray.append(arr[i])
    
    for i in range(mid+1, end+1) :
        rightArray.append(arr[i])

    # merge logic for two sorted array
    leftArrayIndex = 0
    rightArrayIndex = 0
    arrIndex = start

    while(leftArrayIndex < len(leftArray) and rightArrayIndex < len(rightArray)) :
        if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) :
            arr[arrIndex] = leftArray[leftArrayIndex]
            arrIndex+=1
            leftArrayIndex+=1
        else :
            arr[arrIndex] = rightArray[rightArrayIndex]
            arrIndex+=1
            rightArrayIndex+=1
        

    while(leftArrayIndex < len(leftArray)) :
        arr[arrIndex] = leftArray[leftArrayIndex]
        arrIndex+=1
        leftArrayIndex+=1

    while(rightArrayIndex < len(rightArray)) :
        arr[arrIndex] = rightArray[rightArrayIndex]
        arrIndex+=1
        rightArrayIndex+=1


def mergeSort(arr: list[int], start: int, end: int) :
    # Base Case
    if(start >= end) :
        return

    mid = (start + end)//2

    # left part
    mergeSort(arr, start, mid)
    # right part
    mergeSort(arr,mid+1,end)

    # merge left and right sorted array
    mergeSortedArrays(arr,start,end)



arr = [10,45,0,2,-1,78,42,-10,0,56]
start = 0
end = len(arr) - 1
mergeSort(arr,start,end)
print(arr)