/*
Problem : Print Elements of Array, Straight and reverse
*/

public class PrintArray{

    public static void printArray(int[] arr,int index){

        if(index >= arr.length){
            return;
        }

        System.out.print(arr[index]+" ");
        printArray(arr, index+1);
    }

    public static void printArrayReverse(int[] arr,int index){

        if(index >= arr.length){
            return;
        }

        printArrayReverse(arr, index+1);
        System.out.print(arr[index]+" ");
    }

    public static void main(String[] args) {
        int[] arr = {3,2,4,5,7,21,54,23,562,23};

        System.out.println("Normal Print : ");
        printArray(arr, 0);
        System.out.println();

        System.out.println("Reverse Print : ");
        printArrayReverse(arr, 0);
        System.out.println();
    }
}