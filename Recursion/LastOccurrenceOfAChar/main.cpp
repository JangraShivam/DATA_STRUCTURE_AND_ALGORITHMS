/*
Problem : Given an input string and target character, find the last occurence of target char
*/

#include <iostream>
#include <vector>
using namespace std;

// Method 1 : Search from left to right
void findLTR(string& input, char& target, int index, int& ans){
    // Target char is not in the string return -1
    if(index >= input.size()) return;

    // Target char found and store and update ans
    if(input[index] == target) ans = index;
    
    // Look for further occurence of target char
    findLTR(input,target,index+1,ans);
}

// Method 2 : Search from right to left
int findRTL(string& input, char& target, int index){
    // Target char is not in the string return -1
    if(index < 0) return -1;

    // Target char found and return it because it is the last occurence
    if(input[index] == target) return index;

    return findRTL(input,target,index-1);
}

int main(){

    string input = "aabsbsbfbg";
    char target = 'b';
    int ans = -1;
    findLTR(input,target,0,ans);
    cout << "LTR : " << ans << endl;
    cout << "RTL : " << findRTL(input,target,input.size()-1) << endl;
    
    return 0;
}