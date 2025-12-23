/*
Problem : Minimum Cost For Tickets (LC 983)
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int mincostTicketsHelper(vector<int>& days,int index, vector<int>& costs){
    // Base Case or Travel end
    if(index >= days.size()) return 0;

    // get current day
    int currentDay = days[index];

    // get one day pass
    int oneDayPass = costs[0] + mincostTicketsHelper(days,index+1,costs);

    // get seven day pass and cover the next seven days travel days[index] < currentDay + 7
    while(index < days.size() && days[index] < currentDay + 7) index++;
    int sevendayPass = costs[1] + mincostTicketsHelper(days,index,costs);

    // get thirty day pass and cover the next seven days travel days[index] < currentDay + 30
    while(index < days.size() && days[index] < currentDay + 30) index++;
    int thirtyDayPass = costs[2] + mincostTicketsHelper(days,index,costs);

    // return minimum
    return min({oneDayPass,sevendayPass,thirtyDayPass});
}

int mincostTickets(vector<int>& days, vector<int>& costs) {
    return mincostTicketsHelper(days,0,costs);
}

int main(){

    vector<int> days = {1,4,6,7,8,20};
    vector<int> costs = {2,7,15};

    cout << mincostTickets(days,costs) << endl;

    return 0;
}