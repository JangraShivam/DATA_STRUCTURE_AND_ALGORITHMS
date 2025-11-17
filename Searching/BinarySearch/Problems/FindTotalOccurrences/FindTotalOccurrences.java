/*
Problem: Find total Occurrences of a Target (Binary Search)

Description:
Given a sorted array of integers (in ascending order), 
find the total occurrences of a given target element using Binary Search.

Return the count of occurrences of the target in the array.

Example 1:
Input: arr = [1, 2, 2, 2, 2, 3, 6, 10], target = 2
Output: 4

Example 2:
Input: arr = [1, 3, 3, 4, 5], target = 6
Output: 0

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
-> print total occurrences of target

*/

// Solution Code:

import java.util.Scanner;

public class FindTotalOccurrences {

    // Function to find the first occurrence of target
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

    // Function to find the last occurrence of target
    public static int firstOccurrence(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int startIndex = 0;
        int endIndex = nums.length-1;

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

        //Function calls
        int firstIndex = firstOccurrence(nums, target);
        int lastIndex = lastOccurrence(nums, target);

        //Checking if target exists in array
        if(firstIndex == -1 || lastIndex == -1){
            System.out.println(0); // Target not found
            return;
        } 

        // Calculate total occurences
        int totalOccurrences = lastIndex - firstIndex + 1;
        System.out.println(totalOccurrences);

    }
}