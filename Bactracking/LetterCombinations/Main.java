/*
Problem : Letter Combinations of a Phone Number (LC - 17)
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void getletterCombinations(String digits, int index, StringBuilder currentCombination,List<String> combinations, HashMap<Character,String> numToChar){
        // Base Case
        if(index >= digits.length()){
            combinations.add(currentCombination.toString());
            return;
        }

        // try all values at particular digit
        for(char ch : numToChar.get(digits.charAt(index)).toCharArray()){
            currentCombination.append(ch);
            getletterCombinations(digits,index+1,currentCombination,combinations,numToChar);
            currentCombination.deleteCharAt(currentCombination.length()-1); // backTrack
        }
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character,String> numToChar = new HashMap<>();
        numToChar.put('2', "abc");
        numToChar.put('3', "def");
        numToChar.put('4', "ghi");
        numToChar.put('5', "jkl");
        numToChar.put('6', "mno");
        numToChar.put('7', "pqrs");
        numToChar.put('8', "tuv");
        numToChar.put('9', "wxyz");
        List<String> combinations = new ArrayList<>();

        StringBuilder currentCombination = new StringBuilder("");
        getletterCombinations(digits,0,currentCombination,combinations,numToChar);
        return combinations;
    }

    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        for(String str: ans){
            System.out.println(str);
        } 
    }
}
