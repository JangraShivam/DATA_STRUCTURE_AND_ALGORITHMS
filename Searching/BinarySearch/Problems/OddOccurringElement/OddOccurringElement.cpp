/*
Problem: Problem: Single Element in Array With Adjacent Duplicate Pairs

Description
You are given an integer array where:
Every element that appears twice appears in a pair (i.e., next to its duplicate).
Exactly one element appears only once.
The array is not necessarily sorted, but duplicate elements always occur consecutively.
Your task is to return the unique element that appears only once.
You must solve this in O(log n) time and O(1) extra space using Binary Search.

Important Constraint
-> The array is not sorted, but pairs are always adjacent.
-> This special structure still allows a binary-search-based solution.

Input Format
-> First line : an non-negative integer representing array size
-> Second line : n space separated integers

Output:
-> Return the single element that appears only once.

Example 1
Input:
nums = [7, 7, 3, 3, 10, 11, 11]

Output:
10

*/

# include <iostream>
# include <vector>
using namespace std;

int oddOccurringElement(vector<int> &arr){

    int startIndex = 0;
    int endIndex = arr.size() - 1;

    while(startIndex <= endIndex){
        if(startIndex == endIndex) return arr[startIndex];

        int midIndex = startIndex + (endIndex - startIndex)/2;

        if(arr[midIndex] != arr[midIndex-1] && arr[midIndex] != arr[midIndex+1]){
            return arr[midIndex];
        }

        if(arr[midIndex] == arr[midIndex-1]){
            if((midIndex-1)&1){
                endIndex = midIndex - 2;
            }
            else{
                startIndex = midIndex + 1;
            }
        }
        else{
            if((midIndex&1)){
                endIndex = midIndex - 1;
            }
            else{
                startIndex = midIndex + 2;
            }
        }
    }

    return -1;
}

int main(){

    cout << "Enter the size of array : " ;
    int n;
    cin >> n;

    cout << "Enter elements of array : " << endl;
    vector<int> arr(n);

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    int result = oddOccurringElement(arr);

    cout << result << endl;


    return 0;
}