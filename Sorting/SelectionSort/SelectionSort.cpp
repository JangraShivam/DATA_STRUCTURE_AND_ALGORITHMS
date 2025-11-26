# include <iostream>
# include <vector>
using namespace std;

// Selection Sort implementation
void selectionSort(vector<int>& arr){

    int size = arr.size(); // size of array

    /*
        go to each position from left to right and
        find the minimum element to its right and replace it with minimum element
        then go to next position then again find min element to its right
    */
    for(int i = 0; i < size-1; i++){

        int minIndex = i; // intilaize or assume that current position element is minimum

        // look for minimum element to right of position
        for(int j = i + 1; j < size; j++){
            // if minimum element is found then update minimum element index
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }

        // swap the current position element with position of minimum element
        swap(arr[i],arr[minIndex]);
    }
    
}


int main(){

    int size;
    cin >> size;

    vector<int> arr(size);
    for(int i = 0; i < size; i++){
        cin >> arr[i];
    }

    selectionSort(arr);

    for(int i : arr){
        cout << i << " ";
    }
    cout << endl;

    return 0;

    return 0;
}