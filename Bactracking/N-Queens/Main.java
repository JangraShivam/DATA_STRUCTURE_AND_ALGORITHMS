/*
Problem : N-Queens (LC - 51)
*/

import java.util.ArrayList;
import java.util.List;
public class Main {

    // To check if it is safe to place queen 
    public static boolean isSafe(List<StringBuilder> currentPositions, int queenRow, int queenCol){
        // check above if their is a queen or not
        int row = queenRow;
        int col = queenCol;
        while(row >= 0){
            if(currentPositions.get(row).charAt(col) == 'Q') return false;
            row--;
        }

        // check top left diagonal 
        row = queenRow;
        col = queenCol;
        while(row >= 0 && col >= 0){
            if(currentPositions.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        // check top right diagonal
        row = queenRow;
        col = queenCol;
        while(row >= 0 && col < currentPositions.size()){
            if(currentPositions.get(row).charAt(col) == 'Q') return false;
            row--;
            col++;
        }

        return true;
    }

    public static void getPossiblePositions(int n, int queen, List<StringBuilder> currentPositions, List<List<String>> allPossiblePositions){
        // Base Case or all queens have been safely placed
        if(n == queen-1){
            List<String> positions = new ArrayList<>();
            for(StringBuilder str: currentPositions){
                positions.add(str.toString());
            }
            allPossiblePositions.add(positions);
            return;
        }
        
        // Place current queen in all position in her row
        for(int i = 0; i < n; i++){
            // check if it is safe to place queen
            if(isSafe(currentPositions,queen-1,i)){
                currentPositions.get(queen-1).setCharAt(i, 'Q');
                getPossiblePositions(n,queen+1,currentPositions,allPossiblePositions);
                currentPositions.get(queen-1).setCharAt(i, '.');; // backtrack
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allPossiblePositions = new ArrayList<>();

        // Intialize board state
        List<StringBuilder> currentPositions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            currentPositions.add(row);
        }

        getPossiblePositions(n,1,currentPositions,allPossiblePositions);
        return allPossiblePositions;
    }

    public static void main(String[] args) {
        List<List<String>> answer = solveNQueens(4);
        
        for(int i = 0; i < answer.size(); i++){
            for(int j = 0; j < answer.get(0).size(); j++){
                System.out.println(answer.get(i).get(j));
            }
            System.out.println();
        }
    }
}
