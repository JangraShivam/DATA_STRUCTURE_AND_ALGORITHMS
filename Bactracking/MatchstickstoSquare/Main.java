/*
Problem : Matchsticks to Square (LC - 473)
*/

import java.util.Arrays;

public class Main {

    public static boolean makeSquareHelper(int[] matchsticks, int index, int[] sidesLength){
        // Base Case
        if(index >= matchsticks.length){
            return (sidesLength[0] == sidesLength[1]) == (sidesLength[2] == sidesLength[3]);
        }
            
        // Try to add current matchsticks to all 4 sides
        for(int i = 0; i < 4; i++){
            // the side should not exceed 
            if(sidesLength[i] - matchsticks[index] >= 0){
                sidesLength[i] -= matchsticks[index];
                if(makeSquareHelper(matchsticks,index+1,sidesLength)) return true;
                else{
                    sidesLength[i] += matchsticks[index]; // backtrack
                }
            }
        }

        return false;
    }

    public static boolean makesquare(int[] matchsticks) {
        // get total length sum
        int sum = 0;
        for(int i : matchsticks) sum += i;
        // check if sum can be divided into 4 parts
        if(sum%4 != 0) return false;

        // intialize sides with their expected length
        int[] sidesLength = {sum/4,sum/4,sum/4,sum/4};

        // sort in decrease order to reduce recursive calls
        Arrays.sort(matchsticks);
        int start = 0;
        int end = matchsticks.length - 1;
        while(start < end){
            int temp = matchsticks[start];
            matchsticks[start] = matchsticks[end];
            matchsticks[end] = temp;
            start++;
            end--;
        }
        return makeSquareHelper(matchsticks,0,sidesLength);
    }
    public static void main(String[] args) {
        int[] matchsticks = {1,1,2,2,2};
        System.out.println(makesquare(matchsticks));
    }
}
