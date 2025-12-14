"""
Problem : For a given n, return its factorial using recursion
Ex: n = 5, return 5! = 120
"""

def getFactorial(n) :

    # Base Case
    if n <= 1 : 
        return 1
    
    recursionAns = getFactorial(n-1)
    return n * recursionAns


n = int(input("Enter n : "))
print("Factorial of " , n , " is : " , getFactorial(n))