/*
Problem : Find maximum and minimum element in array
*/


public class MaxMin{

    public static int maxElement(int[] arr,int index){
        if(index >= arr.length - 1){
            return arr[index];
        }

        return Math.max(maxElement(arr, index+1), arr[index]);
    }

    public static int minElement(int[] arr,int index){
        if(index >= arr.length - 1){
            return arr[index];
        }

        return Math.min(minElement(arr, index+1), arr[index]);
    }
    public static void main(String[] args){

        int[] arr = {2,45,78,0,-9,52,-987,1006};

        System.out.println("Maximum Element : " + maxElement(arr, 0));
        System.out.println("Minimum Element : " + minElement(arr, 0));

    }
}