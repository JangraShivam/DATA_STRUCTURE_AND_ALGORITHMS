import java.util.Scanner;

public class SelectionSort{

    // Selection Sort implementation
    public static void selectionSort(int[] arr){

        int size = arr.length; // size of array

        /*
            go to each position from left to right and
            find the minimum element to its right and replace it with minimum element
            then go to next position then again find min element to its right
        */
        for(int i = 0; i < size-1; i++){

            int minIndex = i; // intilaize or assume that current position element is minimum

            // look for minimum element to right of position
            for(int j = i + 1; j < size; j++){
                // if minimum element is found then update minimum element index
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            // swap the current position element with position of minimum element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        
    }
    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();

        selectionSort(arr);

        for(int i : arr){
            System.out.println(i);
        }
    }
}