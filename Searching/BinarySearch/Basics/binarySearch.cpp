/* 
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
*/

// Binary Search Implementation in C++

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Function to check if the array is sorted in ascending order
bool isAscendingSorted(const vector<int>& arr) {
    for (int i = 1; i < arr.size(); i++) {
        if (arr[i] < arr[i - 1]) {
            return false; // Array is not sorted
        }
    }
    return true; // Array is sorted
}

// Function to check if the array is sorted in descending order
bool isDescendingSorted(const vector<int>& arr) {
    for (int i = 1; i < arr.size(); i++) {
        if (arr[i] > arr[i - 1]) {
            return false; // Array is not sorted
        }
    }
    
    return true; // Array is sorted
}

// Binary Search function for both ascending and descending sorted arrays
int binarySearch(const vector<int>& arr, int target) {

    int size = arr.size(); // Get the size of the array
    int startIndex = 0; // Initialize start index
    int endIndex = size - 1; // Initialize end index

    bool ascending = (arr.back() >= arr.front()); // Determine sorting order

    // Loop until the search space is exhausted
    while (startIndex <= endIndex) {

        // Calculate the middle index to avoid potential overflow
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        // Check if the target is present at midIndex
        if (arr[midIndex] == target) { 
            // Target found at midIndex and return the index
            return midIndex;
        } 
        //check if target is greater than mid element
        else if (target > arr[midIndex]) {
            
            if(ascending) {
                // Move to the right half
                startIndex = midIndex + 1; 
            } 
            else {
                // Move to the left half
                endIndex = midIndex - 1; 
            }

        } 
        // Target is smaller than mid element
        else {

            if(ascending) {
                // Move to the left half
                endIndex = midIndex - 1; 
            } 
            else {
                // Move to the right half
                startIndex = midIndex + 1; 
            }

        }
    }
    // Element not found
    return -1;
}

int main(){

    // Example usage of binarySearch function

    vector<int> arr; // Initialize an empty vector to store the sorted array
    int numberOfELements, target; // Variables to store number of elements and target value

    cout << "Enter number of elements in the array: ";
    cin >> numberOfELements; // Read the number of elements

    cout << "Enter " << numberOfELements << " sorted elements: ";

    // Read the sorted elements into the array
    for(int i = 0; i < numberOfELements; i++) {
        int element;
        cin >> element;
        arr.push_back(element);
    }

    // Check if the array is sorted in ascending or descending order
    if (!isAscendingSorted(arr) && !isDescendingSorted(arr)) {
        cout << "The array is not sorted. Please provide a sorted array." << endl;
        return 0; // Exit the program
    }

    cout << "Enter the target element to search: ";
    cin >> target; // Read the target value

    cout << "\nSearching for " << target << " in the array.\n" << endl;
    // Call binarySearch function and store the result
    int result = binarySearch(arr, target);

    // Output the result
    if(result != -1) {
        cout << "Element found at index: " << result << endl;
    } else {
        cout << "Element not found in the array." << endl;
    }

    // You can also use the STL binary_search function as follows:
    // It does not return the index, only whether the element is present or not.
    bool found = binarySearch(arr, target);
    if(found) {
        cout << "\nElement found using STL binary_search.\n" << endl;
    } else {
        cout << "\nElement not found using STL binary_search.\n" << endl;
    }

    return 0;
}