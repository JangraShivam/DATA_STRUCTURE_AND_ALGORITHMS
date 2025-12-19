/*
Problem : Reverse a string
*/

#include <iostream>
using namespace std;

void reverse(string& input, int start, int end){
    if(start >= end) return;

    swap(input[start],input[end]);

    reverse(input,start+1,end-1);
}

int main(){

    string input = "abcdef";

    reverse(input,0,input.size()-1);
    cout << input << endl;

    return 0;
}