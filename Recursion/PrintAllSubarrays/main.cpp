/*
Problem : Given an array, print all subarrays
*/

#include <iostream>
#include <vector>
using namespace std;

void printAllSubArrays(vector<int>& arr, int start, int end){
    // Base Case
    if(end >= arr.size()) return;

    // Print the current subarray
    for(int i = start; i <= end; i++){
        cout << arr[i] << " ";
    }
    cout << endl;

    // recusrion print all subarray with same start 
    printAllSubArrays(arr,start,end+1);

    // return to find the start
    if(start != end) return;

    // Increment start 
    start++;
    end = start;

    // Print all subarray with next start index
    printAllSubArrays(arr,start,end);
}

int main(){

    vector<int> arr = {1,2,3,4,5};
    printAllSubArrays(arr,0,0);

    return 0;
}