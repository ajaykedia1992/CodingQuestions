/*
https://leetcode.com/problems/custom-sort-string/
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
