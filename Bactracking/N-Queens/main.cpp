/*
Problem : N-Queens (LC - 51)
*/

#include <iostream>
#include <vector>
using namespace std;

// To check if it is safe to place queen 
bool isSafe(vector<string>& answer, int queenRow, int queenCol){
    // check above if their is a queen or not
    int row = queenRow;
    int col = queenCol;
    while(row >= 0){
        if(answer[row][col] == 'Q') return false;
        row--;
    }

    // check top left diagonal 
    row = queenRow;
    col = queenCol;
    while(row >= 0 && col >= 0){
        if(answer[row][col] == 'Q') return false;
        row--;
        col--;
    }

    // check top right diagonal
    row = queenRow;
    col = queenCol;
    while(row >= 0 && col < answer.size()){
        if(answer[row][col] == 'Q') return false;
        row--;
        col++;
    }

    return true;
}

void getPossiblePositions(int& n, int queen, vector<string>& currentPositions, vector<vector<string>>& allPossiblePositions){
    // Base Case or all queens have been safely placed
    if(n == queen-1){
        allPossiblePositions.push_back(currentPositions);
        return;
    }

    // Place current queen in all position in her row
    for(int i = 0; i < n; i++){
        // check if it is safe to place queen
        if(isSafe(currentPositions,queen-1,i)){
            currentPositions[queen-1][i] = 'Q';
            getPossiblePositions(n,queen+1,currentPositions,allPossiblePositions);
            currentPositions[queen-1][i] ='.'; // backtrack
        }
    }
}

vector<vector<string>> solveNQueens(int n) {

    vector<vector<string>> allPossiblePositions;

    // Intialize board state
    string temp;
    for(int i = 0; i < n; i++) temp.push_back('.');
    vector<string> currentPositions(n,temp);

    getPossiblePositions(n,1,currentPositions,allPossiblePositions);
    return allPossiblePositions;

}

int main(){

    vector<vector<string>> answer = solveNQueens(4);

    for(int i = 0; i < answer.size(); i++){
        for(int j = 0; j < answer[0].size(); j++){
            cout << answer[i][j] << endl;
        }
        cout << endl;
    }


    return 0;
}