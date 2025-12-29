/*
Problem : Generate Parentheses (LC - 22)
*/

import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void generate(int open, int closed, StringBuilder current, List<String> allParenthesis){
        // Base Case
        if(open == 0 && closed == 0){
            allParenthesis.add(current.toString());
            return;
        }

        // If open paren can be used then use it
        if(open > 0){
            current.append('(');
            generate(open-1,closed,current,allParenthesis);
            current.deleteCharAt(current.length() - 1);
        }

        // only add close paren if there are a alone open paren
        if(closed > open){
            current.append(')');
            generate(open,closed-1,current,allParenthesis);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> allParenthesis = new ArrayList<>();
        StringBuilder current = new StringBuilder("");

        generate(n,n,current,allParenthesis);
        return allParenthesis;
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
        for(String str : ans){
            System.out.println(str);
        }
    }
}
