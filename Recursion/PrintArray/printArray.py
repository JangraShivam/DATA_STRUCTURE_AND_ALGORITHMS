""" 
Problem : Print Elements of Array, Straight and reverse
"""

def printArray(arr,index):

    if index >= len(arr) :
        return
    
    print(arr[index],end=" ")
    printArray(arr,index+1)


def printArrayReverse(arr,index):

    if index >= len(arr) :
        return
    
    printArrayReverse(arr,index+1)
    print(arr[index],end=" ")



arr = [3,2,4,5,7,21,54,23,562,23]
print("Normal print : ",end="")
printArray(arr,0)
print()
print("Reverse Print : ",end="")
printArrayReverse(arr,0)
    