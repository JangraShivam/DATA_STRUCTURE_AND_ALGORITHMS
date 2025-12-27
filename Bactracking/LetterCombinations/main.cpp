/*
Problem : Letter Combinations of a Phone Number (LC - 17)
*/

#include <unordered_map>
#include <iostream>
#include <vector>
using namespace std;

void getletterCombinations(string& digits, int index, string& currentCombination, vector<string>& combinations, unordered_map<char,string>& numToChar){
    // Base Case
    if(index >= digits.size()){
        combinations.push_back(currentCombination);
        return;
    }

    // try all values at particular digit
    for(char ch : numToChar[digits[index]]){
        currentCombination.push_back(ch);
        getletterCombinations(digits,index+1,currentCombination,combinations,numToChar);
        currentCombination.pop_back(); // backTrack
    }
}

vector<string> letterCombinations(string digits) {
    unordered_map<char,string> numToChar;
    vector<string> combinations;
    numToChar['2'] = "abc";
    numToChar['3'] = "def";
    numToChar['4'] = "ghi";
    numToChar['5'] = "jkl";
    numToChar['6'] = "mno";
    numToChar['7'] = "pqrs";
    numToChar['8'] = "tuv";
    numToChar['9'] = "wxyz";
    string currentCombination = "";
    getletterCombinations(digits,0,currentCombination,combinations,numToChar);
    return combinations;
} 

int main(){

    vector<string> ans = letterCombinations("23");
    for(string str: ans) cout << str << endl;

    return 0;
}