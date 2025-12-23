"""
Problem : Best Time to Buy and Sell Stock (LeetCode : 121)
"""

from typing import List
import sys

minPrice = sys.maxsize
maxprofit = 0

# Method 2
def solve2(prices: List[int], index: int) : 
    global minPrice, maxprofit
    # Base case
    if(index >= len(prices)) :
        return

    # Update minimum Price of stock to buy
    minPrice = min(minPrice,prices[index])
    # try to sell and update maxProfit
    maxprofit = max(maxprofit,prices[index]-minPrice)

    solve2(prices,index+1)


# Method 1
def solve(prices: List[int], index: int, buy: int) -> int :
    # Base case
    if(index >= len(prices)) :
        return 0

    # Check if stock are bought if not buy first else sell
    if(buy == -1) :
        # buy current index stock
        buyCurrentStock = solve(prices,index+1,index);
        # dont but current stock
        dontBuy = solve(prices,index+1,-1);

        return max(buyCurrentStock,dontBuy)
    
    else:
        # sell at current Index
        sellCurrent = prices[index] - prices[buy]
        dontsell = solve(prices,index+1,buy)

        return max(sellCurrent,dontsell)
    

def maxProfit(prices: List[int]) :
    solve2(prices,0)
    print("Method 2 : ",maxprofit)

    mxprofit = solve(prices,0,-1)
    print("Method 1 : ", solve(prices,0,-1))

prices = [7,1,5,3,6,4]
maxProfit(prices)

