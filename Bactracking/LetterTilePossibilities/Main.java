/*
Problem : Letter Tile Possibilities (LC - 1079)
*/

import java.util.HashSet;

public class Main {

    public static void getPossibilities(StringBuilder tiles, int index, StringBuilder sequence, HashSet<String> allSequences){
        // Base case 
        if(index >= tiles.length()){
            allSequences.add(sequence.toString());
            return;
        }

        // place all possible tiles in current position in seq
        for(int i = index; i <= tiles.length(); i++){
            // place empty tile
            if(i == tiles.length()) getPossibilities(tiles,index+1,sequence,allSequences);
            else{
                Character temp = tiles.charAt(index);
                tiles.setCharAt(index, tiles.charAt(i));
                tiles.setCharAt(i, temp);

                sequence.append(tiles.charAt(index));
                getPossibilities(tiles,index+1,sequence,allSequences);

                // backtrack
                sequence.deleteCharAt(sequence.length()-1);
                temp = tiles.charAt(index);
                tiles.setCharAt(index, tiles.charAt(i));
                tiles.setCharAt(i, temp);
            }
            
        }
    }

        
    public static int numTilePossibilities(String tiles) {
        HashSet<String> allSequences = new HashSet<>();
        StringBuilder sequence = new StringBuilder("");
        getPossibilities(new StringBuilder(tiles),0,sequence,allSequences);
        return allSequences.size()-1;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAABBC"));
    }
}
