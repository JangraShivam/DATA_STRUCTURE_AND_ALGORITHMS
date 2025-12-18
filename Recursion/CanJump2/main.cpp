/*
Problem : Jump Game II (Leetcode - 45)
*/

#include <iostream>
#include <vector>
using namespace std;

int getMinimumJumps(vector<int>& nums, int index){
    // return 0 jumps as we reach the end
    if(index >= nums.size()-1) return 0;

    // Intialize jumpsNeeded to reach the end 
    int jumpsNeeded = INT32_MAX;

    // Iterate for diff values of jumps possible at current index
    // and store the minimum jumps needed to reach the end
    for(int jump = 1; jump <= nums[index]; jump++){
        // get minimum jumps 
        int jumps = getMinimumJumps(nums,index+jump);

        if(jumps != INT32_MAX){
            jumpsNeeded = min(jumpsNeeded,1+jumps);
        }
    }

    return jumpsNeeded;
}

int jump(vector<int>& nums) {
    return getMinimumJumps(nums,0);
}


int main(){

    vector<int> nums = {2,3,1,1,4};

    cout << "Min Jumps Needed : " << jump(nums) << endl;

    return 0;
}