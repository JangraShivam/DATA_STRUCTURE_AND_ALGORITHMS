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

import java.util.Scanner;

public class PivotIndex {

    // Function to find the pivot index in a rotated sorted array
    public static int findPivotIndex(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            
            // Check if mid element is greater than the last element
            if (arr[midIndex] > arr[arr.length - 1]) {
                startIndex = midIndex + 1;
            } 
            else {
                endIndex = midIndex;
            }
        }

        // At the end of the loop, startIndex will point to the pivot index
        return startIndex;
    }

    public static void main(String[] args) {
        
        System.out.println("Enter input as specified in the problem description.");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        int pivotIndex = findPivotIndex(arr);
        System.out.println(pivotIndex);
    }
}
