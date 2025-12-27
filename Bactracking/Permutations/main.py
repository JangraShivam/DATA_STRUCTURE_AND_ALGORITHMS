"""
Problem : Permutations (LC - 46)
"""

def getPossiblePermuatations(currentPermuatation: list[int], index: int, allPermutations: list[list[int]]) :
    # Base Case 
    if(index >= len(currentPermuatation)) :
        permutation = currentPermuatation[:]
        allPermutations.append(permutation)
        return
    

    # Permutation Logic
    for j in range (index,len(currentPermuatation)) :
        currentPermuatation[index], currentPermuatation[j] = currentPermuatation[j], currentPermuatation[index]
        getPossiblePermuatations(currentPermuatation,index+1,allPermutations)
        # backtrack
        currentPermuatation[index], currentPermuatation[j] = currentPermuatation[j], currentPermuatation[index] 
    



def permute(nums: list[int]) -> list[list[int]] : 
    allPermutations = []
    getPossiblePermuatations(nums,0,allPermutations)
    return allPermutations


nums = [1,2,3]
answer = permute(nums)

print(answer)