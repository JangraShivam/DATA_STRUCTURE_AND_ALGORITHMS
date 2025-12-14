/*
Problem : get fibonacci nth term
*/

#include <iostream>
using namespace std;

int getFibonacci(int n){
    if(n <= 2) return 1;

    return getFibonacci(n-1) + getFibonacci(n-2);
}

int main(){

    cout << "Enter N : " ;
    int n;
    cin >> n;

    cout << getFibonacci(n) << endl;

    return 0;
}