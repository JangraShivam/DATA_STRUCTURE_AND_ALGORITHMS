"""
Problem : Square Root Using Binary Search (with Precision)

Description
Given a non-negative number x and an integer p representing the required number of digits after the decimal, 
compute the square root of x up to p decimal places. You must not use built-in functions like sqrt(); 
instead, implement the solution using binary search (also known as search-space binary search).
Your algorithm should run efficiently for large values of x and high precision p.

Input:
-> An integer or floating-point number x 
-> An integer p such that 0 ≤ p ≤ 10

Output
-> A floating-point value representing √x, rounded or truncated to p decimal places.

Constraints
-> Binary search must be used.
-> Time complexity should be approximately: O(log(x) + p * 10)

Expected Approach:
Use integer binary search to compute the integer part of the square root.
Use linear expansion / fractional binary search to compute each decimal place, 
one at a time, up to precision p.

"""
def sqrtWithPrecision2(x,p):

    precision = 1/pow(10,p)

    start = 0
    end = x
    answer = -1

    while end - start >= precision:
        mid = (start + end)/2

        if mid*mid <= x:
            answer = mid
            start = mid + precision
        else:
            end = mid - precision
    
    return answer

def sqrtWithPrecision(x,p) :

    # Integer Part
    start = 0
    end = int(x)

    answer = -1

    while start <= end:
        
        mid = (start + end)//2

        if mid*mid <= x:
            answer = mid
            start = mid + 1
        else :
            end = mid - 1
    
    # Fraction Part
    precision = 1
    denom = 10

    while precision <= p :
        s = 0
        e = 9
        ans = answer

        while s <= e:
            m = (s + e)//2
            possAns = ans + m/denom

            if possAns*possAns <= x :
                answer = possAns
                s = m + 1
            else :
                e = m - 1
        
        denom = denom*10
        precision += 1
    
    return answer


# Main Program
x = float(input("Enter a number : "))
p = int(input("Enter precision : "))

if x < 0 or p < 0 :
    print("Negative numbers are not allowed")

answer = sqrtWithPrecision(x,p)
print("Answer with Method 1 : ",round(answer,p))

answer = sqrtWithPrecision2(x,p)
print("Answer with Method 2 : ",round(answer,p))

