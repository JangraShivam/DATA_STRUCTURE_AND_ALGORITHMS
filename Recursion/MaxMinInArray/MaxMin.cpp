/*
Problem : Find maximum and minimum element in array
*/

#include <iostream>
#include <vector>
using namespace std;

void maxElement(vector<int>& arr, int index, int& maximumElement){
    if(index >= arr.size()) return;

    maximumElement = max(maximumElement,arr[index]);
    maxElement(arr,index+1,maximumElement);
}

void minElement(vector<int>& arr, int index, int& minimumElement){
    if(index >= arr.size()) return;

    minimumElement = min(minimumElement,arr[index]);
    minElement(arr,index+1,minimumElement);
}


int main(){

    vector<int> arr = {2,45,78,0,-9,52,-987,1006};

    int maximumElement = INT32_MIN;
    maxElement(arr,0,maximumElement);
    cout << "Maximum Element : " << maximumElement << endl;


    int minimumElement = INT32_MAX;
    minElement(arr,0,minimumElement);
    cout << "Minimum Element : " << minimumElement << endl;

    return 0;
}