/*
Problem : For a given n, return its factorial using recursion
Ex: n = 5, return 5! = 120

*/


import java.util.Scanner;

public class Factorial{

    public static int getFactorial(int n){

        // Base Case
        if(n <= 1) return 1;

        int recursionAns = getFactorial(n-1);
        return n * recursionAns;
    }

    public static void main(String[] args) {
        
        System.out.print("Enter n : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println("Factorial of " + n + " is : " + getFactorial(n));

        return;
    }
}