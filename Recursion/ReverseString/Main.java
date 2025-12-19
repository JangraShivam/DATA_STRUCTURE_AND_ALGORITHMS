/*
Problem : Reverse a string
*/

public class Main{

    public static void reverseHelper(char[] inputCharArray, int start, int end){
        if(start >= end) return;

        char temp = inputCharArray[start];
        inputCharArray[start] = inputCharArray[end];
        inputCharArray[end] = temp; 

        reverseHelper(inputCharArray,start+1,end-1);
    }

    public static String reverse(String input){
     
        char[] inputCharArray = input.toCharArray();
        reverseHelper(inputCharArray, 0, inputCharArray.length-1);
        input = new String(inputCharArray);
        return input;
    }
    public static void main(String[] args) {
        String input = "abcdef";
        System.out.println(reverse(input));
    }
}