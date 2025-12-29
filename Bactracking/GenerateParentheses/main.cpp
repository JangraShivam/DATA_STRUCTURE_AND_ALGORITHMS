/*
Problem : Generate Parentheses (LC - 22)
*/

#include <iostream>
#include <vector>
using namespace std;

void generate(int open, int closed, string& current, vector<string>& allParenthesis){
    // Base Case
    if(open == 0 && closed == 0){
        allParenthesis.push_back(current);
        return;
    }

    // If open paren can be used then use it
    if(open > 0){
        current.push_back('(');
        generate(open-1,closed,current,allParenthesis);
        current.pop_back();
    }

    // only add close paren if there are a alone open paren
    if(closed > open){
        current.push_back(')');
        generate(open,closed-1,current,allParenthesis);
        current.pop_back();
    }
}

vector<string> generateParenthesis(int n) {
    vector<string> allParenthesis;
    string current;

    generate(n,n,current,allParenthesis);

    return allParenthesis;
}
int main(){

    vector<string> ans = generateParenthesis(3);

    for(string str : ans) cout << str << endl;


    return 0;
}