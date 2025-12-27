/*
Problem : Permutations (LC - 46)
*/

import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void getPossiblePermuatations(int[] currentPermuatation, int index, List<List<Integer>> allPermutations){
        // Base Case 
        if(index >= currentPermuatation.length){
            List<Integer> permutation = new ArrayList<>();
            for(int i : currentPermuatation) permutation.add(i);
            allPermutations.add(permutation);
            return;
        }

        // Permutation Logic
        for(int j = index; j < currentPermuatation.length; j++){
            int temp = currentPermuatation[index];
            currentPermuatation[index] = currentPermuatation[j];
            currentPermuatation[j] = temp;
            
            getPossiblePermuatations(currentPermuatation,index+1,allPermutations);
            
            // Backtrack
            temp = currentPermuatation[index];
            currentPermuatation[index] = currentPermuatation[j];
            currentPermuatation[j] = temp;
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        getPossiblePermuatations(nums,0,allPermutations);
        return allPermutations;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> answer = permute(nums);

        for(int i = 0; i < answer.size(); i++){
            for(int j = 0; j < answer.get(0).size(); j++){
                System.out.print(answer.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
    
}