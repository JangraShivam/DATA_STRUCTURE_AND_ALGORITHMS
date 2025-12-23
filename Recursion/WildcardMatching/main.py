"""
Problem : Wildcard Matching (LC 44)
"""

def isMatchHelper(s: str, sIndex: int, p: str, pIndex: int) -> bool :
    # Base Case for match
    if(sIndex >= len(s) and pIndex >= len(p)) :
        return True

    # Base Case for not match
    if(pIndex >= len(p)) :
        return False

    # match one char of s
    if (sIndex < len(s)) and ((p[pIndex] == '?') or s[sIndex] == p[pIndex]) :
        return isMatchHelper(s,sIndex+1, p, pIndex+1)
    elif(p[pIndex] == '*') :
        # match empty char by *
        matchEmptyChar = isMatchHelper(s,sIndex,p,pIndex+1)

        # match a char and only match when sindex is valid
        matchChar = isMatchHelper(s, sIndex+1, p, pIndex) if (sIndex < len(s)) else False

        return matchEmptyChar or matchChar
    else :
        return False


def isMatch(s: str, p: str) -> bool :
    return isMatchHelper(s,0,p,0)


print(isMatch("aa","a*"))