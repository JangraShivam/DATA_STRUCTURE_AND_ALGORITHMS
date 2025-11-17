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

// Java implementation of Binary Search Algorithm
import java.util.Scanner;
import java.util.Arrays;

// Main class
public class BinarySearch{

    // Function to check if the array is sorted in ascending order
    public static boolean isAscendingSorted(int arr[], int n){
        for(int i = 0; i < n - 1; i++){
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    // Function to check if the array is sorted in descending order
    public static boolean isDescendingSorted(int arr[], int n){
        for(int i = 0; i < n - 1; i++){
            if(arr[i] < arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    // Binary Search function for both ascending and descending sorted arrays
    public static int binarySearch(int[] arr, int target){

        int size = arr.length; // size of the array
        int startIndex = 0; // starting index
        int endIndex = size - 1; // ending index

        boolean isAsc = arr[startIndex] <= arr[endIndex]; // check if the array is sorted in ascending order

        // Loop until the search space is exhausted
        while(startIndex <= endIndex){

            // Calculate the middle index to avoid potential overflow
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            
            // Check if the target is present at midIndex
            if(arr[midIndex] == target){

                return midIndex;// target found, return the index
            }
            // Adjust the search space based on the order of sorting
            else if(isAsc){
                // If array is sorted in ascending order
                if(target < arr[midIndex]){
                    // Target is in the left half
                    endIndex = midIndex - 1;
                } else {
                    // Target is in the right half
                    startIndex = midIndex + 1;
                }
            } 
            else {
                // If array is sorted in descending order
                if(target > arr[midIndex]){
                    // Target is in the left half
                    endIndex = midIndex - 1;
                } else {
                    // Target is in the right half
                    startIndex = midIndex + 1;
                }
            }
        }
        return -1;
    }
    public static void main (String[] args) {
        
        int arr[]; // array declaration
        int numberOfElements, target; // number of elements and target element to search

        System.out.print("Enter number of elements in the array: ");

        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);
        numberOfElements = sc.nextInt();

        System.out.println("Enter the " + numberOfElements + " elements (sorted order): ");

        // Input array elements
        arr = new int[numberOfElements];
        for(int i = 0; i < numberOfElements; i++){
            int element = sc.nextInt();
            arr[i] = element;
        }

        // Check if the array is sorted (ascending or descending)
        if(!isAscendingSorted(arr, numberOfElements) && !isDescendingSorted(arr, numberOfElements)){
            System.out.println("Error: The array is not sorted. Please provide a sorted array.");
            sc.close();
            return;
        }

        // Input target element to search
        System.out.print("Enter the target element to search: ");
        target = sc.nextInt();

        // Perform binary search
        int resultIndex = binarySearch(arr, target);

        // Output the result
        if(resultIndex == -1){
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + resultIndex);
        }

        // Example usage of Arrays.binarySearch for comparison
        // Note: This method assumes the array is sorted in ascending order
        if(!isAscendingSorted(arr, numberOfElements)){
            System.out.println("Note: Arrays.binarySearch requires the array to be sorted in ascending order.");
        }
        int builtInIndex = Arrays.binarySearch(arr, target);
        if(builtInIndex >= 0){
            System.out.println("Element found at index (using Arrays.binarySearch): " + builtInIndex);
        } else {
            System.out.println("Element not found in the array (using Arrays.binarySearch).");
        }

        // Close the scanner
        sc.close();
    }
}
