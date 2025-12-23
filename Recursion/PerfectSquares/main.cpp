/*
Problem : Perfect Squares (LC 279)
*/

#include <iostream>
using namespace std;

int numSquares(int n) {
    // Base Case
    if(n <= 0) return 0;

    // Intialize Minimum answer
    int minAns = INT32_MAX;

    // Try different perfect sqaures less than n
    for(int i = 1; i*i <= n; i++){
        int ans = 1 + numSquares(n - (i*i));
        minAns = min(minAns,ans); // update minAns
    }

    return minAns;
}

int main(){
    cout << numSquares(12) << endl;

    return 0;
}