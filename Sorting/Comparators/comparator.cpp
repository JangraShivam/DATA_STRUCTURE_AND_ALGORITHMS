# include <iostream>
# include <vector>
# include <algorithm>
using namespace std;

void print(vector<int>& v){
    cout << "Printing v : " << endl;

    for(int i : v){
        cout << i << " ";
    }
    cout << endl << endl;
}   
void print(vector<vector<int>>& a){
    cout << "Printing a : " << endl;

    for(auto i : a){
        cout << "{" << i[0] << "," << i[1] << "},";
    }
    cout << endl << endl;
}

// Comparator function
bool myComparator(int& a,int& b){
    // return a < b; // increasing order or default
    return a > b; // descending order
}

// Comparator function -> sort 2d array by inside array 1st
bool myComparator1(vector<int>& a,vector<int>& b){
    return a[1] < b[1]; // increasing order
}

int main(){

    // Intialize an unsorted vector or array
    vector<int> v = {8,1,3,0,9,10,43,23};

    /*
        Sort v using inbuilt sort function
        it sort v in ascending order
    */
    sort(v.begin(),v.end());
    print(v);

    /*
        To sort v in descending order we need to pass a function
        or comparator to sort function, so it can sort v in descending order
    */
    v = {8,1,3,0,9,10,43,23};
    sort(v.begin(),v.end(),myComparator); // passed a comparator function 'myComparator'
    print(v);

    // intialize a 2d vector
    vector<vector<int>> a = {{1,2},{89,21},{6,4},{85,32},{98,99}};

    /*
        use sort to sort the 'a' and it will sort it
        in the asceding order of 0th element of inside vector
    */
    sort(a.begin(),a.end()); // passed a comparator function 'myComparator'
    print(a);

    /*
        sort 'a' by the inside vectors 1st index or any index
        just pass a comparator function and change the logic as needed
    */
    a = {{1,2},{89,21},{6,4},{85,32},{98,99}};
    sort(a.begin(),a.end(),myComparator1); // passed a comparator function 'myComparator1'
    print(a);


    return 0;
}