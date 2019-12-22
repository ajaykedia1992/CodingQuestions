/*
https://leetcode.com/problems/strobogrammatic-number/
 */

package Facebook.StrobogrammaticNumbers;

public class StrobogrammaticNumber
{
    public static void main(String args[]){
        String number = "69";
        System.out.println(new StrobogrammaticNumber().isStrobogrammaticNumber(number));
    }

    private boolean isStrobogrammaticNumber(String number)
    {
        if(number == null || number.length() == 0) return true;

        int start = 0;
        int end = number.length() - 1;

        while(start <= end && number.charAt(start) == conversion(number.charAt(end))){
            start++;
            end--;
        }

        return end < start;
    }

    private char conversion(char c)
    {
        switch (c){
            case '6' : return '9';
            case '9' : return '6';
            case '8' : return '8';
            case '0' : return '0';
            case '1' : return '1';
            default:  return  'c';
        }
    }
}
