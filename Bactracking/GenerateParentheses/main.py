"""
Problem : Generate Parentheses (LC - 22)
"""

from typing import List

def generate(open: int, closed: int, current: List[str], allParenthesis: List[str]) -> None :
    # Base Case
    if(open == 0 and closed == 0):
        allParenthesis.append("".join(current))
        return

    # If open paren can be used then use it
    if(open > 0) :
        current.append('(')
        generate(open-1,closed,current,allParenthesis)
        current.pop()

    # only add close paren if there are a alone open paren
    if(closed > open) :
        current.append(')')
        generate(open,closed-1,current,allParenthesis)
        current.pop()


def generateParenthesis( n: int) -> List[str]:
    allParenthesis = []
    current = []

    generate(n,n,current,allParenthesis)
    return allParenthesis


# main
ans = generateParenthesis(3)
print(ans)