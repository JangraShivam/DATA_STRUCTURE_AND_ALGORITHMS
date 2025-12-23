/*
Problem : Remove All Occurrences of a Substring (LeetCode - 1910)
*/

#include <iostream>
using namespace std;

void removeOccurrencesHelper(string& s, int index, string& part, string& ans){
    //Base case
    if(index >= s.size()) return;

    // Push current char into ans
    ans.push_back(s[index]);

    int partIndex = part.size()-1;
    int ansIndex = ans.size()-1;

    // Match part in ans string
    while(partIndex >= 0 && ansIndex >= 0){
        if(part[partIndex] != ans[ansIndex]) break;
        partIndex--;
        ansIndex--;
    }

    // If partIndex < 0 then match found and remove it
    if(partIndex < 0){
        // ans was equal to part fully so empty it
        if(ansIndex < 0) ans = "";
        else ans = ans.substr(0,ansIndex+1); // remove part from end
    }

    removeOccurrencesHelper(s,index+1,part,ans);
}

string removeOccurrences(string s, string part) {
    string ans = "";
    removeOccurrencesHelper(s,0,part,ans);
    return ans;
}

int main(){


    string s = "daabcbaabcbc";
    string part = "abc";

    cout << removeOccurrences(s,part) << endl;

    return 0;
}