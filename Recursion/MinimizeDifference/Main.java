/*
Problem : Minimize the Difference Between Target and Chosen Elements (LC - 1981)
*/

public class Main{

    public static int minimize(int[][] mat, int target, int row){
        // return the absolute difference
        if(row >= mat.length){
            return Math.abs(target);
        }

        // Intialize min dff
        int minDiff = Integer.MAX_VALUE;

        // Iterate on current row for minimum diff
        for(int col = 0; col < mat[row].length; col++){
            minDiff = Math.min(minDiff,minimize(mat,target-mat[row][col], row+1));
        }

        return minDiff;
    }

    public static int minimizeTheDifference(int[][] mat, int target) {
        return minimize(mat,target, 0);
    }
    public static void main(String[] args){
        int[][] mat = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

        int target = 13;

        System.out.println("Minimum Difference : "+minimizeTheDifference(mat, target));
    }
}