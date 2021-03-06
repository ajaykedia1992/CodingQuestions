/*
https://leetcode.com/problems/custom-sort-string/
S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
S was sorted in some custom order previously. We want to permute the characters of T so that t
hey match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.
 */
package Facebook.MostlyAsked.Important;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomSortString
{
    public static void main(String args[]){

        String S = "cba";
        String T = "abcd";
        CustomSortString c = new CustomSortString();
        System.out.println(c.customSortString(S, T));

    }
    public String customSortString(String S, String T) { //2ms
        Map<Character, Integer> map = new HashMap<>();

        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                for(int j = 0; j < map.get(c); j++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        Set<Character> keys = map.keySet();
        for(char c : keys){
            int values = map.get(c);
            for(int j = 0; j < values; j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String customSortString1(String S, String T) {  // 0ms
        int[] character = new int[26];
        for(char c : T.toCharArray()){
            character[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            for(int j = 0; j < character[c - 'a']; j++){
                sb.append(c);
            }
            character[c - 'a'] = 0;
        }

        for(char c = 'a'; c <= 'z'; c++){
            for(int j = 0; j < character[c - 'a']; j++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
