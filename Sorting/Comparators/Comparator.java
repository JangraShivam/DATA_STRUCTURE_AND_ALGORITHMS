import java.util.Arrays;

public class Comparator {
    
    public static void print(int[] v){
        System.out.println("Printing v : ");

        for(int i : v){
            System.out.print(i+" ");
        }
        System.out.println("\n");
    }
    public static void print(int[][] a){
        System.out.println("Printing a : ");

        for(int[] i : a){
            System.out.print("{" + i[0] + "," + i[1] + "},");
        }
        System.out.println("\n");
    }

    public static void reverse(int[] v){
        int i = 0;
        int j = v.length-1;

        while(i < j){
            int temp = v[j];
            v[j]  = v[i];
            v[i] = temp;

            j--;
            i++;
        }
    }

    public static void main(String[] args) {
        // Intialize an unsorted vector or array
        int[] v = {8,1,3,0,9,10,43,23};

        /*
            Sort v using inbuilt sort function
            it sort v in ascending order
        */
        Arrays.sort(v);
        print(v);

        /*
            To sort v in descending order there is no inbuilt
            method for primitives types like int
            we can reverse the array after it is sorted
        */
        int[] x = {8,1,3,0,9,10,43,23};
        Arrays.sort(x);
        reverse(x);
        print(x);


        // intialize a 2d vector
        int[][] a = {{1,2},{89,21},{6,4},{85,32},{98,99}};

        /*
            use sort to sort the 'a' and it will sort it
            in the asceding order of 0th element of inside vector
        */

        System.out.println("Sorting 2d array : ");
        Arrays.sort(a, (p, q) -> {
            return p[0] - q[0];
        });
        print(a);
        Arrays.sort(a, (p, q) -> {
            return q[0] - p[0];
        });
        print(a);


        /*
            sort 'a' by the inside vectors 1st index or any index
            just pass a comparator function and change the logic as needed
        */
        int[][] t = {{1,2},{89,21},{6,4},{85,32},{98,99}};

        System.out.println("Sorted by 1st index : ");
        Arrays.sort(t, (p, q) -> {
            return p[1] - q[1];
        });
        print(t);
        Arrays.sort(t, (p, q) -> {
            return q[1] - p[1];
        });
        print(t);
    }
}
