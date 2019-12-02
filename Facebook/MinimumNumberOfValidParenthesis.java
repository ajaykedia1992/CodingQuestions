/*
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Input: s = "a)b(c)d"
Output: "ab(c)d"
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 */
package Facebook;

import java.util.Stack;

public class MinimumNumberOfValidParenthesis
{
    public static void main(String args[]){
        String str = "lee(t(c)o)de)";
        String result = new MinimumNumberOfValidParenthesis().minRemoveToMakeValid(str);
        System.out.println(result);
    }
    public String minRemoveToMakeValid(String s) {

        char[] arr = s.toCharArray();
        int index = 0, n = arr.length, c = 0, j, k;

        for(int i=0; i<n; i++){
            if(arr[i] == ')'){
                if( c > 0)
                    c--;
                else
                    continue;
            }
            else if(arr[i] == '('){
                c++;
            }
            arr[index++] = arr[i];
        }

        k = index;
        j = --index;
        while( j >= 0){
            if( c == 0 || arr[j] != '(') // c means no of extra "(". so remove them from back
                arr[index--] = arr[j];
            if( c > 0 && arr[j] == '(')
                c--;
            j--;
        }

        return String.valueOf(arr, index-j, k-(index-j));
        //starting index to no of characters to print
    }
}
