"""
Problem : Print Counting from 1 to N. and in reverse N to 1
"""

def printNormal(n) :

    if n <= 0:
        return
    
    
    printNormal(n-1)
    print(n,end=" ")


def printReverse(n) :

    if n <= 0:
        return
    
    print(n,end=" ")
    printReverse(n-1)
    
n = int(input("Enter n : "))

print("Normal Print : ")
printNormal(n)
print()
print("Reverse Print : ")
printReverse(n)