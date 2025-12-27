/*
Problem : Rat in a maze Problem (GFG)
*/

#include <iostream>
#include <vector>
using namespace std;

void findPaths(vector<vector<int>>& maze, int currentRow, int currentCol, vector<string>& allPaths, string& currentPath){
    // Base case or Rat reached the destination
    if(currentRow == maze.size()-1 && currentCol == maze.size()-1){
        allPaths.push_back(currentPath); 
        return;
    }
    
    // mark visited on current cell
    maze[currentRow][currentCol] = 2;
        
    // go down if it is valid and possible
    if(currentRow + 1 < maze.size() && maze[currentRow+1][currentCol] == 1){
        currentPath.push_back('D');
        findPaths(maze,currentRow+1,currentCol,allPaths,currentPath);
        currentPath.pop_back(); // backtrack
    }
    
    // go left if it is valid and possible
    if(currentCol - 1 >= 0 && maze[currentRow][currentCol-1] == 1){
        currentPath.push_back('L');
        findPaths(maze,currentRow,currentCol-1,allPaths,currentPath);
        currentPath.pop_back(); // backtrack
    }

    // go down if it is valid and possible
    if(currentCol + 1 < maze.size() && maze[currentRow][currentCol+1] == 1){
        currentPath.push_back('R');
        findPaths(maze,currentRow,currentCol+1,allPaths,currentPath);
        currentPath.pop_back(); // backtrack
    }

    // go down if it is valid and possible
    if(currentRow - 1 >= 0 && maze[currentRow-1][currentCol] == 1){
        currentPath.push_back('U');
        findPaths(maze,currentRow-1,currentCol,allPaths,currentPath);
        currentPath.pop_back(); // backtrack
    }
       
    // mark unvisited current cell or backtrack
    maze[currentRow][currentCol] = 1;
        
}

vector<string> ratInMaze(vector<vector<int>>& maze) {
    if(maze[0][0] == 0) return {};
    vector<string> allPaths;
    string currentPath = "";
    findPaths(maze,0,0,allPaths,currentPath);
      
    return allPaths;
}

int main(){

    vector<vector<int>> maze = {{1,0,0,0},
                                {1,1,0,1},
                                {1,1,0,0},
                                {0,1,1,1}};

    vector<string> paths = ratInMaze(maze);

    for(string path: paths){
        cout << path << endl;
    }
    return 0;
}