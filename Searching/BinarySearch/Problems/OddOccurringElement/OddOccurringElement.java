import java.util.Scanner;

public class OddOccurringElement {
    
    public static int oddOccurringElement(int[] arr){
        int startIndex = 0;
        int endIndex = arr.length- 1;

        while(startIndex <= endIndex){
            if(startIndex == endIndex) return arr[startIndex];

            int midIndex = startIndex + (endIndex - startIndex)/2;

            if(arr[midIndex] != arr[midIndex-1] && arr[midIndex] != arr[midIndex+1]){
                return arr[midIndex];
            }

            if(arr[midIndex] == arr[midIndex-1]){
                if(((midIndex-1)&1) == 1){
                    endIndex = midIndex - 2;
                }
                else{
                    startIndex = midIndex + 1;
                }
            }
            else{
                if((midIndex&1) == 1){
                    endIndex = midIndex - 1;
                }
                else{
                    startIndex = midIndex + 2;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        
        System.out.println("Enter the size of array : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        int result = oddOccurringElement(arr);
        System.out.println(result);

    }
}
