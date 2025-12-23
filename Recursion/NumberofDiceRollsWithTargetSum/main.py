"""
Problem : Number of Dice Rolls With Target Sum (LC 1155)
"""

def numRollsToTarget(n: int, k: int, target: int) -> int :
    # Base Case or no dice left to roll
    if(n == 0) :
        # Target matched
        if (target == 0) : 
            return 1
        else : 
            return 0 # target sum not matched

    ans = 0
    # Simulate all the values of dice
    for i in range(1,k+1) :
        ans = ans + numRollsToTarget(n-1,k,target - i)

    return ans

print(numRollsToTarget(3,5,6))