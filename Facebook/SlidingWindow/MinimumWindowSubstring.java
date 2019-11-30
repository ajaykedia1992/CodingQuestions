package Facebook.SlidingWindow;

public class MinimumWindowSubstring
{
    public static void main(String args[])
    {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String res = m.minWindow(S, T);
        System.out.println(res);
    }

    public String minWindow(String s, String t)
    {
        if (t == null || t.length() == 0) {
            return "";
        }
        if (s == null || s.length() == 0) {
            return null;
        }
        if (t.length() > s.length()) {
            return null;
        }

        int[] bank = new int[255];
        int right = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        String res = "";
        for (char c : t.toCharArray()) {
            ++bank[c];
        }
        while(right < s.length()){
            if(bank[s.charAt(right++)]-- > 0){
                count++;
            }
            while(count == t.length()){
                if(minLength > right - left){
                    minLength = right - left;
                    res = s.substring(left, right);
                }
                if(++bank[s.charAt(left++)] > 0){
                    count--;
                }
            }
        }
        return res;
    }
}
