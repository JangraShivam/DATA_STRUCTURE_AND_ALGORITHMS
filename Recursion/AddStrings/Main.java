/*
Problem : Add Strings (Leetcode - 415)
*/

public class Main{

    public static void add(String num1, int n1, String num2, int n2, int carry, StringBuilder ans){
        if(n1 < 0 && n2 < 0){
            if(carry != 0) ans.append('1');
            return;
        }

        int num1Digit = (n1 >= 0) ? (num1.charAt(n1) - '0') : 0;
        int num2Digit = (n2 >= 0) ? (num2.charAt(n2) - '0') : 0;
        int sum = num1Digit + num2Digit + carry;
        carry = sum/10;
        int digit = sum%10;

        ans.append((char)(digit +'0'));
        
        add(num1,n1-1,num2,n2-1,carry,ans);
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        add(num1,num1.length()-1, num2, num2.length()-1, 0, ans);
        String reversed = new StringBuilder(ans).reverse().toString();
        return reversed;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "23";

        System.out.println("Sum: " + addStrings(num1, num2));
    }
}