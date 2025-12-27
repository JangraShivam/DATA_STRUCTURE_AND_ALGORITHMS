/*
Problem : Merge Sort
*/

#include <iostream>
#include <vector>
using namespace std;

void mergeSortedArrays(vector<int>& arr, int start, int end){

    int mid = start + (end - start)/2;

    // Create two empty arrays
    vector<int> leftArray;
    vector<int> rightArray;

    // copy left and right array value into their respective array
    for(int i = start; i <= mid; i++) leftArray.push_back(arr[i]);
    for(int i = mid+1; i <= end; i++) rightArray.push_back(arr[i]);

    // merge logic for two sorted array
    int leftArrayIndex = 0;
    int rightArrayIndex = 0;
    int arrIndex = start;

    while(leftArrayIndex < leftArray.size() && rightArrayIndex < rightArray.size()){
        if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]){
            arr[arrIndex++] = leftArray[leftArrayIndex++];
        }
        else{
            arr[arrIndex++] = rightArray[rightArrayIndex++];
        }
    }

    while(leftArrayIndex < leftArray.size()){
        arr[arrIndex++] = leftArray[leftArrayIndex++];
    }

    while(rightArrayIndex < rightArray.size()){
        arr[arrIndex++] = rightArray[rightArrayIndex++];
    }

}

void mergeSort(vector<int>& arr, int start, int end){
    // Base Case
    if(start >= end) return;

    int mid = start + (end - start)/2;

    // left part
    mergeSort(arr, start, mid);
    // right part
    mergeSort(arr,mid+1,end);

    // merge left and right sorted array
    mergeSortedArrays(arr,start,end);

}

int main(){

    vector<int> arr = {10,45,0,2,-1,78,42,-10,0,56};
    int start = 0;
    int end = arr.size() - 1;
    mergeSort(arr,start,end);

    for(int i : arr){
        cout << i << " ";
    }

    cout << endl;

    return 0;
}