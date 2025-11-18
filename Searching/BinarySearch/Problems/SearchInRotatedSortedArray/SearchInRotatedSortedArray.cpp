/*
Problem: Search in Rotated Sorted Array

Description:
You are given an integer array nums that is sorted in ascending order 
and then rotated at an unknown index k (0 < k < nums.length).

The rotation creates an array of the form:
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]

For example, the sorted array:
[0,1,2,4,5,6,7]

rotated by 3 positions becomes:
[4,5,6,7,0,1,2]

You are also given an integer target.
Your task is to return the index of target in the array, or -1 if it is not present.

You must solve this in O(log n) time using Binary Search.

Constraints:
-> All integers in nums are unique.
-> array is ascending sorted before rotation.

Input Format:
-> An integer n denoting the size of the array.
-> n space-separated integers representing the elements of the array.
-> An integer target representing the value to search for.

Output Format:
-> An integer representing the index of target in the array, or -1 if not found.

Approach 1:
-> Find the pivot point where the array is rotated.
-> Perform binary search in the appropriate subarray.

Approach 2:
-> Modify binary search to account for the rotation by checking which side is sorted.

*/

#include <iostream>
#include <vector>
using namespace std;

int searchInRotatedSortedArray(vector<int>& nums, int target) {
    int startIndex = 0;
    int endIndex = nums.size() - 1;

    while(startIndex <= endIndex){
        int midIndex = startIndex + (endIndex - startIndex) / 2;

        if(nums[midIndex] == target){
            return midIndex;
        }
        else if(nums[midIndex] >= nums[startIndex]){
            if(target > nums[midIndex]) startIndex = midIndex + 1;
            else{
                if(target >= nums[startIndex]) endIndex = midIndex - 1;
                else startIndex = midIndex + 1;
            }
        }
        else{
            if(target < nums[midIndex]) endIndex = midIndex - 1;
            else{
                if(target <= nums[endIndex]) startIndex = midIndex + 1;
                else endIndex = midIndex - 1;
            }
        }
    }

    return -1;
}

int main(){

    cout << "Enter input as specified in the problem description." << endl;

    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    int target;
    cin >> target;

    int result = searchInRotatedSortedArray(nums, target);
    cout << result << endl;

    return 0;
}