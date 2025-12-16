/*
Problem : Coin Change (LeetCode 322)
*/

#include <iostream>
#include <vector>
using namespace std;

int coinChange(vector<int>& coins, int amount){
    // base case
    if(amount == 0) return 0;

    int minCoinChange = -1;

    for(int coin : coins){
        if(coin <= amount){
            int recursionAns = coinChange(coins,amount-coin);

            if(recursionAns != -1){
                if(minCoinChange == -1) minCoinChange = 1 + recursionAns;
                else minCoinChange = min(minCoinChange,1 + recursionAns);
            }
        }
    }

    return minCoinChange;
}

int main(){

    vector<int> coins = {1,2,5};
    int amount = 11;

    cout << coinChange(coins,amount) << endl;

    return 0;
}