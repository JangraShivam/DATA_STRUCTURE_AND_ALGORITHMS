""" 
Problem : Find maximum and minimum element in array
"""

def maxElement(arr,index) : 
    if index >= len(arr) - 1:
        return arr[index]
    
    return max(maxElement(arr,index+1),arr[index])
    


def minElement(arr,index) : 
    if index >= len(arr) - 1:
        return arr[index]
    
    return min(minElement(arr,index+1),arr[index])
    


arr = [2,45,78,0,-9,52,-987,1006]

print("Maximum Element : ",maxElement(arr,0))
print("Minimum Element : ",minElement(arr,0))