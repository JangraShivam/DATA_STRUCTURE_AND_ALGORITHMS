/*
Problem : Matchsticks to Square (LC - 473)
*/

#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>
using namespace std;

bool makeSquareHelper(vector<int>& matchsticks, int index, vector<int>& sidesLength){
    // Base Case
    if(index >= matchsticks.size()){
        return sidesLength[0] == sidesLength[1] == sidesLength[2] == sidesLength[3];
    }
        
    // Try to add current matchsticks to all 4 sides
    for(int i = 0; i < 4; i++){
        // the side should not exceed 
        if(sidesLength[i] - matchsticks[index] >= 0){
            sidesLength[i] -= matchsticks[index];
            if(makeSquareHelper(matchsticks,index+1,sidesLength)) return true;
            else{
                sidesLength[i] += matchsticks[index]; // backtrack
            }
        }
    }

    return false;
}

bool makesquare(vector<int>& matchsticks) {
    // get total length sum
    int sum = accumulate(matchsticks.begin(),matchsticks.end(),0);
    // check if sum can be divided into 4 parts
    if(sum%4 != 0) return false;

    // intialize sides with their expected length
    vector<int> sidesLength (4,sum/4);

    // sort in decrease order to reduce recursive calls
    sort(matchsticks.rbegin(),matchsticks.rend());
    return makeSquareHelper(matchsticks,0,sidesLength);
}

int main(){


    vector<int> matchsticks = {1,1,2,2,2};
    cout << makesquare(matchsticks) << endl;

    return 0;
}