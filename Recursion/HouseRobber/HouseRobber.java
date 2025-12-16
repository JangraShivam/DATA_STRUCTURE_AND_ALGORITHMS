/*
Problem : House Robber (LeetCode 198)
*/

public class HouseRobber{

    public static int maxRobbingProfit(int[] houses, int index){
        // Base Case
        if(index >= houses.length) return 0;

        // rob current house and skip next house or include case
        int robCurrentHouse = houses[index] + maxRobbingProfit(houses,index+2);

        // Dont rob current house and go to next
        int notRob = maxRobbingProfit(houses,index+1);

        // return maximum profit
        return Math.max(robCurrentHouse,notRob);
    }
    public static void main(String[] args) {
        int[] houses = {2,7,9,3,1};

        System.out.println("Maximum Profit : " + maxRobbingProfit(houses, 0));
    }

}