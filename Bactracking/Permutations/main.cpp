/*
Problem : Permutations (LC - 46)
*/

#include <iostream>
#include <vector>
using namespace std;

void getPossiblePermuatations(vector<int>& currentPermuatation, int index, vector<vector<int>>& allPermutations){
    // Base Case 
    if(index >= currentPermuatation.size()){
        allPermutations.push_back(currentPermuatation);
        return;
    }

    // Permutation Logic
    for(int j = index; j < currentPermuatation.size(); j++){
        swap(currentPermuatation[index],currentPermuatation[j]);
        getPossiblePermuatations(currentPermuatation,index+1,allPermutations);
        swap(currentPermuatation[index],currentPermuatation[j]); // backtrack
    }
}


vector<vector<int>> permute(vector<int>& nums) {
    vector<vector<int>> allPermutations;
    getPossiblePermuatations(nums,0,allPermutations);
    return allPermutations;
}

int main(){

    vector<int> nums = {1,2,3};
    vector<vector<int>> answer = permute(nums);

    for(int i = 0; i < answer.size(); i++){
        for(int j = 0; j < answer[0].size(); j++){
            cout << answer[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}