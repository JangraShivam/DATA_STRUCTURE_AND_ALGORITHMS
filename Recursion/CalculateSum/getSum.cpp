/*
Problem : Calculate Sum of values from 1 to n
*/

#include <iostream>
using namespace std;

int getSum(int n){
    if(n <= 0) return 0;

    int recursionAns = getSum(n-1);
    return n + recursionAns;
}

int main(){

    cout << "Enter N : " ;
    int n;
    cin >> n;

    cout << "Sum : " << getSum(n) << endl;

    return 0;
}