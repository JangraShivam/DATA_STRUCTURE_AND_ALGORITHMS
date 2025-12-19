/*
Problem : Check if a string is palindrome or not
*/

public class Main{

    public static boolean isPalindrome(String input, int start, int end){
        // Base case
        if(start >= end) return true;

        // Another Base Case
        if(input.charAt(start) != input.charAt(end)) return false;

        return isPalindrome(input, start+1, end-1);
    }

    public static void main(String[] args) {
        String input = "ababa";
        System.out.println("palindrome ? " + isPalindrome(input, 0, input.length()-1));
    }

}