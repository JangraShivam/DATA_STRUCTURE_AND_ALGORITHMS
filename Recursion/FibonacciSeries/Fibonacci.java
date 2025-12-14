/*
Problem : get fibonacci nth term
*/

import java.util.Scanner;

public class Fibonacci {
    public static int getFibonacci(int n){
        if(n <= 2) return 1;

        return getFibonacci(n-1) + getFibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Enter N : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(getFibonacci(n));
    }
}
