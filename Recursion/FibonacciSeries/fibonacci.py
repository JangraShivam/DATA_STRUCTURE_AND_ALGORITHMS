"""
Problem : get fibonacci nth term
"""

def getFibonacci(n):
    if n <= 2:
        return 1
    
    return getFibonacci(n-1) + getFibonacci(n-2)

n = int(input("Enter N : "))
print(getFibonacci(n))