"""
Problem: Divide Two Integers (Without Using / or %)

Description
Given two integers, dividend and divisor, your task is to compute the quotient 
when the dividend is divided by the divisor — without using the division (/), modulo (%).
The division result should truncate toward zero.

You must solve this in O(log n) time using either Binary Search

Constraints
-> You must not use: / division operator , % modulo operator
-> You may use: +, -, bitwise operations, and comparisons
-> Handle both positive and negative integers.
-> Assume the divisor is non-zero.
-> The result will fit within the range of a 32-bit signed integer.

Input Format :
-> First Line : dividend
-> Second Line : divisor

Output :
-> Print an integer representing the quotient after division (truncated toward zero)

Example:
Input:
10
3

Output:
3

Explanation:
10 / 3 = 3.333… → truncated to 3

"""

from typing import List

# Function that returns quotient if dividend and divisor are positive
def getQuotient(dividend :int, divisor :int) -> int :

    # Intialize Search Space
    minValue = 0
    maxValue = dividend

    # Intialize quotient
    quotient = -1

    # Binary Search in Search space 
    while minValue <= maxValue :

        # Calculate possible quotient
        possibleAnswer = ((minValue + maxValue) >> 1)

        # Check whether possibleAnswer can be a valid quotient
        # Check if possibleAnswer * divisor <= dividend
        if possibleAnswer*divisor <= dividend :
            quotient = possibleAnswer
            minValue = possibleAnswer + 1
        else :
            maxValue = possibleAnswer - 1

    return quotient



# Example
print("Enter input as specified above in description : ")
dividend = int(input("Enter dividend : "))
divisor = int(input("Enter divisor : "))

if divisor == 0:
    print("Divisor can't be 0")
    exit(0)

quotient = getQuotient(abs(dividend),abs(divisor))

# Apply sign correction
if (divisor > 0 and dividend < 0) or (divisor < 0 and dividend > 0):
    quotient = -quotient

print(quotient)