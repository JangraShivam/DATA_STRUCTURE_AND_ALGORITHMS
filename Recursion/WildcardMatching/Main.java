/*
Problem : Wildcard Matching (LC 44)
*/

public class Main{

    public static boolean isMatchHelper(String s, int sIndex, String p, int pIndex){
        // Base Case for match
        if(sIndex >= s.length() && pIndex >= p.length()) return true;

        // Base Case for not match
        if(pIndex >= p.length()) return false;

        // match one char of s
        if((sIndex < s.length()) &&((p.charAt(pIndex) == '?') || s.charAt(sIndex) == p.charAt(pIndex))) return isMatchHelper(s,sIndex+1, p, pIndex+1);
        else if(p.charAt(pIndex) == '*'){
            // match empty char by *
            boolean matchEmptyChar = isMatchHelper(s,sIndex,p,pIndex+1);

            // match a char and only match when sindex is valid
            boolean matchChar = (sIndex < s.length()) ? isMatchHelper(s,sIndex+1, p, pIndex): false;

            return matchEmptyChar || matchChar;
        }
        else return false;
    }

    public static boolean isMatch(String s, String p) {
        return isMatchHelper(s,0,p,0);
    }
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}