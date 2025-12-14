"""
Problem : Calculate Sum of values from 1 to n
"""

def getSum(n):
    if n == 0:
        return 0
    
    recursionAns = getSum(n-1)
    return n + recursionAns

n = int(input("Enter N : "))
print("Sum : ", getSum(n))