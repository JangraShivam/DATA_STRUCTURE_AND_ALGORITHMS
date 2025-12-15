/*
Problem : Print Elements of Array, Straight and reverse
*/

#include <iostream>
#include <vector>
using namespace std;

void printArray(vector<int>& arr, int index){
    //Base Case
    if(index >= arr.size()){
        return;
    }

    cout << arr[index] << " ";
    printArray(arr,index+1);
}

void printArrayReverse(vector<int>& arr, int index){
    //Base Case
    if(index >= arr.size()){
        return;
    }

    printArrayReverse(arr,index+1);
    cout << arr[index] << " ";
}


int main(){

    vector<int> arr = {3,2,4,5,7,21,54,23,562,23};

    cout << "Normal Print : " << endl;
    printArray(arr,0);
    cout << endl;

    cout << "Reverse Print : " << endl;
    printArrayReverse(arr,0);
    cout << endl;

    return 0;
}