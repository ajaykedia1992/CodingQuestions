package Glider.io;

import java.util.HashMap;
import java.util.Map;

public class DecodeString
{
    public static void main(String args[]){
        String str = "111";
        int count = decodeString(str);
        System.out.println(count);
    }

    private static int decodeString(String str)
    {
        if(str == null){
            throw new IllegalArgumentException();
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return decodeStringUtil(str, str.length(), memo);
    }

    private static int decodeStringUtil(String data, int k,  Map<Integer, Integer> memo)
    {
        if(k == 0){
            return 1;
        }
        int s = data.length() - k;
        if(data.charAt(s) == '0'){
            return 0;
        }
        if(memo.containsKey(k)){
            return memo.get(k);
        }
        int result = decodeStringUtil(data, k - 1, memo);
        if(k >= 2 && Integer.parseInt(data.substring(s, s + 2)) <= 26){
            result += decodeStringUtil(data, k - 2, memo);
        }
        memo.put(k, result);
        return result;
    }
}
