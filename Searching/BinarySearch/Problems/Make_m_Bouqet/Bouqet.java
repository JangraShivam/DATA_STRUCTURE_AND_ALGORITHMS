/*
Problem : Minimum Number of Days to Make m Bouquets (LC - 1482)

Description :
You are given an integer array bloomDay, an integer m and an integer k.
You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] 
and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. 
If it is impossible to make m bouquets return -1.


Example 1:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. 
x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

Example 2:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers, 
that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.

Example 3:
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. 
We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
 

Constraints:
bloomDay.length == n
1 <= n <= 105
1 <= bloomDay[i] <= 109
1 <= m <= 106
1 <= k <= n

Approach : 
-> Search answer space pattern problem
-> Minimum days would be when the first flower bloom
-> Maximum days would be when the last flower bloom
-> Apply Binary search on this answer space
-> Check if possible to make bouqets as given
-> if yes, store and look for minimum days
-> if no, then look for answer with more days

-> One case can be if required flower to make bouqet is higher than number of flowers
-> or size of bloomday array, therefore then answer would be -1
*/

import java.util.Scanner;

public class Bouqet{

    // Check if its possible to make bouqets in given days
    public static boolean isPossible(int days, int[] bloomDay, int m, int k){
        int counter = 0; // counter for flower in current bouqets

        // iterate over bloomday array or make bouqets
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= days) counter++; // if flower is bloomed then add in current bouqet
            else counter = 0; // if not then we can not make current bouqet because adjacent flowers are needed.

            // Check if we made a bouqet
            if(counter == k){
                counter = 0; // set counter to zero for next bouqet
                m--; // decrease required bouqet count
                if(m == 0) return true; // check if we made all the bouqet
            }
        }

        // cant make all the bouqets
        return false;
    }
    
    // Calculate the minimum days for making bouqets
    public static int minDays(int[] bloomDay, int m, int k) {

        // Size of bloomday array or number of flowers
        int numberOfFLowers = bloomDay.length;

        // Required flowers for making bouqets
        long requiredFlowers = (long)m*(long)k;

        // Check if it is possible to make bouqets and if not return -1
        if((long)numberOfFLowers < requiredFlowers) return -1;

        // intialize search space 
        int minDays = bloomDay[0];
        int maxDays = bloomDay[0];

        for(int i : bloomDay){
            minDays = Math.min(minDays,i);
            maxDays = Math.max(maxDays,i);
        }

        int answer = -1;

        // Binary Search on answer space
        while(minDays <= maxDays){

            int mid = minDays + (maxDays - minDays)/2; // possible answer

            // Check if it possible to make bouqets
            if(isPossible(mid,bloomDay,m,k)){
                answer = mid; // store and update the answer
                maxDays = mid - 1; // move left to find another minimum answer
            }
            else{
                minDays = mid + 1; // move right to find a valid answer
            }
        }

        return answer;
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of bloomDay array : ");
        int size = sc.nextInt();

        System.out.println("Enter bloomDay array elements : ");
        int[] bloomDay = new int[size];
        for(int i = 0; i < size; i++){
            bloomDay[i] = sc.nextInt();
        }

        System.out.println("Enter m : ");
        int m = sc.nextInt();

        System.out.println("Enter k : ");
        int k = sc.nextInt();

        sc.close();

        int answer = minDays(bloomDay, m, k);
        System.out.println(answer);
    }
}