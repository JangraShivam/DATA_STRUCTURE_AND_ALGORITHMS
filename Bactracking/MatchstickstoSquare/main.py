"""
Problem : Matchsticks to Square (LC - 473)
"""

from typing import List
def makeSquareHelper(matchsticks: List[int], index: int, sidesLength: List[int]) -> bool :
    # Base Case
    if(index >= len(matchsticks)) :
        return sidesLength[0] == sidesLength[1] == sidesLength[2] == sidesLength[3]
        
    # Try to add current matchsticks to all 4 sides
    for i in range(0,4) :
        # the side should not exceed 
        if sidesLength[i] - matchsticks[index] >= 0 :
            sidesLength[i] -= matchsticks[index]
            if(makeSquareHelper(matchsticks,index+1,sidesLength)) : return True
            else :
                sidesLength[i] += matchsticks[index] # backtrack
            
    return False


def makesquare(matchsticks: List[int]) -> bool :
    # get total length sum
    Sum = sum(matchsticks)
    # check if sum can be divided into 4 parts
    if(Sum%4 != 0) : return False

    # intialize sides with their expected length
    sidesLength = [(Sum//4),(Sum//4),(Sum//4),(Sum//4)]

    # sort in decrease order to reduce recursive calls
    matchsticks.sort(reverse=True)
    return makeSquareHelper(matchsticks,0,sidesLength)

#main 
matchSticks = [1,1,2,2,2]
print(makesquare(matchSticks))