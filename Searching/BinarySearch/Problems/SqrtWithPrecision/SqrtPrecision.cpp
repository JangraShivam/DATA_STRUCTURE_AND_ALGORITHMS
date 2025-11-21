/*
Problem : Square Root Using Binary Search (with Precision)

Description
Given a non-negative number x and an integer p representing the required number of digits after the decimal, 
compute the square root of x up to p decimal places. You must not use built-in functions like sqrt(); 
instead, implement the solution using binary search (also known as search-space binary search).
Your algorithm should run efficiently for large values of x and high precision p.

Input:
-> An integer or floating-point number x 
-> An integer p such that 0 ≤ p ≤ 10

Output
-> A floating-point value representing √x, rounded or truncated to p decimal places.

Constraints
-> Binary search must be used.
-> Time complexity should be approximately: O(log(x) + p * 10)

Expected Approach:
Use integer binary search to compute the integer part of the square root.
Use linear expansion / fractional binary search to compute each decimal place, 
one at a time, up to precision p.

*/

#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;

double sqrtWithPrecision2(double x,int p){

    double precision = 1/pow(10,p);

    double start = 0;
    double end = x;
    double answer = -1;
    while(end - start >= precision){
        double mid = start + (end - start)/2;

        if(mid*mid <= x){
            answer = mid;
            start = mid + precision;
        }
        else{
            end = mid - precision;
        }
    }

    return answer;
}

double sqrtWithPrecision(double x,int p){

    //Find integer or base part of answer
    //Intialize search space
    long long int start = 0;
    long long int end = (long long int)(x);

    double answer = -1;

    // Binary Search to find integer part
    while(start <= end){

        long long int mid = start + (end - start)/2;
        double midSquare = mid*mid;

        if(midSquare <= x){
            answer = mid;
            start = mid + 1;
        }
        else{
            end = mid-1;
        }

    }


    //calculate fraction part
    int precision = 1;
    int denom = 10;
    while(precision <= p){
        
        int s = 0;
        int e = 9;
        double ans = answer;

        while(s <= e){
            int m = (s+e)/2;
            double possAnswer = ans + (double)(m)/(double)(denom);
            
            if(possAnswer*possAnswer <= x){
                answer = possAnswer;
                s = m + 1;
            }
            else{
                e = m - 1;
            }
        }
        denom *= 10;
        precision++;
    }

    return answer;
}

int main(){

    cout << "Enter the number : " << endl;
    double x;
    cin >> x;

    cout << "Enter precision : " << endl;
    int p;
    cin >> p;

    if(x < 0 || p < 0){
        cout << "Negative numbers are not allowed" << endl;
        return 0;
    }

    cout << "Answer with method 1 : " << endl;
    double answer = sqrtWithPrecision(x,p);
    cout << fixed << setprecision(p) << answer << endl;

    cout << "Answer with method 2 : " << endl;
    answer = sqrtWithPrecision2(x,p);
    cout << fixed << setprecision(p) << answer << endl;
    
    return 0;
}