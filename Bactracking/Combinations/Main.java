/*
Problem : Combinations (LC - 77)
*/

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void getCombinations(int n, int k, List<Integer> currentCombination, List<List<Integer>> allCombinations){
        // Base Case 
        if(k == 0){
            List<Integer> combination = new ArrayList<>();
            for(int i : currentCombination) combination.add(i);
            allCombinations.add(combination);
            return;
        }

        // combination logic
        for(int i = n; i > 0; i--){
            currentCombination.add(i);
            getCombinations(i-1,k-1,currentCombination,allCombinations);
            currentCombination.remove(currentCombination.size()-1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        getCombinations(n,k,currentCombination,allCombinations);
        return allCombinations;
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = combine(4, 2);
        for(int i = 0; i < ans.size(); i++){
            for(int j = 0; j < ans.get(0).size(); j++){
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }


    }
}
