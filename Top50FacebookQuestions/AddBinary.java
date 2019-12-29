/*
https://leetcode.com/problems/add-binary/
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
package Top50FacebookQuestions;

public class AddBinary
{
    public static void main(String args[]){
        String a = "11";
        String b = "11";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            return addBinary(b, a);
        }
        int m = a.length();
        int n = b.length();
        int count = 0;
        int i = m - 1;
        int j = n - 1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            if(a.charAt(i--) == '1') count++;
            if(j >= 0 && b.charAt(j--) == '1') count++;
            if(count % 2 == 1){
                sb.insert(0,1);
            }else{
                sb.insert(0 ,0);
            }
            count /= 2;
        }

        if(count == 1){
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
