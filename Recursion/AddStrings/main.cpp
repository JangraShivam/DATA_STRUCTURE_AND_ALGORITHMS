/*
Problem : Add Strings (Leetcode - 415)
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void add(string& num1, int num1Index, string& num2, int num2Index, string& ans, int carry){
    // Base Case
    if(num1Index < 0 && num2Index < 0){
        // Push Carry if not equal to 0
        if(carry != 0) ans.push_back('1');
        return;
    }

    // get num1 current digit
    int num1Digit = (num1Index >= 0) ? (num1[num1Index] - '0') : 0;

    // get num2 current digit
    int num2Digit = (num2Index >= 0) ? (num2[num2Index] - '0') : 0;

    // Calculate Sum
    int sum = num1Digit + num2Digit + carry;
    carry = sum/10;
    int digit = sum%10;

    // Push digit
    ans.push_back((digit +'0'));
    add(num1,num1Index-1,num2,num2Index-1,ans,carry);
}

string addStrings(string num1, string num2) {
    // Intialize an empty string
    string ans = "";
    add(num1,num1.size()-1, num2, num2.size()-1, ans, 0);
    reverse(ans.begin(),ans.end());
    return ans;
}


int main(){

    string num1 = "123";
    string num2 = "23";

    cout << "Sum : " << addStrings(num1, num2) << endl;
    return 0;
}