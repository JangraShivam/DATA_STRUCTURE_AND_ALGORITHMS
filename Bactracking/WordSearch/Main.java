/*
Problem : Word Search (LC - 79)
*/

public class Main {

    public static boolean existHelper(char[][] board, String word, int row, int col, int index){
        // Base case or word found
        if(index >= word.length()) return true;

        // Out of range base case
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;

        // if current char matched word char or cant go to visited cells
        if(board[row][col] != word.charAt(index) || board[row][col] == '0') return false;

        // mark visited
        char ch = board[row][col];
        board[row][col] = '0';

        // recursive call for up,down,left,right
        boolean right = existHelper(board,word,row,col+1,index+1);
        boolean left = existHelper(board,word,row,col-1,index+1);
        boolean down = existHelper(board,word,row+1,col,index+1);
        boolean up = existHelper(board,word,row-1,col,index+1);

        // backtrack
        board[row][col] = ch;
        return right || left || down || up;
    }  

    public static boolean exist(char[][] board, String word) {
        // try to form word from every cell
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean found = existHelper(board,word,i,j,0);
                if(found) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board =  {{'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}};

        String word = "ABCCED";

        if(exist(board,word)){
            System.out.println("Word Found");
        }
        else{
            System.out.println("Word not found");
        }
    }
}
