/*
Problem : Remove All Occurrences of a Substring (LeetCode - 1910)
*/

public class Main{

    public static void removeOccurrencesHelper(String s, int index, String part, StringBuilder ans){
        //Base case
        if(index >= s.length()) return;

        // Push current char into ans
        ans.append(s.charAt(index));

        int partIndex = part.length()-1;
        int ansIndex = ans.length()-1;

        // Match part in ans string
        while(partIndex >= 0 && ansIndex >= 0){
            if(part.charAt(partIndex) != ans.charAt(ansIndex)) break;
            partIndex--;
            ansIndex--;
        }

        // If partIndex < 0 then match found and remove it
        if(partIndex < 0){
            // ans was equal to part fully so empty it
            if(ansIndex < 0) ans.delete(0, ans.length());
            else ans = ans.delete(ansIndex+1,ans.length()); // remove part from end
        }

        removeOccurrencesHelper(s,index+1,part,ans);
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder ans = new StringBuilder("");
        removeOccurrencesHelper(s,0,part,ans);
        String answer = ans.toString();
        return answer;
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        System.out.println(removeOccurrences(s, part));
    }
}