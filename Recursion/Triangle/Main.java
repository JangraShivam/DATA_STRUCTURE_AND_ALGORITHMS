/*
Problem : Triangle (LeetCode - 120)
*/

import java.util.List;

public class Main{

    public static int getMinimumTotal(List<List<Integer>> triangle, int row, int index){
        // Base Case
        if(row >= triangle.size()) return 0;

        // Move to adjacent left 
        int adjacentLeft = triangle.get(row).get(index) + getMinimumTotal(triangle,row+1,index);

        // Move to adjacent right 
        int adjacentRight = triangle.get(row).get(index) + getMinimumTotal(triangle,row+1,index+1);

        return Math.min(adjacentLeft,adjacentRight);
    }

    public static int minimumTotal(List<List<Integer>>  triangle) {
        return getMinimumTotal(triangle,0,0);
    }

    public static void main(String[] args) {
        List<List<Integer>>  triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6,5,7),
            List.of(4,1,8,3)
        );
    
        System.out.println("minimumTotal : " + minimumTotal(triangle));
    }


}