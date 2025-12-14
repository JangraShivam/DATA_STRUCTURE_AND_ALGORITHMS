/*
Problem : Calculate Sum of values from 1 to n
*/

import java.util.Scanner;
public class GetSum {
    
    public static int getSum(int n){
        if(n <= 0) return 0;

        int recursionAns = getSum(n-1);
        return n + recursionAns;
    }

    public static void main(String[] args) {
        System.out.println("Enter N : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println("Sum : " + getSum(n));
    }
}
