"""
Problem : Letter Combinations of a Phone Number (LC - 17)
"""
from typing import List
def getletterCombinations(digits: str,index: int, currentCombination: List[str],combinations: List[str], numToChar: dict[str:str]) :
    # Base Case
    if(index >= len(digits)) :
        combinations.append("".join(currentCombination))
        return

    # try all values at particular digit
    for ch in numToChar[digits[index]] : 
        currentCombination.append(ch)
        getletterCombinations(digits,index+1,currentCombination,combinations,numToChar)
        currentCombination.pop() # backTrack


def letterCombinations(digits: str) -> List[str]:
    numToChar = {}
    numToChar['2'] = "abc"
    numToChar['3'] = "def"
    numToChar['4'] = "ghi"
    numToChar['5'] = "jkl"
    numToChar['6'] = "mno"
    numToChar['7'] = "pqrs"
    numToChar['8'] = "tuv"
    numToChar['9'] = "wxyz"
    combinations = []
    currentCombination = []
    getletterCombinations(digits,0,currentCombination,combinations,numToChar)
    return combinations


ans = letterCombinations("23")
print(ans)