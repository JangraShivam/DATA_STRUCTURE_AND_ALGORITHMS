/*
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


*/

#include <iostream>
using namespace std;

// Function that returns quotient if dividend and divisor are positive
int getQuotient(int dividend, int divisor){

    // Intialize Search Space
    int minValue = 0;
    int maxValue = dividend;

    // Intialize quotient
    int quotient = -1;

    // Binary Search in Search space 
    while(minValue <= maxValue){

        // Calculate possible quotient
        int possibleAnswer = minValue + ((maxValue - minValue)>>1);

         // Check whether possibleAnswer can be a valid quotient
         // Check if possibleAnswer * divisor <= dividend
        if((long long)(possibleAnswer*divisor) <= (long long)dividend){
            quotient = possibleAnswer;
            minValue = possibleAnswer + 1;
        }
        else{
            maxValue = possibleAnswer - 1;
        }
        
    }

    // return answer
    return quotient;
}

int main(){

    cout << "Enter input as specified in problem description : " << endl;
    int dividend;
    cin >> dividend;

    int divisor;
    cin >> divisor;

    if(divisor == 0){
        cout << "Divisor can't be 0" << endl;
        return 0;
    }

    // Work with absolute values
    int quotient = getQuotient(abs(dividend),abs(divisor));

    // Apply sign correction
    if((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)){
        quotient = -quotient;
    }

    cout << quotient << endl;


    return 0;

}