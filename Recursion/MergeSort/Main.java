/*
Problem : Merge Sort
*/

import java.util.ArrayList;

public class Main{

    public static void mergeSortedArrays(int[] arr, int start, int end){

        int mid = start + (end - start)/2;

        // Create two empty arrays
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        // copy left and right array value into their respective array
        for(int i = start; i <= mid; i++) leftArray.add(arr[i]);
        for(int i = mid+1; i <= end; i++) rightArray.add(arr[i]);

        // merge logic for two sorted array
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int arrIndex = start;

        while(leftArrayIndex < leftArray.size() && rightArrayIndex < rightArray.size()){
            if(leftArray.get(leftArrayIndex) <= rightArray.get(rightArrayIndex)){
                arr[arrIndex++] = leftArray.get(leftArrayIndex++);
            }
            else{
                arr[arrIndex++] = rightArray.get(rightArrayIndex++);
            }
        }

        while(leftArrayIndex < leftArray.size()){
            arr[arrIndex++] = leftArray.get(leftArrayIndex++);
        }

        while(rightArrayIndex < rightArray.size()){
            arr[arrIndex++] = rightArray.get(rightArrayIndex++);
        }

    }

    public static void mergeSort(int[] arr, int start, int end){
        // Base Case
        if(start >= end) return;

        int mid = start + (end - start)/2;

        // left part
        mergeSort(arr, start, mid);
        // right part
        mergeSort(arr,mid+1,end);

        // merge left and right sorted array
        mergeSortedArrays(arr,start,end);

    }

    public static void main(String[] args) {
        int[] arr = {10,45,0,2,-1,78,42,-10,0,56};
        int start = 0;
        int end = arr.length - 1;
        mergeSort(arr,start,end);

        for(int i : arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }

}