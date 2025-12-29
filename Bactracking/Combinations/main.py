"""
Problem : Combinations (LC - 77)
"""

from typing import List

def getCombinations(n: int, k: int, currentCombination: List[int], allCombinations: List[List[int]]) -> None:
   # Base Case 
    if(k == 0) :
        allCombinations.append(currentCombination[:])
        return

    # combination logic
    for i in range (n,0,-1) :
        currentCombination.append(i)
        getCombinations(i-1,k-1,currentCombination,allCombinations)
        currentCombination.pop()
    


def combine(n: int, k: int) -> List[List[int]]:
    allCombinations  = []
    currentCombination = []
    getCombinations(n,k,currentCombination,allCombinations)
    return allCombinations


# main 
ans = combine(4,2)
print(ans)