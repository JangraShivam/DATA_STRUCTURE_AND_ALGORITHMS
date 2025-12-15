public class OddEven {

    public static void printOdd(int[] arr,int index){

        if(index >= arr.length){
            return;
        }

        if((arr[index]&1) == 1){
            System.out.print(arr[index]+" ");
        }

        printOdd(arr, index+1);
    }

    public static void printEven(int[] arr,int index){

        if(index >= arr.length){
            return;
        }

        if((arr[index]&1) != 1){
            System.out.print(arr[index]+" ");
        }

        printEven(arr, index+1);
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,9,10,11,13};

        System.out.println("Odd Numbers : ");
        printOdd(arr, 0);
        System.out.println();

        System.out.println("Even Numbers : ");
        printEven(arr, 0);
        System.out.println();
    }
}
