/*
Problem : Find Peak Index in a rotated sorted array

Description:
Given a rotated sorted array without duplicates, 
return the index of the minimum element, i.e., the pivot.

A rotated sorted array is an array that was originally sorted in ascending order, 
then rotated at some pivot index.

Original array:   [1, 2, 3, 4, 5, 6]
Rotated array:    [4, 5, 6, 1, 2, 3]

Constraints:
-> Array length >= 1
-> No duplicate elements
-> The array was originally sorted in ascending order and then rotated.

Your task is to solve it in O(log(n)) time complexity.

Example:
Input: arr = [4,5,6,1,2,3]
Output: 3

Explanation:
The minimum element is 1 at index 3.

Example 2:
Input: arr = [3,4,5,6,1,2]
Output: 4

Explanation:
The minimum element is 1 at index 4.

Input Format:
First line contains an integer n, the size of the array.
Second line contains n space-separated integers representing the elements of the array.

Output Format:
Output a single integer, the index of the minimum element in the rotated sorted array.

*/

#include <iostream>
#include <vector>
using namespace std;

int findPivotIndex(vector<int>& arr) {
    int startIndex = 0;
    int endIndex = arr.size() - 1;

    // Binary Search
    while (startIndex < endIndex) {
        int mid = startIndex + (endIndex - startIndex) / 2;

        // Check if mid element is greater than the last element
        if (arr[mid] > arr[endIndex]) {
            // Minimum must be in the right half
            startIndex = mid + 1;
        } 
        else {
            // Minimum could be at mid or in the left half
            endIndex = mid;
        }
    }

    // At the end of the loop, startIndex == endIndex pointing to the minimum element
    return startIndex;
}

int main(){

    cout << "Enter input as specified in the problem statement:" << endl;

    int n;
    cin >> n;

    vector<int> arr(n);
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }

    int pivotIndex = findPivotIndex(arr);
    cout << pivotIndex << endl;

    return 0;

}