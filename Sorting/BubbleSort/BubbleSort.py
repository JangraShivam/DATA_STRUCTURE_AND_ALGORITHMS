# Bubble Sort Implementation
def bubbleSort(arr) :

    """
        Intialize round variable to 1, 
        In each round we try to place largest number to its correct position
        for round 1 -> 1st largest
        for round 2 -> 2nd largest and so on..
    """
    round = 1; 
    
    """
        There will be rounds one less than array size
        because in last round the last element will be in its correct position
        as all largest element are already placed correctly
        So loop over each round to place them correctly
    """
    while (round < len(arr)) :

        i = 1; # Intialize i to 1
        
        """
            iterate over array and as we find previous element greater than current
            swap them because it is larger and will be placed in right of current element
            in this way we find largest element as it will be at rightmost position
            
            As we placed largest element in correct position in a round then in next one
            that position will be banned or there will be no point in comparing them as they
            are larger than rest of elements -> i <= arr.size() - round
        """
        while (i <= len(arr) - round) :

            # place larger element right
            if(arr[i] < arr[i-1]):
                arr[i],arr[i-1] = arr[i-1],arr[i]

            i+=1

        # increase round count
        round+=1


# Bubble Sort with flag Implementation
def bubbleSortWithFlag(arr):

    """
        Intialize round variable to 1, 
        In each round we try to place largest number to its correct position
        for round 1 -> 1st largest
        for round 2 -> 2nd largest and so on..
    """
    round = 1; 
    
    """
        There will be rounds one less than array size
        because in last round the last element will be in its correct position
        as all largest element are already placed correctly
        So loop over each round to place them correctly
    """
    while(round < len(arr)) :

        """
            Use a flag to reduce rounds 
            if there were no swaps in a round that mean array is sorted
            no need for further rounds
        """
        swapped = False; # intialize swapped to false
        i = 1; # Intialize i to 1
        
        """
            iterate over array and as we find previous element greater than current
            swap them because it is larger and will be placed in right of current element
            in this way we find largest element as it will be at rightmost position
            
            As we placed largest element in correct position in a round then in next one
            that position will be banned or there will be no point in comparing them as they
            are larger than rest of elements -> i <= arr.size() - round
        """
        while(i <= len(arr) - round) :

            # place larger element right
            if (arr[i] < arr[i-1]) :
                arr[i],arr[i-1] = arr[i-1],arr[i]
                swapped = True # swap happen so set swapped to true

            i+=1

        # if swapped is false no swapping happened so break out of loop
        if(not swapped):
            break

        # increase round count
        round+=1


# main program
arr = list(map(int, input().strip().split()))

bubbleSort(arr)
print(arr)
