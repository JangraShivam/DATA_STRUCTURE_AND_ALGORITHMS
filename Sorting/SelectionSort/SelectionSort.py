# Selection Sort implementation
def selectionSort(arr) :

    size = len(arr) # size of array

    """
        go to each position from left to right and
        find the minimum element to its right and replace it with minimum element
        then go to next position then again find min element to its right
    """
    for i in range (0,size-1) :

        minIndex = i # intilaize or assume that current position element is minimum

        # look for minimum element to right of position
        for j in range (i+1,size) :
            # if minimum element is found then update minimum element index
            if(arr[j] < arr[minIndex]) :
                minIndex = j

        # swap the current position element with position of minimum element
        arr[i],arr[minIndex] = arr[minIndex],arr[i]
    

# main program
arr = list(map(int, input().strip().split()))
selectionSort(arr)
print(arr)