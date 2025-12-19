/*
Problem : Given an array, print all subarrays
*/

public class Main{

    public static void printAllSubArrays(int[] arr, int start, int end){
        // Base Case
        if(end >= arr.length) return;

        // Print the current subarray
        for(int i = start; i <= end; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        // recusrion print all subarray with same start 
        printAllSubArrays(arr,start,end+1);

        // return to find the start
        if(start != end) return;

        // Increment start 
        start++;
        end = start;

        // Print all subarray with next start index
        printAllSubArrays(arr,start,end);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printAllSubArrays(arr,0,0);
    }
}