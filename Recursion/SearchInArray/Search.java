/*
Problem : Search in array (linear Search using recursion)
*/

public class Search{

    public static int linearSearch(int[] arr, int index, int target){
        if(index >= arr.length) return -1;

        if(arr[index] == target) return index;

        return linearSearch(arr, index+1, target);
    }
    public static void main(String[] args){
        int[] arr = {2,5,89,-1,78,32,-98,100};
        int target = -1;
        
        int foundIndex = linearSearch(arr,0,target);

        if(foundIndex != -1){
            System.out.println("Element found at "+foundIndex);
        }
        else{
            System.out.println("Element is not present in array");
        }
    }
}