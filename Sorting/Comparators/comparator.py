# Intialize an unsorted vector or array
v = [8,1,3,0,9,10,43,23]

"""
Sort v using inbuilt sort function
it sort v in ascending order
"""
v.sort()
print(v)

"""
To sort v in descending order we need to just set
reverse attribute to True, so it can sort v in descending order
"""
v = [8,1,3,0,9,10,43,23]
v.sort(reverse=True)
print(v)

# intialize a 2d vector
a = [[1,2],[89,21],[6,4],[85,32],[98,99]]

"""
    use sort to sort the 'a' and it will sort it
    in the asceding order of 0th element of inside vector
"""
a.sort() # ascending order
print(a)
a.sort(reverse=True) # descending order
print(a)

"""
    sort 'a' by the inside list any index element
    value like 1st index or 2nd index
"""
a = [[1,2],[89,21],[6,4],[85,32],[98,99]]
a.sort(key=lambda x:x[1])
print(a)
a.sort(key=lambda x:x[1], reverse=True)
print(a)