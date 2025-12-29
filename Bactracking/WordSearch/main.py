"""
Problem : Word Search (LC - 79)
"""

from typing import List


def existHelper(board: List[List[str]], word: str, row: int, col: int, index: int) -> bool :
    # Base case or word found
    if(index >= len(word)) :
        return True

    # Out of range base case
    if(row < 0 or row >= len(board) or col < 0 or col >= len(board[0])) :
        return False

    # if current char matched word char or cant go to visited cells
    if(board[row][col] != word[index] or board[row][col] == '0') :
        return False

    # mark visited
    ch = board[row][col]
    board[row][col] = '0'

    # recursive call for up,down,left,right
    right = existHelper(board,word,row,col+1,index+1)
    left = existHelper(board,word,row,col-1,index+1)
    down = existHelper(board,word,row+1,col,index+1)
    up = existHelper(board,word,row-1,col,index+1)

    # backtrack
    board[row][col] = ch
    return right or left or down or up


def exist(board: List[List[str]], word: str) -> bool:
    # try to form word from every cell
    for i in range(0,len(board)):
        for j in range(0,len(board[0])) :
            found = existHelper(board,word,i,j,0)
            if(found) : return True
    
    return False


# main

board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
word = "ABCCED"

if exist(board,word):
    print("Word found")
else :
    print("Word not found")