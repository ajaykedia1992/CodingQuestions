/*
https://leetcode.com/problems/integer-to-english-words/
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
package Top50FacebookQuestions;

public class IntegerToEnglishWord
{
    public static void main(String args[]){
        int num = 20;
        String english = new IntegerToEnglishWord().numberToWords(num);
        System.out.println(english);
    }

    public String one(int num){
        switch (num){
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

    public String twoLessThanTwenty(int num){
        switch (num){
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

    public String tens(int num){
        switch (num){
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

    public String two(int num){
        if(num < 10){
            return one(num);
        }
        if(num < 20){
            return twoLessThanTwenty(num);
        }
        int ten = num / 10;
        int rest = num - ten * 10;
        String res = "";
        if(ten * rest != 0){
            res += tens(ten * 10) + " " + one(rest);
        }
        else if(ten != 0 && rest == 0){
            res += tens(ten * 10);
        }
        else if(ten == 0 && rest != 0){
            res += one(rest);
        }
        return res;
    }

    public String three(int num){
        int hundred = num / 100;
        int rest = num - hundred * 100;
        String res = "";
        if(hundred * rest != 0){
            res += one(hundred) + " Hundred " + two(rest);
        }
        else if(hundred != 0 && rest == 0){
            res += one(hundred) + " Hundred";
        }
        else if(hundred == 0 && rest != 0){
            res += two(rest);
        }

        return res;
    }

    public String numberToWords(int num)
    {
        if(num == 0) return  "Zero";

        int billions = num / 1000000000;
        int millions = (num - billions * 1000000000) / 1000000;
        int thousand = (num - billions * 1000000000 - millions * 1000000) / 1000;
        int rest = (num - billions * 1000000000 - millions * 1000000 - thousand * 1000);
        String res = "";
        if(billions != 0){
            res += three(billions) + " Billion";
        }
        if(millions != 0){
            if(res.length() != 0){
                res += " ";
            }
            res += three(millions) + " Million";
        }
        if(thousand != 0){
            if(res.length() != 0){
                res += " ";
            }
            res += three(thousand) + " Thousand";
        }
        if(rest != 0){
            if(res.length() != 0){
                res += " ";
            }
            res += three(rest);
        }

        return res.trim();
    }
}
