"""
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

"""

from typing import List

# Function to compute the truncated square root using binary search
def mySqrt(x: int) -> int:
    if x == 0:
        return 0
    
    # Initialize search space
    startIndex = 1
    endIndex = x

    # Binary Search loop
    while startIndex <= endIndex:
        mid = startIndex + (endIndex - startIndex) // 2
        # Calculate mid squared
        # python handles large integers, so no overflow issue here
        mid_squared = mid * mid

        # Check conditions
        if mid_squared == x:
            return mid
        elif mid_squared < x:
            startIndex = mid + 1
        else:
            endIndex = mid - 1

    # return the truncated square root
    return endIndex


# Example usage:
n = int(input("Enter a non-negative integer: "))
result = mySqrt(n)
print(f"The truncated square root of {n} is: {result}")