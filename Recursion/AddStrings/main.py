"""
Problem : Add Strings (Leetcode - 415)
"""

from typing import List

def add(num1: str, n1: int,num2: str, n2: int, ans: List[str], carry: int) :
    # Base Case
    if(n1 < 0 and n2 < 0) :
        # Push Carry if not equal to 0
        if(carry != 0): ans.append('1')
        return

    # get num1 current digit
    num1Digit = 0 if n1 < 0 else int(num1[n1])

    # get num2 current digit
    num2Digit = 0 if n2 < 0 else int(num2[n2])

    # Calculate Sum
    sum = num1Digit + num2Digit + carry
    carry = sum//10
    digit = sum%10

    ans.append((str)(digit))
    add(num1,n1-1,num2,n2-1,ans,carry)

    
def addStrings(num1: str, num2: str) -> str:
    ans = []
    add(num1, len(num1)-1, num2, len(num2)-1, ans, 0)
    ans.reverse()
    ans = "".join(ans)
    return ans


num1 = "123"
num2 = "23"

print("Sum : ",addStrings(num1,num2))