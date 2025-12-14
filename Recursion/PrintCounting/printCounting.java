/*
Problem : Print Counting from 1 to N. and in reverse N to 1
*/

import java.util.Scanner;

public class printCounting {
    
    public static void print(int n){
        // Base Case
        if(n <= 0) return;

        // Head Recusrsion
        print(n-1);
        System.out.print(n + " ");
    }

    public static void printReverse(int n){
        if(n <= 0) return;

        System.out.print(n + " ");

        //Tail recursion
        printReverse(n-1);
    }

    public static void main(String[] args) {
        
        System.out.println("Enter N : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.print("Normal Printing : " );
        print(n);
        System.out.println();

        System.out.print("Reverse Printing : " );
        printReverse(n);
        System.out.println();
    }
}
