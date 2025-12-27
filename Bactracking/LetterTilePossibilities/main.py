"""
Problem : Letter Tile Possibilities (LC - 1079)
"""

def getPossibilities(tiles: list[str], index: int, sequence: list[str], allSequences: set) -> None:
    # Base case 
    if(index >= len(tiles)) :
        allSequences.add("".join(sequence))
        return

    # place all possible tiles in current position in seq
    for i in range(index, len(tiles) + 1) :
        # place empty tile
        if(i == len(tiles)) :
            getPossibilities(tiles,index+1,sequence,allSequences)
        else :
            tiles[index], tiles[i] = tiles[i], tiles[index]
            sequence.append(tiles[index])
            getPossibilities(tiles,index+1,sequence,allSequences)
            # backtrack
            sequence.pop()
            tiles[index], tiles[i] = tiles[i], tiles[index]

        


def numTilePossibilities(tiles: str) -> int:
    allSequences = set()
    tiles = list(tiles)
    sequence = []
    getPossibilities(tiles,0,sequence,allSequences)
    return len(allSequences) - 1


print(numTilePossibilities("AAABBC"))