package Facebook.PreviousInterviews.FacebookPremium;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram
{
    public static void main(String args[]){
        String s = "fgaebabacd";
        String t = "abc";
        System.out.println(new FindAllAnagram().findAnagrams(s, t));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] bank = new int[256];
        for(char c : p.toCharArray()){
            bank[c]++;
        }

        int left = 0, right = 0, count = p.length();

        while(right < s.length()){
            if(bank[s.charAt(right++)]-- >=1) count--;
            if(count == 0) list.add(left);
            if(right - left == p.length() && bank[s.charAt(left++)]++ >=0) count++;
        }
        return list;
    }
}
