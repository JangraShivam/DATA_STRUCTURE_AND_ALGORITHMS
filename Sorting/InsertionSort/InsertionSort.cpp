#include <iostream>
# include <vector>
using namespace std;


// Insertion Sort implementation
void insertionSort(vector<int>& arr){

    int size = arr.size(); // size of array

    /*
        Loop over each element and put it in its right position
        in left part to the element which is sorted
    */
    for(int i = 1; i < size; i++){
        int index = i; // Index of element to be put in right position

        /*
            Loop back from index and compare element at index to its left adjacent
            or element at index-1, if its greater that means element at index must be
            left to index-1 element so swap them and decrement index and do it until a smaller element than element 
            at index appears and break out of loop 
        */
        while(index > 0){
            //check if Left element is greater than index element and swap
            if(arr[index] < arr[index-1]) swap(arr[index],arr[index-1]);
            else break; // break because index element is in right position

            index--; // decrement index
        }
    }

    
}


int main(){

    int size;
    cin >> size;

    vector<int> arr(size);
    for(int i = 0; i < size; i++){
        cin >> arr[i];
    }

    insertionSort(arr);

    for(int i : arr){
        cout << i << " ";
    }
    cout << endl;

    return 0;

    return 0;
}