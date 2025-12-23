/*
Problem : Perfect Squares (LC 279)
*/

public class Main{

    public static int numSquares(int n) {
        // Base Case
        if(n <= 0) return 0;

        // Intialize Minimum answer
        int minAns = Integer.MAX_VALUE;

        // Try different perfect sqaures less than n
        for(int i = 1; i*i <= n; i++){
            int ans = 1 + numSquares(n - (i*i));
            minAns = Math.min(minAns,ans); // update minAns
        }

        return minAns;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}