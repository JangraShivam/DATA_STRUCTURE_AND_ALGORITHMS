
# include <iostream>
# include <vector>
using namespace std;

// Bubble Sort Implementation
void bubbleSort(vector<int> &arr){

    /*
        Intialize round variable to 1, 
        In each round we try to place largest number to its correct position
        for round 1 -> 1st largest
        for round 2 -> 2nd largest and so on..
    */
    int round = 1; 
    
    /*
        There will be rounds one less than array size
        because in last round the last element will be in its correct position
        as all largest element are already placed correctly
        So loop over each round to place them correctly
    */
    while(round < arr.size()){

        int i = 1; // Intialize i to 1
        
        /*
            iterate over array and as we find previous element greater than current
            swap them because it is larger and will be placed in right of current element
            in this way we find largest element as it will be at rightmost position
            
            As we placed largest element in correct position in a round then in next one
            that position will be banned or there will be no point in comparing them as they
            are larger than rest of elements -> i <= arr.size() - round
        */
        while(i <= arr.size() - round){

            // place larger element right
            if(arr[i] < arr[i-1]) swap(arr[i],arr[i-1]);

            i++;
        }

        // increase round count
        round++;
    }
}

// Bubble Sort with flag Implementation
void bubbleSortWithFlag(vector<int> &arr){

    /*
        Intialize round variable to 1, 
        In each round we try to place largest number to its correct position
        for round 1 -> 1st largest
        for round 2 -> 2nd largest and so on..
    */
    int round = 1; 
    
    /*
        There will be rounds one less than array size
        because in last round the last element will be in its correct position
        as all largest element are already placed correctly
        So loop over each round to place them correctly
    */
    while(round < arr.size()){

        /*
            Use a flag to reduce rounds 
            if there were no swaps in a round that mean array is sorted
            no need for further rounds
        */
        bool swapped = false; // intialize swapped to false
        int i = 1; // Intialize i to 1
        
        /*
            iterate over array and as we find previous element greater than current
            swap them because it is larger and will be placed in right of current element
            in this way we find largest element as it will be at rightmost position
            
            As we placed largest element in correct position in a round then in next one
            that position will be banned or there will be no point in comparing them as they
            are larger than rest of elements -> i <= arr.size() - round
        */
        while(i <= arr.size() - round){

            // place larger element right
            if(arr[i] < arr[i-1]) {
                swap(arr[i],arr[i-1]);
                swapped = true; // swap happen so set swapped to true
            }

            i++;
        }

        // if swapped is false no swapping happened so break out of loop
        if(!swapped) break;

        // increase round count
        round++;
    }
}

int main(){

    
    int size;
    cin >> size;

    vector<int> arr(size);
    for(int i = 0; i < size; i++){
        cin >> arr[i];
    }

    bubbleSort(arr);

    for(int i : arr){
        cout << i << " ";
    }
    cout << endl;

    return 0;
}