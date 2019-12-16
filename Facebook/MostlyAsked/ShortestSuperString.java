/*
https://leetcode.com/problems/find-the-shortest-superstring/
https://www.youtube.com/watch?v=sgVGYW7REgY
Given an array A of strings, find any smallest string that contains each string in A as a substring.
We may assume that no string in A is substring of another string in A.
Example 1:

Input: ["alex","loves","leetcode"]
Output: "alexlovesleetcode"
Explanation: All permutations of "alex","loves","leetcode" would also be accepted.
Example 2:

Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
Output: "gctaagttcatgcatc"
 */
package Facebook.MostlyAsked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestSuperString
{
    public static void  main(String args[]){
        String[] input1 = {"alex","loves","leetcode"};
        System.out.println(new ShortestSuperString().shortestSuperstring(input1));
        String[] input2 = {"catg","ctaagt","gcta","ttca","atgcatc"};
        System.out.println(new ShortestSuperString().shortestSuperstring(input2));
    }

    public String shortestSuperstring(String[] A) {

        List<String> list = new ArrayList<>(Arrays.asList(A));
        while(true){
            int n = list.size();
            if(n == 1) break;
            int maxLength = -1;
            int index1 = 0, index2 = 0;
            String newStr = "";
            for(int i = 0; i < n - 1; i++){
                for(int j = i + 1; j < n; j++){
                    String a = list.get(i);
                    String b = list.get(j);
                    String merged = merged(a, b);

                    int saved = a.length() + b.length() - merged.length();
                    if(saved > maxLength){
                        maxLength = saved;
                        index1 = i;
                        index2 = j;
                        newStr = merged;
                    }
                }
            }
            String a = list.get(index1);
            String b = list.get(index2);
            list.remove(a);
            list.remove(b);
            list.add(newStr);
        }

        return list.get(0);
    }

    public String merged(String a, String b){
        int len1 = a.length();
        int len2 = b.length();
        int overlapped1 = 0, overlapped2 = 0;
        for(int len = 1; len1 - len >= 0 && len <= len2; len++){
            if(a.substring(len1 - len).equals(b.substring(0, len))){
                overlapped1 = len;
            }
        }

        for(int len = 1; len2 - len >= 0 && len <= len1; len++){
            if(b.substring(len2 - len).equals(a.substring(0, len))){
                overlapped2 = len;
            }
        }

        if(overlapped1 >= overlapped2){
            return a.substring(0, len1-overlapped1) + b;
        }else{
            return b.substring(0, len2 - overlapped2) + a;
        }
    }
}
