/*
Problem : Check if a string is palindrome or not
*/

#include <iostream>
using namespace std;

bool isPalindrome(string& input, int start, int end){
    // Base Case
    if(start >= end) return true;

    // Another base case
    if(input[start] != input[end]) return false;

    return isPalindrome(input, start+1, end-1);
}

int main(){

    string input = "abaa";
    cout << "Palindrome ? " << isPalindrome(input,0,input.size()-1) << endl;

    return 0;
}