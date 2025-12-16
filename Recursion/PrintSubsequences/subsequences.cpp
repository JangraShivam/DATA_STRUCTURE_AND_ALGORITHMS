/*
Problem : Print all subsequences of a string
*/

#include <iostream>
#include <vector>
using namespace std;

void getSubsequences(string& input, int index, string subseq, vector<string>& allSubsequences){
    // Base Case
    if(index >= input.size()){
        allSubsequences.push_back(subseq);
        return;
    }

    // exclude current char
    getSubsequences(input,index+1,subseq,allSubsequences);

    // include current char
    subseq.push_back(input[index]);
    getSubsequences(input,index+1,subseq,allSubsequences);
}

int main(){

    string input = "abc";
    vector<string> allSubsequences;

    getSubsequences(input,0,"",allSubsequences);

    cout << "Total subsequences : " << allSubsequences.size() << endl;

    for(int i = 0; i < allSubsequences.size(); i++){
        cout << i+1 << " subsequence : " << allSubsequences[i] << endl;
    }

    return 0;
}