"""
Problem : N-Queens (LC - 51)
"""

# To check if it is safe to place queen 
def isSafe(answer: list[list[str]], queenRow: int, queenCol: int) -> bool :
    # check above if their is a queen or not
    row = queenRow
    col = queenCol
    while(row >= 0) :
        if(answer[row][col] == 'Q') :
            return False
        row-=1

    # check top left diagonal 
    row = queenRow
    col = queenCol
    while(row >= 0 and col >= 0) :
        if(answer[row][col] == 'Q') :
            return False
        row-=1
        col-=1

    # check top right diagonal
    row = queenRow
    col = queenCol
    while(row >= 0 and col < len(answer)) :
        if(answer[row][col] == 'Q') :
            return False
        row-=1
        col+=1

    return True


def getPossiblePositions(n: int,queen: int,currentPositions: list[list[str]],allPossiblePositions: list[int]) :
    # Base Case or all queens have been safely placed
    if(n == queen-1) :
        allPossiblePositions[0]+=1
        return

    # Place current queen in all position in her row
    for i in range (0, n) :
        # check if it is safe to place queen
        if isSafe(currentPositions,queen-1,i) :
            currentPositions[queen-1][i] = 'Q'
            getPossiblePositions(n,queen+1,currentPositions,allPossiblePositions)
            currentPositions[queen-1][i] ='.' # backtrack


def solveNQueens(n: int) -> list[list[str]]:
    allPossiblePositions = [0]

   # Intialize board state
    temp = []
    for i in range (0, n):
        temp.append('.')
    
    currentPositions = []
    for i in range (0, n):
        currentPositions.append(temp[:])

    getPossiblePositions(n,1,currentPositions,allPossiblePositions)
    return allPossiblePositions[0]

answer = solveNQueens(4)
print(answer)
