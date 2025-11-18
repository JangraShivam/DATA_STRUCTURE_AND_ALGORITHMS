/*
Problem : Find Peak Index in a Mountain Array

Description:
Given an array arr that is a mountain (strictly increasing then strictly decreasing, length ≥ 3), 
return the index i such that arr[i] is the peak (largest element).
Your task is to solve it in O(log(n)) time complexity.

Constraints:
-> arr.length >= 3
-> There exists some i with 0 < i < arr.length - 1 such that:
   arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example:
Input: arr = [0,2,1,0]
Output: 1

Explanation:
The peak element is 2 at index 1.

Example 2:
Input: arr = [0,1,3,5,6,8,2]
Output: 5

Explanation:
The peak element is 8 at index 5.

Input Format:
First line contains an integer n, the size of the array.
Second line contains n space-separated integers representing the elements of the array.

Output Format:
Output a single integer, the index of the peak element in the mountain array.

*/

import java.util.Scanner;

public class PeakIndex {
    
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // Binary Search
        while(start <= end){
            int mid = start + (end - start)/2;

            // Check if mid is peak
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            // If mid is in increasing part
            else if(arr[mid] > arr[mid-1]){
                start = mid + 1;
            }
            // If mid is in decreasing part
            else{
                end = mid;
            }

        }

        // This line should never be reached if input constraints are met
        return -1;
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

        int peakIndex = peakIndexInMountainArray(arr);
        System.out.println(peakIndex);
    }
}