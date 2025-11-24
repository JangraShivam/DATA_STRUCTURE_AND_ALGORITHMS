import java.util.Scanner;
public class BubbleSort{
    
    // Bubble Sort Implementation
    public static void bubbleSort(int[] arr){

        /*
            Intialize round variable to 1, 
            In each round we try to place largest number to its correct position
            for round 1 -> 1st largest
            for round 2 -> 2nd largest and so on..
        */
        int round = 1; 
        
        /*
            There will be rounds one less than array size
            because in last round the last element will be in its correct position
            as all largest element are already placed correctly
            So loop over each round to place them correctly
        */
        while(round < arr.length){

            int i = 1; // Intialize i to 1
            
            /*
                iterate over array and as we find previous element greater than current
                swap them because it is larger and will be placed in right of current element
                in this way we find largest element as it will be at rightmost position
                
                As we placed largest element in correct position in a round then in next one
                that position will be banned or there will be no point in comparing them as they
                are larger than rest of elements -> i <= arr.size() - round
            */
            while(i <= arr.length - round){

                // place larger element right
                if(arr[i] < arr[i-1]){
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }

                i++;
            }

            // increase round count
            round++;
        }
    }

    // Bubble Sort with flag Implementation
    public static void bubbleSortWithFlag(int[] arr){

        /*
            Intialize round variable to 1, 
            In each round we try to place largest number to its correct position
            for round 1 -> 1st largest
            for round 2 -> 2nd largest and so on..
        */
        int round = 1; 
        
        /*
            There will be rounds one less than array size
            because in last round the last element will be in its correct position
            as all largest element are already placed correctly
            So loop over each round to place them correctly
        */
        while(round < arr.length){

            /*
                Use a flag to reduce rounds 
                if there were no swaps in a round that mean array is sorted
                no need for further rounds
            */
            boolean swapped = false; // intialize swapped to false
            int i = 1; // Intialize i to 1
            
            /*
                iterate over array and as we find previous element greater than current
                swap them because it is larger and will be placed in right of current element
                in this way we find largest element as it will be at rightmost position
                
                As we placed largest element in correct position in a round then in next one
                that position will be banned or there will be no point in comparing them as they
                are larger than rest of elements -> i <= arr.size() - round
            */
            while(i <= arr.length - round){

                // place larger element right
                if(arr[i] < arr[i-1]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    swapped = true; // swap happen so set swapped to true
                }

                i++;
            }

            // if swapped is false no swapping happened so break out of loop
            if(!swapped) break;

            // increase round count
            round++;
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

        bubbleSort(arr);

        for(int i : arr){
            System.out.println(i);
        }

    }
}