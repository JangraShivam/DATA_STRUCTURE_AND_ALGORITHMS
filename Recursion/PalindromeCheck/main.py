"""
Problem : Check if a string is palindrome or not
"""

def isPalindrome(input: str, start: int, end: int) -> bool:
    # Base case
    if start >= end:
        return True
    
    # Another Base Case
    if input[start] != input[end] :
        return False
    
    return isPalindrome(input,start+1,end-1)


input = "ababa"
print("Palindrome ? ", isPalindrome(input,0,len(input)-1))