/*
Problem : Aggressive Cows (GFG)

Description :
You are given an array with unique elements of stalls[], which denote the positions of stalls. 
You are also given an integer k which denotes the number of aggressive cows. 
The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.


Examples:
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows in this case is 3, which is the largest among all possible ways.


Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows in this case is 4, which is the largest among all possible ways.


Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance 
between any two cows is as large as possible.
The minimum distance between cows in this case is 1, which is the largest among all possible ways.


Constraints:
2 ≤ stalls.size() ≤ 10^6
0 ≤ stalls[i] ≤ 10^8
2 ≤ k ≤ stalls.size()
*/

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    
    public static boolean isPossible(int[] stalls,int k,int dist){
        int currentCowPosition = stalls[0];
        k--;

        for(int i = 0; i < stalls.length; i++){
            if(stalls[i] - currentCowPosition >= dist){
                k--;
                currentCowPosition = stalls[i];
                if(k == 0) return true;
            }
        }
        
        return false;
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        
        int start = 0;
        int end = 0;
        int ans = -1;
        for(int i : stalls){
            end = Math.max(end,i);
        }
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(isPossible(stalls,k,mid)){
                ans = mid;
                start = mid+1;
            }
            else end = mid -1;
        }
        
        return ans;
        
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        int cows = sc.nextInt();
        sc.close();

        System.out.println(aggressiveCows(arr, cows));
    }
}
