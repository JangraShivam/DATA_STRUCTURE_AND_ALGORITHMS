"""
Problem : House Robber (LeetCode 198)
"""
from typing import List

def maxRobbingProfit(houses : List[int], index : int) -> int :
    # Base Case
    if index >= len(houses) : 
        return 0

    # rob current house and skip next house or include case
    robCurrentHouse = houses[index] + maxRobbingProfit(houses,index+2)

    # Dont rob current house and go to next
    notRob = maxRobbingProfit(houses,index+1)

    # return maximum profit
    return max(robCurrentHouse,notRob)


houses = [2,7,9,3,1]
print("Maximum Profit : ",maxRobbingProfit(houses,0))

