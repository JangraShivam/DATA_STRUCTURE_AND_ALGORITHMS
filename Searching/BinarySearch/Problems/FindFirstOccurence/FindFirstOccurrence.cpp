/*
Problem: Find First Occurrence of a Target (Binary Search)

Description:
Given a sorted array of integers (in ascending order), 
find the first occurrence of a given target element using Binary Search.

If the target exists in the array, return its first index.
If the target does not exist, return -1.

Example 1:
Input: arr = [1, 2, 2, 2, 3], target = 2
Output: 1

Example 2:
Input: arr = [1, 2, 3, 4, 5], target = 6
Output: -1

Constraints : 
-> Array is sorted in ascending order
-> Array may contain duplicates
-> Size of array can be large (up to 10⁵ or more)
-> Must use O(log n) time complexity

Input
-> An integer n — number of elements
-> n sorted integers
-> An integer target — value to find

Output
-> Index of first occurrence of target
-> Or -1 if the target does not exist

*/

// Solution Code:

#include <iostream>
#include <vector>
using namespace std;

// Function to find the first occurrence of target in a sorted array
int firstOccurrence(vector<int>& nums, int target) {
    if(nums.empty()) return -1;

    int startIndex = 0;
    int endIndex = nums.size()-1;

    int firstOccurrenceIndex = -1; // Default value if target not found

    while(startIndex <= endIndex){
        int midIndex = startIndex + (endIndex - startIndex)/2;
        
        // Check if midIndex is the target
        if(nums[midIndex] == target){
            firstOccurrenceIndex = midIndex; // Update and store first occurrence index

            // Continue searching in the left half for earlier occurrence
            endIndex = midIndex-1;
        }
        else if(nums[midIndex] > target) endIndex = midIndex-1;
        else startIndex = midIndex+1;
    }

    return firstOccurrenceIndex;
}

int main(){

    cout << "Enter input in the given format in description :" << endl;
    
    // Input reading
    int n;
    cin >> n;

    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }

    int target;
    cin >> target;  

    // Function call
    int result = firstOccurrence(nums, target);

    // Output the result
    cout << result << endl;

    return 0;
}