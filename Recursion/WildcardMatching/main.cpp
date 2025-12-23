/*
Problem : Wildcard Matching (LC 44)
*/

#include <iostream>
using namespace std;

bool isMatchHelper(string& s, int sIndex, string& p, int pIndex){
    // Base Case for match
    if(sIndex >= s.size() && pIndex >= p.size()) return true;

    // Base Case for not match
    if(pIndex >= p.size()) return false;

    // match one char of s
    if((sIndex < s.size()) && (p[pIndex] == '?') || s[sIndex] == p[pIndex]) return isMatchHelper(s,sIndex+1, p, pIndex+1);
    else if(p[pIndex] == '*'){
        // match empty char by *
        bool matchEmptyChar = isMatchHelper(s,sIndex,p,pIndex+1);

        // match a char and only match when sindex is valid
        bool matchChar = (sIndex < s.size()) ? isMatchHelper(s,sIndex+1, p, pIndex): false;

        return matchEmptyChar || matchChar;
    }
    else return false;
}

bool isMatch(string s, string p) {
    return isMatchHelper(s,0,p,0);
}

int main(){

    cout << isMatch("aa","a*") << endl;
    return 0;
}