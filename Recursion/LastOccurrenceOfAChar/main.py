""" 
Problem : Given an input string and target character, find the last occurence of target char 
"""


# Method 1 : Search from left to right
def findLTR(input, target, index, ans) :
    # Target char is not in the string return -1
    if(index >= len(input)): 
        return

    # Target char found and store and update ans
    if(input[index] == target) :
        ans[0] = index
    
    # Look for further occurence of target char
    findLTR(input,target,index+1,ans)

# Method 2 : Search from right to left
def findRTL(input, target, index) :
    # Target char is not in the string return -1
    if(index < 0) :
        return -1

    # Target char found and return it because it is the last occurence
    if(input[index] == target) :
        return index

    return findRTL(input,target,index-1)


input = "aabsbsbfbg"
target = 'b'
ans = [-1]
findLTR(input,target,0,ans)
print("LTR : ", ans[0])
print("RTL : " , findRTL(input,target,len(input)-1))