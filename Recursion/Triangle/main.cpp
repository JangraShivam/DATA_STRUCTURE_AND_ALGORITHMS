/*
Problem : Triangle (LeetCode - 120)
*/

#include <iostream>
#include <vector>
using namespace std;


int getMinimumTotal(vector<vector<int>>& triangle, int row, int index){
    // Base Case
    if(row >= triangle.size()) return 0;

    // Move to adjacent left 
    int adjacentLeft = triangle[row][index] + getMinimumTotal(triangle,row+1,index);

    // Move to adjacent right 
    int adjacentRight = triangle[row][index] + getMinimumTotal(triangle,row+1,index+1);

    return min(adjacentLeft,adjacentRight);
}

int minimumTotal(vector<vector<int>>& triangle) {
    return getMinimumTotal(triangle,0,0);
}

int main(){

    vector<vector<int>> triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};

    cout << "Minimum total : " << minimumTotal(triangle) << endl;
    return 0;
}