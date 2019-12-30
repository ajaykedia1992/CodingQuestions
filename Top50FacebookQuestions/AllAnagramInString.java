/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.List;

public class AllAnagramInString
{
    public static void main(String args[])
    {
        String s = "cbaebabacd";
        String p = "abc";
        AllAnagramInString a = new AllAnagramInString();
        System.out.println(a.findAnagrams(s, p));
    }

    public List<Integer> findAnagrams(String s, String p)
    {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }

        int[] bank = new int[26];
        int left = 0, right = 0;
        int count = p.length();
        for (char c : p.toCharArray()) {
            bank[c - 'a']++;
        }

        while (right < s.length()) {
            if (bank[s.charAt(right++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                res.add(left);
            }
            if(right - left == p.length() && bank[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return res;
    }
}
