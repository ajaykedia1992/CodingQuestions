/*
https://leetcode.com/problems/integer-to-english-words/
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
Example 1:
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 2:
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
package Facebook.MostlyAsked.Important;

public class IntegerToEnglishWord
{
    public static void main(String args[]){
        IntegerToEnglishWord i = new IntegerToEnglishWord();
        int num = 1234567891;
        String res = i.numberToWords(num);
        System.out.println(res);
    }

    private String one(int n){
        switch(n){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }

    private String twoLessThanTwenty(int n){
        switch (n){
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }

    private String tenths(int n){
        switch (n){
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
            default: return "";
        }
    }

    private String two(int num){
        String res = "";
        if(num == 0){
            return res;
        }
        if(num < 10) return one(num);
        else if(num < 20) return twoLessThanTwenty(num);
        else{
            int ten = num / 10;
            int rest = num - ten * 10;
            if(ten != 0){
                res += tenths(ten * 10);
            }
            if(rest != 0){
                if(res.length() != 0) res += " ";
                res += one(rest);
            }
        }
        return res;
    }

    private String three(int num){
        //111
        int hundred = num/ 100;
        int rest = num - hundred * 100;
        String res = "";
        if(hundred * rest != 0){
            res += one(hundred) + " Hundred " + two(rest);
        }
        else if(hundred == 0 && rest != 0){
            res += two(rest);
        }else if(hundred != 0 && rest == 0){
            res += one(hundred) + " Hundred ";
        }

        return res;
    }

    private String numberToWords(int num)
    {
        if(num == 0) return "Zero";

        int billions = num / 1000000000;
        int millions = (num - billions * 1000000000) / 1000000;
        int thousands = (num - billions * 1000000000 - millions * 1000000) / 1000;
        int rest = num - billions * 1000000000 - millions * 1000000 - thousands * 1000;

        StringBuilder s = new StringBuilder();
        if(billions !=- 0){
            s.append(three(billions)).append(" Billion");
        }
        if(millions != 0){
            if(s.length() != 0) s.append(" ");
            s.append(three(millions)).append(" Million");
        }
        if(thousands != 0){
            if(s.length() != 0) s.append(" ");
            s.append(three(thousands)).append(" Thousand");
        }
        if(rest != 0){
            if(s.length() != 0) s.append(" ");
            s.append(three(rest));
        }
        return s.toString().trim();
    }
}
