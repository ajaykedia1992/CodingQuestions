/*
https://leetcode.com/problems/rearrange-string-k-distance-apart/
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least distance 3 from each other.
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart
{
    public static void main(String args[]){
        String s = "aaabbccc";
        int k = 2;
        RearrangeStringKDistanceApart r = new RearrangeStringKDistanceApart();
        System.out.println(r.rearrangeString(s, k));
    }

    public String rearrangeString(String s, int k) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(k <= 0 || k > s.length()) return s;

        int[] bank = new int[26];
        for(char c : s.toCharArray()){
            bank[c - 'a']++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

        for(int i = 0; i < bank.length; i++){
            if(bank[i] > 0){
                queue.add(new int[]{i, bank[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < k; i++){
                int[] curr = queue.poll();
                sb.append((char)(curr[0] + 'a'));
                list.add(curr[0]);
                if(queue.isEmpty()){
                    if(i != k-1 && sb.length() != s.length()){
                        return "";
                    }
                    break;
                }

            }
            for(int i : list){
                if(--bank[i] > 0){
                    queue.add(new int[]{i, bank[i]});
                }
            }
        }

        return sb.toString();
    }
}
