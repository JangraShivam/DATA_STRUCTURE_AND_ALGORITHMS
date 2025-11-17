"""
BinarySearch is a searching algorithm 
that finds the position of a target value in a sorted array.

Conditions:
1. The array must be sorted (ascending or descending).

2. Access to elements must be random (O(1)), 
   which is why it works best on arrays, not linked lists.

How it works (Divide & Conquer) :
1. Compare the target with the middle element.
2. If equal → return the index.
3. If target is smaller → search the left half.
4. If target is larger → search the right half.
5. Repeat until the range becomes empty. 

Time & Space Complexity:
-> Time: O(log n)
-> Space: O(1) (iterative) or O(log n) (recursive)

When to Use
-> Large datasets (≥ 10⁶ elements)
-> When data is sorted
-> When you need very fast lookup

When Not to Use
-> Unsorted arrays
-> Linked lists (no random access)
-> Small arrays (linear search can be faster due to constant factors)

Why It’s Powerful
-> Binary Search reduces the search space by half at every step, 
   making it extremely efficient.
-> Better than linear search (O(n)) for large datasets.
   where linear search do 10^6 comparisons in worst case,
   binary search does only about 20 comparisons.
"""

# check if the array is sorted in ascending order
def isAscendingSorted(arr: list) -> bool:
    """Check if the array is sorted in ascending order."""
    return all(arr[i] <= arr[i + 1] for i in range(len(arr) - 1))

# check if the array is sorted in descending order
def isDescendingSorted(arr : list) -> bool:
    """Check if the array is sorted in descending order."""
    return all(arr[i] >= arr[i + 1] for i in range(len(arr) - 1))

# Binary Search function (supports both ascending and descending sorted arrays)
def binary_search(arr: list, target: int) -> int:

    size = len(arr) # size of the array
    startIndex = 0 # starting index
    endIndex = size - 1 # ending index

    isAscending = arr[0] <= arr[-1] # check if array is sorted in ascending order

    # loop until the search space is exhausted
    while startIndex <= endIndex:

        # Calculate mid index to avoid potential overflow
        midIndex = (startIndex + endIndex) // 2

        # Check if the target is present at midIndex
        if arr[midIndex] == target:

            # Target found at midIndex
            return midIndex 


        # If array is sorted in ascending order
        if isAscending :

            # Target is smaller than mid element
            if target < arr[midIndex]:
                endIndex = midIndex - 1 # Move to left half

            # Target is larger than mid element
            else:
                startIndex = midIndex + 1 # Move to right half

        # If array is sorted in descending order
        else :

            # Target is larger than mid element
            if target > arr[midIndex]:
                endIndex = midIndex - 1 # Move to left half

            # Target is smaller than mid element
            else:
                startIndex = midIndex + 1 # Move to right half

    # Target not found
    return -1

# Example usage
if __name__ == "__main__":

    arr = [] # Initialize an empty array

    # Input number of elements
    numberOfElements = int(input("Enter number of elements in the array: "))

    # Input elements of the array
    print("Enter the elements of the array:")

    # Loop to read each element
    for _ in range(numberOfElements):
        element = int(input()) # Read element
        arr.append(element) # Append element to the array

    # Check if the array is sorted
    if not (isAscendingSorted(arr) or isDescendingSorted(arr)):
        print("Error: The array must be sorted in ascending or descending order.")
        exit(1)

    # Input target value to search
    target = int(input("Enter the target value to search: "))

    # Perform binary search
    resultIndex = binary_search(arr, target)

    # Output the result
    if resultIndex != -1:
        print(f"Target {target} found at index {resultIndex}.")
    else:
        print(f"Target {target} not found in the array.")


    # python inbuilt binary search
    import bisect

    if isAscendingSorted(arr):
        index = bisect.bisect_left(arr, target)
        if index != len(arr) and arr[index] == target:
            print(f"(Inbuilt) Target {target} found at index {index}.")
        else:
            print(f"(Inbuilt) Target {target} not found (inbuilt).")
    else:
        print("(Inbuilt) Skipped: bisect only works on ascending sorted arrays.")  

