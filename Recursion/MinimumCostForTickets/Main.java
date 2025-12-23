/*
Problem : Minimum Cost For Tickets (LC 983)
*/

public class Main{

    public static int mincostTicketsHelper(int[] days,int index, int[] costs){
        // Base Case or Travel end
        if(index >= days.length) return 0;

        // get current day
        int currentDay = days[index];

        // get one day pass
        int oneDayPass = costs[0] + mincostTicketsHelper(days,index+1,costs);

        // get seven day pass and cover the next seven days travel days[index] < currentDay + 7
        while(index < days.length && days[index] < currentDay + 7) index++;
        int sevendayPass = costs[1] + mincostTicketsHelper(days,index,costs);

        // get thirty day pass and cover the next seven days travel days[index] < currentDay + 30
        while(index < days.length && days[index] < currentDay + 30) index++;
        int thirtyDayPass = costs[2] + mincostTicketsHelper(days,index,costs);

        // return minimum
        return Math.min(oneDayPass,Math.min(sevendayPass, thirtyDayPass));
    }

    public static int mincostTickets(int[] days, int[] costs) {
        return mincostTicketsHelper(days,0,costs);
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};

        System.out.println(mincostTickets(days, costs));
    }
}