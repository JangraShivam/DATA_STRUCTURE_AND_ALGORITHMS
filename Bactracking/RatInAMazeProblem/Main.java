/*
Problem : Rat in a maze Problem (GFG)
*/

import java.util.ArrayList;

public class Main{

    public static void findPaths(int[][] maze, int currentRow, int currentCol, ArrayList<String> allPaths, StringBuilder currentPath){
        // Base case or Rat reached the destination
        if(currentRow == maze.length-1 && currentCol == maze.length-1){
            allPaths.add(currentPath.toString());
            return;
        }
        
        // mark visited on current cell
        maze[currentRow][currentCol] = 2;
            
        // go down if it is valid and possible
        if(currentRow + 1 < maze.length && maze[currentRow+1][currentCol] == 1){
            currentPath.append('D');
            findPaths(maze,currentRow+1,currentCol,allPaths,currentPath);
            currentPath.deleteCharAt(currentPath.length()-1); // backtrack
        }
        
        // go left if it is valid and possible
        if(currentCol - 1 >= 0 && maze[currentRow][currentCol-1] == 1){
            currentPath.append('L');
            findPaths(maze,currentRow,currentCol-1,allPaths,currentPath);
            currentPath.deleteCharAt(currentPath.length()-1); // backtrack
        }

        // go down if it is valid and possible
        if(currentCol + 1 < maze.length && maze[currentRow][currentCol+1] == 1){
            currentPath.append('R');
            findPaths(maze,currentRow,currentCol+1,allPaths,currentPath);
            currentPath.deleteCharAt(currentPath.length()-1);// backtrack
        }

        // go down if it is valid and possible
        if(currentRow - 1 >= 0 && maze[currentRow-1][currentCol] == 1){
            currentPath.append('U');
            findPaths(maze,currentRow-1,currentCol,allPaths,currentPath);
            currentPath.deleteCharAt(currentPath.length()-1); // backtrack
        }
        
        // mark unvisited current cell or backtrack
        maze[currentRow][currentCol] = 1;
            
    }

    public static ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> allPaths = new ArrayList<>();
        if(maze[0][0] == 0) return allPaths;
        StringBuilder currentPath = new StringBuilder("");
        findPaths(maze,0,0,allPaths,currentPath);
        
        return allPaths;
    }

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},
                        {1,1,0,1},
                        {1,1,0,0},
                        {0,1,1,1}};

        ArrayList<String> paths = ratInMaze(maze);

        for(String path: paths){
            System.out.println(path);
        }
    }

}