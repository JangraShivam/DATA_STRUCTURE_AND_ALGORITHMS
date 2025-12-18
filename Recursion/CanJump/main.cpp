/*
Problem : Can Jump (LeetCode - 55)
*/

#include <iostream>
#include <vector>
using namespace std;

bool canJumpHelper(vector<int>& nums, int index){
    // Check if we reached the end or last index
    if(index >= nums.size()-1) return true;
    
    // Intialize reachedStatus with false
    bool reachedStatus = false;

    // Iterate for different values possible for jumps at current index for reaching the end
    for(int jump = 1; jump <= nums[index]; jump++){
        reachedStatus = reachedStatus || canJumpHelper(nums,index+jump);
    }

    return reachedStatus;
}

bool canJump(vector<int>& nums) {
    return canJumpHelper(nums,0);
}

int main(){

    vector<int> nums = {2,3,1,1,4};

    cout << "End Reached ? " << canJump(nums) << endl;

    return 0;
}