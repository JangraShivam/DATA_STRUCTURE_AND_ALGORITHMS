/*
Problem: Find Last Occurrence of a Target (Binary Search)

Description:
Given a sorted array of integers (in ascending order), 
find the last occurrence of a given target element using Binary Search.

If the target exists in the array, return its last index.
If the target does not exist, return -1.

Example 1:
Input: arr = [1, 2, 2, 2, 3], target = 2
Output: 3

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
-> Index of last occurrence of target
-> Or -1 if the target does not exist

*/

// Solution Code 

import java.util.Scanner;

public class FindLastOccurrence {

    public static int lastOccurrence(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int startIndex = 0;
        int endIndex = nums.length-1;

        int lastOccurrenceIndex = -1; // Default value if target not found

        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            
            // Check if midIndex is the target
            if(nums[midIndex] == target){
                lastOccurrenceIndex = midIndex; // Update and store last occurrence index

                // Move to the right half to find a later occurrence
                startIndex = midIndex+1;
            }
            else if(nums[midIndex] > target) endIndex = midIndex-1;
            else startIndex = midIndex+1;
        }

        return lastOccurrenceIndex;
    }

    public static void main(String[] args) {
        
        System.out.println("Enter input in the given format in description :");
        
        //Input reading
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //number of elements

        //reading sorted array
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        //reading target
        int target = sc.nextInt();
        
        //Closing scanner
        sc.close();

        //Function call
        int result = lastOccurrence(nums, target);

        //Output the result
        System.out.println(result);
    }
}