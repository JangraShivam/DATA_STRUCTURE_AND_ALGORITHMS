"""
Problem : Sudoku Solver (LC - 37)
"""

from typing import List

def solve(board: List[List[str]], row: int, col: int, rowStatus: List[set[str]], colsStatus: List[set[str]], subCellsStatus: List[set[str]]) -> bool :
    # Base Case or Sudoku solved
    if(row >= 9) :
        return True

    # update row
    if(col >= 9):
        return solve(board,row+1,0,rowStatus,colsStatus,subCellsStatus)
    

    # check if we can fill the postion
    if(board[row][col] != '.') :
        return solve(board,row,col+1,rowStatus,colsStatus,subCellsStatus)
    else :
        # try to fill all the possible values
        subcell = ((row//3)*3)+(col//3)
        for ch in (rowStatus[row] & colsStatus[col] & subCellsStatus[subcell]):
            board[row][col] = ch
            rowStatus[row].remove(ch)
            colsStatus[col].remove(ch)
            subCellsStatus[subcell].remove(ch)

            isSolved = solve(board,row, col+1, rowStatus, colsStatus, subCellsStatus)

            if isSolved: return True
            else:
                board[row][col] = '.'
                rowStatus[row].add(ch)
                colsStatus[col].add(ch)
                subCellsStatus[subcell].add(ch)

            
    return False

def solveSudoku(board: List[List[str]]) -> None:
    rowsStatus = [set("123456789") for _ in range(9)]
    colsStatus = [set("123456789") for _ in range(9)]
    subCellsStatus = [set("123456789") for _ in range(9)]
    
    for i in range(9):
        for j in range(9):
            if board[i][j] != '.':
                rowsStatus[i].remove(board[i][j])
                colsStatus[j].remove(board[i][j])
                subCellsStatus[((i//3)*3)+(j//3)].remove(board[i][j])


    isSolved = solve(board,0,0,rowsStatus,colsStatus,subCellsStatus)

    if(isSolved) :
         for i in range(0,9):
             print(board[i])
    else :
        print("Can't sove")    



# main program
board = [["5","3",".",".","7",".",".",".","."],
         ["6",".",".","1","9","5",".",".","."],
         [".","9","8",".",".",".",".","6","."],
         ["8",".",".",".","6",".",".",".","3"],
         ["4",".",".","8",".","3",".",".","1"],
         ["7",".",".",".","2",".",".",".","6"],
         [".","6",".",".",".",".","2","8","."],
         [".",".",".","4","1","9",".",".","5"],
         [".",".",".",".","8",".",".","7","9"]]
    
solveSudoku(board)




