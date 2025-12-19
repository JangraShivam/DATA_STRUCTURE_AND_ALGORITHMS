"""
Problem : Reverse a string
"""

def reverseHelper(input, start, end):
    if start > end:
        return
    
    input[start], input[end] = input[end], input[start]
    reverseHelper(input,start+1, end-1)



def reverse(input) :
    input = list(input) # convert input from string to list (list are mutable)
    reverseHelper(input,0,len(input)-1)
    input = "".join(input) # list to string
    return input


input = "abcdef"
input = reverse(input)
print(input)