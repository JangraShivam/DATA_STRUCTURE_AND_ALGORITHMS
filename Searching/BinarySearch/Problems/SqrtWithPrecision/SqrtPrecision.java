/*
Problem : Square Root Using Binary Search (with Precision)

Description
Given a non-negative number x and an integer p representing the required number of digits after the decimal, 
compute the square root of x up to p decimal places. You must not use built-in functions like sqrt(); 
instead, implement the solution using binary search (also known as search-space binary search).
Your algorithm should run efficiently for large values of x and high precision p.

Input:
-> An integer or floating-point number x 
-> An integer p such that 0 ≤ p ≤ 10

Output
-> A floating-point value representing √x, rounded or truncated to p decimal places.

Constraints
-> Binary search must be used.
-> Time complexity should be approximately: O(log(x) + p * 10)

Expected Approach:
Use integer binary search to compute the integer part of the square root.
Use linear expansion / fractional binary search to compute each decimal place, 
one at a time, up to precision p.

The main motive is to use binary search in this problem
there might be some regularities because of type conversion or input sizes
*/

import java.util.Scanner;

public class SqrtPrecision{
    
    public static double sqrtPrecision2(double x, double p){
        double precision = 1/Math.pow(10, p);

        double start = 0;
        double end = x;
        double answer = -1;

        while (end - start >= precision) {
            double mid = start + (end - start)/2;

            if(mid * mid <= x){
                answer = mid;
                start = mid + precision;
            }
            else{
                end = mid - precision;
            }
        }

        return answer;
    }

    public static double sqrtPrecision(double x, int p){

        // Integer Part
        long start = 0;
        long end = (long)(x);

        double answer = -1;
     
        while(start <= end){
            long mid = start + (end - start)/2;
            double midSq = mid*mid;

            if(midSq <= x){
                answer = (double)mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        //Fraction part
        int precision = 1;
        int denom = 10;

        while(precision <= p){
            int s = 0;
            int e = 9;
            double ans = answer;
            
            while(s <= e){
                int m = (s+e)/2;
                
                double possAnswer = ans + (double)(m)/(double)(denom);

                if(possAnswer*possAnswer <= x){
                    answer = possAnswer;
                    s = m + 1;
                }
                else{
                    e = m - 1;
                }
            }

            denom *= 10;
            precision++;
        }

        return answer;
    }

    public static void main(String[] argsthrows){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number : ");
        double x = sc.nextDouble();
        System.out.println("Enter precision : ");
        int p = sc.nextInt();

        sc.close();

        System.out.println("Ans with method 1:");
        double answer = sqrtPrecision(x, p);
        System.out.printf("%." + p + "f", answer);
        System.out.println();

        System.out.println("Ans with method 2:");
        answer = sqrtPrecision2(x, p);
        System.out.printf("%." + p + "f", answer);


    }
}   