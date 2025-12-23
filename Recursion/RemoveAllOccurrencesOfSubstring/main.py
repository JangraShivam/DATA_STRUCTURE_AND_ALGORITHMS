"""
Problem : Remove All Occurrences of a Substring (LeetCode - 1910)
"""

from typing import List

def removeOccurrencesHelper(s : str, index: int, part: str, ans: List[str]) :
    # Base case
    if(index >= len(s)) :
        return

    # Push current char into ans
    ans.append(s[index])

    partIndex = len(part) - 1
    ansIndex = len(ans) - 1

    # Match part in ans string
    while(partIndex >= 0 and ansIndex >= 0) :
        if(part[partIndex] != ans[ansIndex]) :
            break
        partIndex-=1
        ansIndex-=1

    # If partIndex < 0 then match found and remove it
    if(partIndex < 0) :
        # ans was equal to part fully so empty it
        if(ansIndex < 0) : ans.clear()
        else : del ans[ansIndex+1:len(ans)] # remove part from end

    removeOccurrencesHelper(s,index+1,part,ans)


def removeOccurrences(s: str, part: str) -> str :
    ans = []    
    removeOccurrencesHelper(s,0,part,ans)
    ans = "".join(ans)
    return ans


s = "daabcbaabcbc"
part = "abc"

print(removeOccurrences(s,part))