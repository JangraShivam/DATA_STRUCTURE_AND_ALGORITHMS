/*
Problem : Letter Tile Possibilities (LC - 1079)
*/

#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;


void getPossibilities(string& tiles, int index,string& sequence, unordered_set<string>& allSequences){
    // Base case 
    if(index >= tiles.size()){
        allSequences.insert(sequence);
        return;
    }

    // place all possible tiles in current position in seq
    for(int i = index; i <= tiles.size(); i++){
        // place empty tile
        if(i == tiles.size()) getPossibilities(tiles,index+1,sequence,allSequences);
        else{
            swap(tiles[index],tiles[i]);
            sequence.push_back(tiles[index]);
            getPossibilities(tiles,index+1,sequence,allSequences);
            // backtrack
            sequence.pop_back();
            swap(tiles[index],tiles[i]);
        }
        
    }
}

    
int numTilePossibilities(string tiles) {
    unordered_set<string> allSequences;
    string sequence;
    getPossibilities(tiles,0,sequence,allSequences);
    return allSequences.size()-1;
}

int main(){

    cout << numTilePossibilities("AAABBC") << endl;

    return 0;
}