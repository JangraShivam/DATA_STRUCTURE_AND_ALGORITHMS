"""
Problem : Perfect Squares (LC 279)
"""

import sys
def numSquares(n: int) -> int :
    # Base Case
    if(n <= 0) :
        return 0

    # Intialize Minimum answer
    minAns = sys.maxsize

    # Try different perfect sqaures less than n
    i = 1
    while i*i <= n :
        ans = 1 + numSquares(n - (i*i))
        minAns = min(minAns,ans) # update minAns
        i += 1

    return minAns


print(numSquares(12))