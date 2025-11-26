# Insertion Sort implementation
def insertionSort(arr) :

    size = len(arr) # size of array

    """
        Loop over each element and put it in its right position
        in left part to the element which is sorted
    """
    for i in range (1,size) :

        index = i # Index of element to be put in right position

        """
            Loop back from index and compare element at index to its left adjacent
            or element at index-1, if its greater that means element at index must be
            left to index-1 element so swap them and decrement index and do it until a smaller element than element 
            at index appears and break out of loop
        """
        while index > 0 :
            # check if Left element is greater than index element and swap
            if(arr[index] < arr[index-1]) :
                arr[index-1],arr[index] = arr[index],arr[index-1]
            # break because index element is in right position
            else :
                break

            index-=1 # decrement index

    

# main program
arr = list(map(int, input().strip().split()))
insertionSort(arr)
print(arr)