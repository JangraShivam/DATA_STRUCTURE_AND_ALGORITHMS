/*
Problem : Best Time to Buy and Sell Stock (LeetCode : 121)
*/

#include <iostream>
#include <vector>
using namespace std;

int minPrice = INT32_MAX;
int maxprofit = 0;

// Method 2
void solve2(vector<int>& prices, int index){
    // Base case
    if(index >= prices.size()) return;

    // Update minimum Price of stock to buy
    minPrice = min(minPrice,prices[index]);
    // try to sell and update maxProfit
    maxprofit = max(maxprofit,prices[index]-minPrice);

    solve2(prices,index+1);
}

// Method 1
int solve(vector<int>& prices, int index, int buy){
    // Base case
    if(index >= prices.size()) return 0;

    // Check if stock are bought if not buy first else sell
    if(buy == -1){
        // buy current index stock
        int buyCurrentStock = solve(prices,index+1,index);
        // dont but current stock
        int dontBuy = solve(prices,index+1,-1);

        return max(buyCurrentStock,dontBuy);
    }
    else{
        // sell at current Index
        int sellCurrent = prices[index] - prices[buy];
        int dontsell = solve(prices,index+1,buy);

        return max(sellCurrent,dontsell);
    }
}

void maxProfit(vector<int>& prices) {
    solve2(prices,0);
    cout << "Method 2 : " << maxprofit << endl;

    int mxprofit = solve(prices,0,-1);
    cout << "Method 1 : " << mxprofit << endl;
}

int main(){

    vector<int> prices = {7,1,5,3,6,4};

    maxProfit(prices);

    return 0;
}