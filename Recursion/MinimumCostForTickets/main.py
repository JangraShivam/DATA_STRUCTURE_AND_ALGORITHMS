"""
Problem : Minimum Cost For Tickets (LC 983)
"""

from typing import List

def mincostTicketsHelper(days: List[int], index : int, costs: List[int]) -> int :
    # Base Case or Travel end
    if index >= len(days) :
        return 0

    # get current day
    currentDay = days[index]

    # get one day pass
    oneDayPass = costs[0] + mincostTicketsHelper(days,index+1,costs)

    # get seven day pass and cover the next seven days travel days[index] < currentDay + 7
    while index < len(days) and days[index] < currentDay + 7 : 
        index += 1
    sevendayPass = costs[1] + mincostTicketsHelper(days,index,costs)

    # get thirty day pass and cover the next seven days travel days[index] < currentDay + 30
    while index < len(days) and days[index] < currentDay + 30 : 
        index += 1
    thirtyDayPass = costs[2] + mincostTicketsHelper(days,index,costs)

    # return minimum
    return min({oneDayPass,sevendayPass,thirtyDayPass})


def mincostTickets(days: List[int], costs: List[int]) -> int:
    return mincostTicketsHelper(days,0,costs)



days = [1,4,6,7,8,20]
costs = [2,7,15]

print(mincostTickets(days,costs))