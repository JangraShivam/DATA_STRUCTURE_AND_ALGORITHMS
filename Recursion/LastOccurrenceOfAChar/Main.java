/*
Problem : Given an input string and target character, find the last occurence of target char
*/

class Ans{
    public int value;
}

public class Main{

    // Method 1 : Search from left to right
    public static void findLTR(String input, char target, int index, Ans ans){
        // Target char is not in the string return -1
        if(index >= input.length()) return;

        // Target char found and store and update ans
        if(input.charAt(index) == target) ans.value = index;
        
        // Look for further occurence of target char
        findLTR(input,target,index+1,ans);
    }

    // Method 2 : Search from right to left
    public static int findRTL(String input, char target, int index){
        // Target char is not in the string return -1
        if(index < 0) return -1;

        // Target char found and return it because it is the last occurence
        if(input.charAt(index) == target) return index;

        return findRTL(input,target,index-1);
    }
    public static void main(String[] args) {
        String input = "aabsbsbfbg";
        char target = 'b';
        Ans ans = new  Ans();
        ans.value = -1;
        findLTR(input,target,0,ans);
        System.out.println("LTR : "+ans.value);
        System.out.println("RTL : "+ findRTL(input, target, input.length()-1));

        return;
    }
}