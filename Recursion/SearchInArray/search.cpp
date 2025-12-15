/*
Problem : Search in array (linear Search using recursion)
*/

#include <iostream>
#include <vector>
using namespace std;

int linearSearch(vector<int>& arr, int index,int& target){
    // First Base case
    if(index >= arr.size()){
        return -1;
    }

    // Second Base Case
    if(arr[index] == target){
        return index;
    }
    
    int answer = linearSearch(arr,index+1,target);
    return answer;
}

int main(){

    vector<int> arr = {2,5,89,-1,78,32,-98,100};
    int target = 78;

    int foundIndex = linearSearch(arr,0,target);

    if(foundIndex != -1){
        cout << "Element found at " << foundIndex << endl;
    }
    else{
        cout << "Element is not present in array" << endl;
    }

    return 0;
}