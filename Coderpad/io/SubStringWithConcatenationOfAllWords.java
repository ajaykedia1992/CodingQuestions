package Coderpad.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords
{
    public static void main(String args[])
    {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        SubStringWithConcatenationOfAllWords sub = new SubStringWithConcatenationOfAllWords();
        System.out.println(sub.findSubstring(s, words));
    }

    private List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        if (s == null || s.length() == 0) {
            return res;
        }

        int len = words[0].length() * words.length;
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(s, 0) + 1);
        }

        Map<String, Integer> expected = null;
        loop : for (int i = 0; i < s.length() - len + 1; i++) {
            expected = new HashMap<>();
            for (int j = 0; j < len; j += words[0].length()) {
                String str = s.substring(i + j, i + j + words[0].length());
                if(map.containsKey(str)){
                    expected.put(str, expected.getOrDefault(str, 0) + 1);
                }else{
                    continue loop;
                }
            }
            if(expected.equals(map)){
                res.add(i);
            }
        }
        return res;
    }

}
