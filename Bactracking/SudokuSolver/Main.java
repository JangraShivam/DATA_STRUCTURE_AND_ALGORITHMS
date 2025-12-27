/*
Problem : Sudoku Solver (LC - 37)
*/

public class Main {
    
    // Check if it the value is valid to be in specific position
    public static boolean isValid(char[][] board, int row, int col, char val){
        // check row and col
        for(int i = 0; i < 9; i++){
            if(board[row][i] == val || board[i][col] == val) return false;
        }

        // detremine subcell and check valid
        int subcellRow = (row/3)*3;
        int subcellCol = (col/3)*3;
        for(int i = subcellRow; i < subcellRow + 3; i++){
            for(int j = subcellCol; j < subcellCol + 3; j++){
                if(board[i][j] == val) return false;
            }
        }

        return true;
    }

    public static boolean solve(char[][] board, int row, int col){
        // Base Case or Sudoku solved
        if(row >= 9) return true;

        // update row
        if(col >= 9){
            return solve(board,row+1,0);
        }

        // check if we can fill the postion
        if(board[row][col] != '.'){
            return solve(board,row,col+1);
        }
        else{
            // try to fill all the possible values
            for(char ch = '1'; ch <= '9'; ch++){
                if(isValid(board,row,col,ch)){
                    board[row][col] = ch;
                    boolean isSolved = solve(board,row,col+1);
                    if(!isSolved) board[row][col] = '.'; // backtrack
                    else return isSolved;
                }
            }
        }

        return false;
    }
    public static void solveSudoku(char[][] board) {
        boolean isSolved = solve(board,0,0);

        if(isSolved){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Can't solve");
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
    
        solveSudoku(board);
    }
}
