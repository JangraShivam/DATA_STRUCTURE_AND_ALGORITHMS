"""
Problem : Rat in a maze Problem (GFG)
"""

def findPaths(maze: list[list[int]], currentRow: int, currentCol: int, allPaths: list[str], currentPath: list[str]) :
    # Base case or Rat reached the destination
    if(currentRow == len(maze)-1 and currentCol == len(maze)-1) :
        allPaths.append("".join(currentPath)) 
        return
    
    # mark visited on current cell
    maze[currentRow][currentCol] = 2
        
    # go down if it is valid and possible
    if(currentRow + 1 < len(maze) and maze[currentRow+1][currentCol] == 1) :
        currentPath.append('D')
        findPaths(maze,currentRow+1,currentCol,allPaths,currentPath)
        currentPath.pop() # backtrack
    
    
    # go left if it is valid and possible
    if(currentCol - 1 >= 0 and maze[currentRow][currentCol-1] == 1):
        currentPath.append('L')
        findPaths(maze,currentRow,currentCol-1,allPaths,currentPath)
        currentPath.pop() # backtrack
    

    # go down if it is valid and possible
    if(currentCol + 1 < len(maze) and maze[currentRow][currentCol+1] == 1) :
        currentPath.append('R')
        findPaths(maze,currentRow,currentCol+1,allPaths,currentPath)
        currentPath.pop() # backtrack
    

    # go down if it is valid and possible
    if(currentRow - 1 >= 0 and maze[currentRow-1][currentCol] == 1) :
        currentPath.append('U')
        findPaths(maze,currentRow-1,currentCol,allPaths,currentPath)
        currentPath.pop() # backtrack
       
    # mark unvisited current cell or backtrack
    maze[currentRow][currentCol] = 1
        

def ratInMaze(maze: list[list[int]]) -> list[str] :
    if(maze[0][0] == 0) :
        return []
    
    allPaths = []
    currentPath = []
    findPaths(maze,0,0,allPaths,currentPath)
      
    return allPaths



maze = [[1,0,0,0],
        [1,1,0,1],
        [1,1,0,0],
        [0,1,1,1]]

paths = ratInMaze(maze)
print(paths)