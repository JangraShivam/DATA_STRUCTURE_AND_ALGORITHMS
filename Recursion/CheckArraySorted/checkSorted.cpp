/*
Problem : Check Array is sorted or not.
*/

#include <iostream>
#include <vector>
using namespace std;

bool isSorted(vector<int>& arr, int index){
    //Base case
    if(index >= arr.size()) return true;

    // 2nd Base Case
    if(arr[index] < arr[index-1]) return false;

    return isSorted(arr,index+1);
}

int main(){

    vector<int> arr = {1,2,3,4,5,6,7};

    if(isSorted(arr,1)){
        cout << "Array is sorted" << endl;
    }
    else{
        cout << "Array is not sorted" << endl;
    }


    return 0;
}