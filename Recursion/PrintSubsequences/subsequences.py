"""
Problem : Print all subsequences of a string
"""

def getSubsequences(input, index, subseq, allSubsequences) :
    # Base Case
    if index >= len(input) :
        allSubsequences.append(subseq)
        return
    
    # exclude current char
    getSubsequences(input,index+1,subseq,allSubsequences)

    # include current char
    subseq = subseq + input[index]
    getSubsequences(input,index+1,subseq,allSubsequences)


input = "abc"
allSubsequences = []

getSubsequences(input,0,"",allSubsequences)

print("Total Subsequences : ",len(allSubsequences))
for i in range(0,len(allSubsequences)):
    print(i+1,"Subsequence : ",allSubsequences[i])

