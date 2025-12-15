/*
Problem : Print all Odd and Even numbers in Array
*/

#include <iostream>
#include <vector>
using namespace std;

void printOdd(vector<int>& arr,int index){
    if(index >= arr.size()) return;

    if(arr[index]&1){
        cout << arr[index] << " ";
    }

    printOdd(arr,index+1);
}

void printEven(vector<int>& arr, int index){
    if(index >= arr.size()) return;

    if(!(arr[index]&1)){
        cout << arr[index] << " ";
    }

    printEven(arr,index+1);
}

int main(){

    vector<int> arr = {2,3,4,5,6,7,8,9,10,11,13};

    cout << "Odd Numbers : " << endl;
    printOdd(arr,0);
    cout << endl;

    cout << "Even Numbers : " << endl;
    printEven(arr,0);
    cout << endl;



    return 0;
}