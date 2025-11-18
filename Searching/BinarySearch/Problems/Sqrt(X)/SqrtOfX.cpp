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

#include <iostream>
using namespace std;

int mySqrt(int x) {

    // Handle edge cases
    if (x == 0 || x == 1) return x;

    // Binary Search initialization
    int startIndex = 1;
    int endIndex = x;
    int ans = 0;

    // Binary Search loop
    while (startIndex <= endIndex) {

        int mid = startIndex + (endIndex - startIndex) / 2;
        // To prevent potential overflow, use long long for midSquared
        long long midSquared = (long long)mid * mid;

        // Check if mid*mid is equal to x
        if (midSquared == x) {
            return mid;
        } 
        // If mid*mid is less than x, move to the right half
        else if (midSquared < x) {
            ans = mid; // Update answer
            startIndex = mid + 1; // Move to the right half
        } 
        // If mid*mid is greater than x, move to the left half
        else {
            endIndex = mid - 1; // Move to the left half
        }
    }
    return ans;
}

int main(){

    cout << "Enter a non-negative integer x: ";
    int x;
    cin >> x;

    int result = mySqrt(x);
    cout << "The truncated square root of " << x << " is: " << result << endl;
    
    return 0;
}