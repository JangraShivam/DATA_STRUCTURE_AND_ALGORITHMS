/*
Problem : House Robber (LeetCode 198)
*/

#include <iostream>
#include <vector>
using namespace std;

int maxRobbingProfit(vector<int>& houses, int index){
    // Base Case
    if(index >= houses.size()) return 0;

    // rob current house and skip next house or include case
    int robCurrentHouse = houses[index] + maxRobbingProfit(houses,index+2);

    // Dont rob current house and go to next
    int notRob = maxRobbingProfit(houses,index+1);

    // return maximum profit
    return max(robCurrentHouse,notRob);
}

int main(){

    vector<int> houses = {2,7,9,3,1};

    cout << "Maximum Profit : " << maxRobbingProfit(houses,0) << endl;

    return 0;
}