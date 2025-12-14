/*
Problem : Print Counting from 1 to N. and in reverse N to 1
*/

#include <iostream>
using namespace std;

void print(int n){
    //Base Case
    if(n <= 0) return;

    // Recusrsive Call or Head recursion
    print(n-1);

    cout << n << " ";
}

void printReverse(int n){
    //Base Case
    if(n <= 0) return;

    cout << n << " ";

    // Tail Recursion
    printReverse(n-1);
}

int main(){

    cout << "Enter N : " ;
    int n;
    cin >> n;

    cout << "Normal Print : ";
    print(n);
    cout << endl;

    cout << "Reverse Print : ";
    printReverse(n);
    cout << endl;

    return 0;
}