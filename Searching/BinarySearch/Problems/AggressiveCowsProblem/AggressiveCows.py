"""
Problem : Aggressive Cows (GFG)

Description :
You are given an array with unique elements of stalls[], which denote the positions of stalls. 
You are also given an integer k which denotes the number of aggressive cows. 
The task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.


Examples:
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows in this case is 3, which is the largest among all possible ways.


Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows in this case is 4, which is the largest among all possible ways.


Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance 
between any two cows is as large as possible.
The minimum distance between cows in this case is 1, which is the largest among all possible ways.


Constraints:
2 ≤ stalls.size() ≤ 10^6
0 ≤ stalls[i] ≤ 10^8
2 ≤ k ≤ stalls.size()
"""

def isPossible(stalls, k, dist) :
    currentCowPosition = stalls[0]
        
    for i in range (1, len(stalls)):
        if stalls[i] - currentCowPosition >= dist:
            k-=1
            currentCowPosition = stalls[i]
            if k == 1:
                return True
    return False


def aggressiveCows(stalls, k):
    stalls.sort()
        
    start = 0
    end = max(stalls)
        
    ans = -1
        
    while start <= end:
        mid = (start+end)//2
            
        if isPossible(stalls,k,mid):
            ans = mid
            start = mid+1
        else:
            end = mid-1
                
    return ans


# main Program

arr = list(map(int, input().strip().split()))
cows = int(input())

print(aggressiveCows(arr,cows))