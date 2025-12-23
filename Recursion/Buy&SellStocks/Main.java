/*
Problem : Best Time to Buy and Sell Stock (LeetCode : 121)
*/

public class Main{

    private static int minPrice = Integer.MAX_VALUE;
    private static int maxprofit = 0;

    // Method 2
    public static void solve2(int[] prices, int index){
        // Base case
        if(index >= prices.length) return;

        // Update minimum Price of stock to buy
        minPrice = Math.min(minPrice,prices[index]);
        // try to sell and update maxProfit
        maxprofit = Math.max(maxprofit,prices[index]-minPrice);

        solve2(prices,index+1);
    }

    // Method 1
    public static 
    int solve(int[] prices, int index, int buy){
        // Base case
        if(index >= prices.length) return 0;

        // Check if stock are bought if not buy first else sell
        if(buy == -1){
            // buy current index stock
            int buyCurrentStock = solve(prices,index+1,index);
            // dont but current stock
            int dontBuy = solve(prices,index+1,-1);

            return Math.max(buyCurrentStock,dontBuy);
        }
        else{
            // sell at current Index
            int sellCurrent = prices[index] - prices[buy];
            int dontsell = solve(prices,index+1,buy);

            return Math.max(sellCurrent,dontsell);
        }
    }

    public static void maxProfit(int[] prices) {
        solve2(prices,0);
        System.out.println("Method 2 : " + maxprofit);

        int mxprofit = solve(prices,0,-1);
        System.out.println("Method 1 : " + mxprofit);
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        maxProfit(prices);
    }


}