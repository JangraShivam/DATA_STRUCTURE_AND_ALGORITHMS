""" 
Problem : Print all Odd and Even numbers in Array
"""

def printOdd(arr,index):
    if index >= len(arr):
        return
    
    if arr[index]&1 :
        print(arr[index],end=" ")
    
    printOdd(arr,index+1)



def printEven(arr, index) :
    if index >= len(arr) :
        return
    
    if not(arr[index]&1) :
        print(arr[index],end=" ")

    printEven(arr,index+1)



arr = [2,3,4,5,6,7,8,9,10,11,13]

print("Odd Numbers : ",end=" ")
printOdd(arr,0)
print("\nEven Numbers : ",end=" ")
printEven(arr,0)
print()
