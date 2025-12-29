/*
Problem : Word Search (LC - 79)
*/

#include <iostream>
#include <vector>
using namespace std;


bool existHelper(vector<vector<char>>& board, string& word, int row, int col, int index){
    // Base case or word found
    if(index >= word.size()) return true;

    // Out of range base case
    if(row < 0 || row >= board.size() || col < 0 || col >= board[0].size()) return false;

    // if current char matched word char or cant go to visited cells
    if(board[row][col] != word[index] || board[row][col] == '0') return false;

    // mark visited
    char ch = board[row][col];
    board[row][col] = '0';

    // recursive call for up,down,left,right
    bool right = existHelper(board,word,row,col+1,index+1);
    bool left = existHelper(board,word,row,col-1,index+1);
    bool down = existHelper(board,word,row+1,col,index+1);
    bool up = existHelper(board,word,row-1,col,index+1);

    // backtrack
    board[row][col] = ch;
    return right || left || down || up;
}  

bool exist(vector<vector<char>>& board, string word) {
    
    // try to form word from every cell
    for(int i = 0; i < board.size(); i++){
        for(int j = 0; j < board[0].size(); j++){
            bool found = existHelper(board,word,i,j,0);
            if(found) return true;
        }
    }
    return false;
}

int main(){

    vector<vector<char>> board =  {{'A','B','C','E'},
                                    {'S','F','C','S'},
                                    {'A','D','E','E'}};

    string word = "ABCCED";

    if(exist(board,word)){
        cout << "Word found" << endl;
    }
    else{
        cout << "Word not found" << endl;
    }

    return 0;
}