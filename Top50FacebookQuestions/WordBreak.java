/*
https://leetcode.com/problems/word-break/
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak
{
    public static void main(String args[])
    {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        WordBreak w = new WordBreak();
        System.out.println(w.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict)
    {
        if(s == null || s.length() == 0) return true;
        if(wordDict == null || wordDict.size() == 0) return false;

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String temp = s.substring(j, i);
                if(dp[j] && set.contains(temp)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
