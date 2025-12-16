"""Problem : Coin Change (LeetCode 322)"""

from typing import List

def coinChange(coins: List[int], amount: int) -> int:
    if(amount == 0) : 
        return 0

    minCoinChange = -1

    for coin in coins :
        if coin <= amount :
            recursionAns = coinChange(coins,amount-coin)

            if recursionAns != -1 :
                if(minCoinChange == -1) : 
                    minCoinChange = 1 + recursionAns
                else : 
                    minCoinChange = min(minCoinChange,1 + recursionAns)

    return minCoinChange; 


coins = [1,2,5]
amount = 11
print(coinChange(coins,amount))