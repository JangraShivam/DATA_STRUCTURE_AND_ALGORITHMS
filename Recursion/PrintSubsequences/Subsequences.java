/*
Problem : Print all subsequences of a string
*/

import java.util.ArrayList;

public class Subsequences{

    public static void getSubsequences(String input, int index, String subseq, ArrayList<String> allSubsequences){
        // Base Case
        if(index >= input.length()){
            allSubsequences.add(subseq);
            return;
        }

        // exclude current char
        getSubsequences(input,index+1,subseq,allSubsequences);

        // include current char
        subseq = subseq + input.charAt(index);
        getSubsequences(input,index+1,subseq,allSubsequences);
    }
    public static void main(String[] args){
        String input = "abcd";
        String subseq = "";
        ArrayList<String> allSubsequences = new ArrayList<>();

        getSubsequences(input, 0, subseq, allSubsequences);

        System.out.println("Total Subsequences : "+allSubsequences.size());

        for(int i = 0; i < allSubsequences.size(); i++){
            System.out.println(i+1 + " Subsequence : " + allSubsequences.get(i));
        }
    }
}