/*
You are given a string consisting of n lowercase Latin letters. You must find the count of number of larger alphabets for every character of the string (according to lexicographical order).
Input
3
abc
Output
2 1 0
 */
package Glider.io;

import java.util.HashMap;
import java.util.Map;

public class LargerLetters
{
    public static void main(String args[]){
        String str = "sxkalxjiqowwrytghjbczm";
        int n = 22;
        LargerLetters l = new LargerLetters();
        l.solve(n, str);
    }

    private void solve(int n, String str)
    {
        if(n == 0){
            System.out.println("");
            return;
        }
        int[] character = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()){
            ++character[c - 'a'];
        }
        manipulateMap(map, character);
        StringBuilder s = new StringBuilder();
        for(char c : str.toCharArray()){
            s.append(map.get(c)).append(" ");
        }
        System.out.println(s.toString().trim());
    }

    public void manipulateMap(Map<Character, Integer> map, int[] character){
        for(int i = 0 ; i < 26; i++){
            char c = (char) (i + 'a');
            if(map.containsKey(c)){
                continue;
            }
            map.put(c, getTotal(i, character));
        }
    }

    public int getTotal(int index, int[] character){
         int sum = 0;
         for(int i = index + 1; i < character.length; i++){
             sum += character[i];
         }
         return sum;
    }
}
