/*
Problem : Check Array is sorted or not.
*/

public class CheckSorted{

    public static boolean isSorted(int[] arr, int index){
        // Base Case
        if(index >= arr.length) return true;

        // 2nd Base Case
        if(arr[index] < arr[index-1]) return false;

        return isSorted(arr, index+1);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};

        if(isSorted(arr, 1)){
            System.out.println("Array is Sorted");
        }
        else{
            System.out.println("Array is not sorted");
        }
    }
}