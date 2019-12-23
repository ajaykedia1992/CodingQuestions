package Facebook.PreviousInterviews.FacebookPremium;

public class MinimumWindowSubstring
{
    public static void main(String args[]){
        String S = "ADOBECODEBANC";
        String T = "ABC";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String res = m.minimumWindowSubString(S, T);
        System.out.println(res);
    }

    private String minimumWindowSubString(String s, String t)
    {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";

        if(t.length() > s.length()) return "";

        int[] bank = new int[256];
        for(char c : t.toCharArray()){
            bank[c]++;
        }
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        String minString = "";
        int count = 0;
        while(right < s.length()){
            if(bank[s.charAt(right++)]-- > 0){
                count++;
                while(count == t.length()){
                    if(minLength > (right - left)){
                        minLength = right - left;
                        minString = s.substring(left, right);
                    }

                    if(++bank[s.charAt(left++)] > 0){
                        count--;
                    }
                }
            }
        }
        return minString;
    }
}
