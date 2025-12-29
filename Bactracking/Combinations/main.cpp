/*
Problem : Combinations (LC - 77)
*/

#include <iostream>
#include <vector>
using namespace std;

void getCombinations(int n, int k, vector<int>& currentCombination, vector<vector<int>>& allCombinations){
    // Base Case 
    if(k == 0){
        allCombinations.push_back(currentCombination);
        return;
    }

    // combination logic
    for(int i = n; i > 0; i--){
        currentCombination.push_back(i);
        getCombinations(i-1,k-1,currentCombination,allCombinations);
        currentCombination.pop_back();
    }
}

vector<vector<int>> combine(int n, int k) {
    vector<vector<int>> allCombinations ;
    vector<int> currentCombination;
    getCombinations(n,k,currentCombination,allCombinations);
    return allCombinations;
}

int main(){
    vector<vector<int>> ans = combine(4,2);

    for(auto it : ans){
        for(int i : it){
            cout << i << " " ;
        }
        cout << endl;
    }

    return 0;
}