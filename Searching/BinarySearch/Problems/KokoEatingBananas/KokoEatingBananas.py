"""
Problem : Koko Eating Bananas (LC - 875)

Description : 
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. 
Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
-> 1 <= piles.length <= 104
-> piles.length <= h <= 109
-> 1 <= piles[i] <= 109

"""

from typing import List
import math

# Check whether the koko eating speed is sufficient for eating all piles in h hours
def checkSpeed(speed : int,piles : List[int],h :int) -> bool:

    # Simulate koko eating with speed value
    for pile in piles:
        h = h - math.ceil(pile/speed) # update h 

        # if h < 0 then time is up and koko gets caught
        if h < 0 :
            return False
    
    # koko successfully ate all the bananas
    return True

# Calculate the minimum eating speed for koko
def minEatingSpeed(piles: List[int], h: int) -> int:

    minSpeed = 1 # minimum eating speed for koko
    maxSpeed = max(piles) # maximum eating speed for koko, more than this there will be no change in answer

    # Intialize koko speed
    kokoSpeed = -1

    # Binary search on search space
    while minSpeed <= maxSpeed :

        # midspeed or possible speed for koko
        mid = (minSpeed + maxSpeed)//2

        # check if koko can eat all piles in h hours with midspeed
        if checkSpeed(mid,piles,h) :
            # store and update the kokospeed
            kokoSpeed = mid
            maxSpeed = mid-1 # move left
        else:
            minSpeed = mid + 1 # move right
        
    return kokoSpeed


# main function
size = int(input("Enter the size of piles array : "))
piles = list(map(int,input("Enter pile elements of piles array : ").strip().split()))[:size]
h = int(input("Enter value of hours : "))

answer = minEatingSpeed(piles,h)
print("Answer is : ",answer)