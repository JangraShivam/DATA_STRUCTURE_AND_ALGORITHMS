/*
Problem: Implementing square root function using Binary Search

Description:
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, 
and only the integer part of the result is returned.

You must not use any built-in exponent function or operator.

Constraints:
-> 0 <= x <= 2^31 - 1

Input Format:
-> A single non-negative integer x.

Output Format:
-> A single integer representing the truncated square root of x.

Approach:
-> Use binary search to find the largest integer whose square is less than or equal to x.
-> This problem is based search space pattern.
-> Here the search space is the answer space which lies between 0 to x.
-> We will keep narrowing down the search space based on the square of the mid value.
-> If mid*mid is equal to x, we found our answer.
-> If mid*mid is less than x, we move our search space to the right half.
-> If mid*mid is greater than x, we move our search space to the left half

*/

import java.util.Scanner;

public class SqrtOfX {
    public static int mySqrt(int x) {
        if (x == 0) return 0; // Edge case for 0

        // Initialize search space
        int startIndex = 1;
        int endIndex = x;
        int ans = 0;

        // Binary search for the square root
        while (startIndex <= endIndex) {

            int mid = startIndex + (endIndex - startIndex) / 2;
            long midSquared = (long) mid * mid; // Use long to prevent overflow

            if (midSquared == x) {
                return mid; // Found exact square root
            } 
            else if (midSquared < x) {
                ans = mid; // Update answer and search in the endIndex half
                startIndex = mid + 1;
            } 
            else {
                endIndex = mid - 1; // Search in the left half
            }
        }

        return ans; // Return the truncated square root
    }

    public static void main(String[] args) {
        
        System.out.println("Enter a non-negative integer x: "); 

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.close();

        int result = mySqrt(x);
        System.out.println("The truncated square root of " + x + " is: " + result);
    }
}