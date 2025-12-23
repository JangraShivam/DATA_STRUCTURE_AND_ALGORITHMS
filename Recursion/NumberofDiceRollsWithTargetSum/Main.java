/*
Problem : Number of Dice Rolls With Target Sum (LC 1155)
*/

public class Main{

    public static int numRollsToTarget(int n, int k, int target) {
        // Base Case or no dice left to roll
        if(n == 0){
            // Target matched
            if (target == 0) return 1;
            else return 0; // target sum not matched
        }

        int ans = 0;
        // Simulate all the values of dice
        for(int i = 1; i <= k; i++){
            ans = ans + numRollsToTarget(n-1,k,target - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numRollsToTarget(3, 5, 6));
    }
}