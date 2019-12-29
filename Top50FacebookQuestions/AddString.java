/*
https://leetcode.com/problems/add-strings/
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

package Top50FacebookQuestions;

public class AddString
{
    public static void main(String args[]){
        String num1 = "10";
        String num2 = "0";
        AddString a = new AddString();
        System.out.println(a.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()){
            return addStrings(num2, num1);
        }
        StringBuilder res = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        int j = n - 1;
        int carry = 0;
        for(int i = m - 1; i >= 0; i--){
            if(j >= 0){
                int val = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + carry;
                int remainder = val % 10;
                carry = val / 10;
                res.insert(0, remainder);
                j--;
                continue;
            }

            int val = Character.getNumericValue(num1.charAt(i)) + carry;
            int remainder = val % 10;
            carry = val / 10;
            res.insert(0, remainder);
        }

        if(carry == 1){
            res.insert(0, carry);
        }
        return res.toString();
    }
}
