/*
Problem : Integer to English Words (LC - 273)
*/

#include <iostream>
#include <vector>
using namespace std;

string convertToEnglish(int num){
    // array for integer that are directly converted
    vector<string> arr = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    // array for integer that combine with other
    vector<string> arr1 = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    // return if num is zero
    if(num == 0) return "";
        
    // Intialize ans string
    string ans = "";

    // Add hundredth place word 
    if(num/100){
        ans = arr[num/100] + " Hundred ";
    }

    // update num for further converting
    num = num%100;
    // check if num is greater than 0 and less than 20 and directly add their english words
    if(num > 0 && num < 20){
        ans =  ans + arr[num];
    }
    else{
        // add tenth place
        if(num!=0) ans = ans + arr1[(num/10) - 2];
        num = num%10; // update
        if(num!=0) ans = ans + " " + arr[num]; // add ones place
    }

    // trim extra spaces
    while(ans.back() == ' ') ans.pop_back();
    return ans;
}

string numberToWordsHelper(int num, int base){
    // return empty string if num is 0 or Base case
    if(num == 0) return "";

    // Get english for prefix by recursion
    string prefixEnglish = numberToWordsHelper(num/1000,base+1);
    // get english for current part 
    string currentPart = convertToEnglish(num%1000);

    // add corresponding suffix for current part
    if(!currentPart.empty()){
        switch(base){
            case 0: break;
            case 1: currentPart = currentPart + " Thousand ";
                    break;
            case 2: currentPart = currentPart + " Million ";
                    break;
            case 3: currentPart = currentPart + " Billion ";
                    break;
            default: break;
        }
    }
    
    // combine prefix and current and return 
    currentPart = prefixEnglish + currentPart;
    return currentPart;
}
string numberToWords(int num) {
    if(num == 0) return "Zero";
    string ans = numberToWordsHelper(num,0);
    while(ans.back() == ' ') ans.pop_back();
    return ans;
}

int main(){

    cout << numberToWords(12345) << endl;

    return 0;
}