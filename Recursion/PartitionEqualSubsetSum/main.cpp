/*
Problem : Partition Equal Subset Sum (LeetCode - 416)
*/

#include <iostream>
#include <vector>
#include <numeric>
using namespace std;

bool canPartitionHelper(vector<int>& nums,int targetSum, int index){
    // Partition found
    if(targetSum == 0) return true;

    // Partition not found
    if(targetSum < 0 || index >= nums.size()) return false;

    // Include in current Partition
    bool include = canPartitionHelper(nums,targetSum - nums[index], index+1);

    // Exclude in current Partition
    bool exclude = canPartitionHelper(nums,targetSum, index+1);

    return include || exclude;
}

bool canPartition(vector<int>& nums) {
    // Get total Sum 
    int totalSum = accumulate(nums.begin(),nums.end(),0);

    // If total Sum is Odd, then partition cant be done
    if(totalSum&1) return false;

    // Half the totalSum for one partition to target
    int targetSum = totalSum/2;

    // look for a partition with targetSum
    return canPartitionHelper(nums,targetSum,0);
}

int main(){

    vector<int> nums = {1,5,11,5};

    cout << "Can Partition : " << canPartition(nums) << endl;

    return 0;
}