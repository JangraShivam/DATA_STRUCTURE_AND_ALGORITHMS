/*
Problem : For a given n, return its factorial using recursion
Ex: n = 5, return 5! = 120

*/

#include <iostream>
using namespace std;

int getFactorial(int n){
    //Base Case
    if(n <= 1) return 1;

    // Get Recursion Answer
    int recursionAns = getFactorial(n-1);

    // return answer 
    return n * recursionAns;
}

int main(){

    cout << "Enter n : ";
    int n; 
    cin >> n;

    cout << "Factorial of " << n << " is : " << getFactorial(n) << endl;

    return 0;
}