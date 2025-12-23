"""
Problem : Integer to English Words (LC - 273)
"""

def convertToEnglish(num: int) -> str :
    # array for integer that are directly converted
    arr = ["Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
    
    # array for integer that combine with other
    arr1 = ["Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    
    # return if num is zero
    if(num == 0) :
        return ""
        
    # Intialize ans list
    ans = ""

    # Add hundredth place word 
    if num//100 :
        ans = arr[num//100] + " Hundred "

    # update num for further converting
    num = num%100
    # check if num is greater than 0 and less than 20 and directly add their english words
    if(num > 0 and num < 20) :
        ans =  ans + arr[num]
    else :
        # add tenth place
        if(num!=0) :
            ans = ans + arr1[(num//10) - 2]
        num = num%10 # update
        if(num!=0) :
            ans = ans + " " + arr[num] # add ones place
    
    # trim extra spaces
    ans = ans.strip()
    return ans


def numberToWordsHelper(num: int, base: int) -> str:
    # return empty string if num is 0 or Base case
    if(num == 0) :
        return ""

    # Get english for prefix by recursion
    prefixEnglish = numberToWordsHelper(num//1000,base+1)
    # get english for current part 
    currentPart = convertToEnglish(num%1000)

    # add corresponding suffix for current part
    if(len(currentPart) != 0) :
        match (base) :
            case 1: currentPart = currentPart + " Thousand "
            case 2: currentPart = currentPart + " Million "
            case 3: currentPart = currentPart + " Billion "
        
    # combine prefix and current and return 
    currentPart = prefixEnglish + currentPart
    return currentPart

def numberToWords(num: int) -> str :
    if(num == 0) :
        return "Zero"
    ans = numberToWordsHelper(num,0)
    ans = ans.strip()
    return ans


print(numberToWords(12345))