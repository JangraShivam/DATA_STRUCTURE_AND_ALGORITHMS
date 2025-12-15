/*
Problem : Binary Search using recursion
*/

#include <iostream>
#include <vector>
using namespace std;

int binarySearch(vector<int>& arr, int start, int end, int& target){
    //Base Case
    if(start > end) return -1;

    int mid = start + (end - start)/2;

    if(arr[mid] == target) return mid;
    else if(arr[mid] > target) return binarySearch(arr,start,mid-1,target);
    else return binarySearch(arr,mid+1,end,target);
}

int main(){

    vector<int> arr = {1,2,3,4,5,6,7,8,9,10};
    int target = 5;

    int foundIndex = binarySearch(arr,0,arr.size()-1,target);

    if(foundIndex != -1){
        cout << "Target found at index : " << foundIndex << endl;
    }
    else{
        cout << "Target not found" << endl;
    }


    return 0;
}