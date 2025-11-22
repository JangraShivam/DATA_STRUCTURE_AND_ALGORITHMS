/*
Problem : Koko Eating Bananas (LC - 875)

Description : 
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. 
Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23

Constraints:
-> 1 <= piles.length <= 104
-> piles.length <= h <= 109
-> 1 <= piles[i] <= 109

*/

# include <iostream>
#include <vector>
using namespace std;

// Check whether the koko eating speed is sufficient for eating all piles in h hours
bool checkSpeed(int speed, vector<int>& piles,int h){
    // Simulate koko eating with speed value
    for(int pile : piles){
        h = h - (pile/speed) - (pile%speed != 0); //update h 
        if(h < 0) return false; // if h < 0 then time is up and koko gets caught
    }
    return true; // koko successfully ate all the bananas
}

// Calculate the minimum eating speed for koko
int minEatingSpeed(vector<int>& piles, int h) {

    int minSpeed = 1; // minimum eating speed for koko
    int maxSpeed = piles[0]; // maximum eating speed for koko, more than this there will be no change in answer

    // max eating speed = max value of pile in piles array
    for(int i : piles){
        maxSpeed = max(maxSpeed,i);
    }

    // Intialize koko speed 
    int kokoSpeed = -1;

    // Binary search on search space 
    while(minSpeed <= maxSpeed){

        // midspeed or possible speed for koko
        int midSpeed = minSpeed + (maxSpeed - minSpeed)/2;

        // check if koko can eat all piles in h hours with midspeed
        if(checkSpeed(midSpeed,piles,h)){
            // store and update the kokospeed
            kokoSpeed = midSpeed;
            maxSpeed = midSpeed - 1; // move left 
        }
        else{
            minSpeed = midSpeed + 1; // move right
        }
    }

    // return minimum kokospeed
    return kokoSpeed;
}

int main(){

    cout << "Enter the size of piles array : ";
    int size;
    cin >> size;

    cout << "Enter pile elements of piles array : ";
    vector<int> piles(size);
    for(int i = 0; i < size; i++){
        cin >> piles[i];
    }

    cout << "Enter value of hours : ";
    int h;
    cin >> h;

    int answer = minEatingSpeed(piles,h);
    cout << "Answer is : " << answer << endl;

    return 0;
}