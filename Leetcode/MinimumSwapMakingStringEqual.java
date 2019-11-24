package Leetcode;

public class MinimumSwapMakingStringEqual
{
    public static void main(String[] args)
    {
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";

        MinimumSwapMakingStringEqual m = new MinimumSwapMakingStringEqual();
        System.out.println(m.minimumSwap(s1, s2));
    }

    public int minimumSwap(String s1, String s2)
    {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int count = 0;
        StringBuilder str = new StringBuilder("");
        int i = 0, n = s1.length();
        while(i < n){
            str.append(s1.charAt(i)).append(s2.charAt(i));
            i++;
        }
        while(str.length() != 0){
            if(str.charAt(0) == str.charAt(1)){
                str.deleteCharAt(0);
                str.deleteCharAt(0);
            }else{
                String straight = str.substring(0, 2);
                String reverse = str.charAt(1) + "" + str.charAt(0);
                str.delete(0, 2);
                int index = indexOf(str.toString(), straight);

                if(index != -1){
                    str.delete(index, index + 2);
                    count += 1;
                    continue;
                }
                index = indexOf(str.toString(), reverse);
                if(index != -1){
                    str.delete(index, index + 2);
                    count += 2;
                    continue;
                }
                return -1;
            }
        }
        return count;
    }

    private int indexOf(String str, String matchingString){
        int i = 0;
        int n = str.length();
        while(i < n - 1){
            if(matchingString.equals(str.substring(i, i + 2))){
                return i;
            }
            i += 2;
        }
        return -1;
    }
}
