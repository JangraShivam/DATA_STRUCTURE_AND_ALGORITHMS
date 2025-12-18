/*
Problem : Minimize the Difference Between Target and Chosen Elements (LC - 1981)
*/

#include <iostream>
#include <vector>
using namespace std;

int minimize(vector<vector<int>>& mat, int target, int row){
    // return the absolute difference
    if(row >= mat.size()){
        return abs(target);
    }

    // Intialize min dff
    int minDiff = INT32_MAX;

    // Iterate on current row for minimum diff
    for(int col = 0; col < mat[row].size(); col++){
        minDiff = min(minDiff,minimize(mat,target-mat[row][col], row+1));
    }

    return minDiff;
}

int minimizeTheDifference(vector<vector<int>>& mat, int target) {
    return minimize(mat,target, 0);
}

int main(){

    vector<vector<int>> mat = {{1,2,3},
                                {4,5,6},
                                {7,8,9}};

    int target = 13;
    
    cout << "Minimum difference : " << minimizeTheDifference(mat,target) << endl;
    return 0;
}