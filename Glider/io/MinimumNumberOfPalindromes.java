package Glider.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Wrong answer
 */
public class MinimumNumberOfPalindromes
{
    public static void main(String args[]){
        String str = "aaabbb";
        int length = 20;
        MinimumNumberOfPalindromes m = new MinimumNumberOfPalindromes();
        int count = m.countMinParts(str);
        System.out.println(count);
    }

    private int countMinParts(String str)
    {
        Map<Character, Integer> map = getMinimumNumberOfPalindromes(str);
        List<Integer> evenCount = new ArrayList<>();
        List<Integer> oddCount = new ArrayList<>();

        for(Map.Entry<Character, Integer> m : map.entrySet()){
            int value = m.getValue();
            if(value % 2 == 0){
                evenCount.add(value);
            }else{
                oddCount.add(value);
            }
        }
        int sumEven = 0;
        for(int i = 0; i < evenCount.size() ; i++){
            sumEven += evenCount.get(i);
        }

        if(oddCount.size() == 0){
            return 0;
        }
        if(evenCount.size() == 0){
            if(oddCount.size() == 1){
                return 1;
            }
            return 0;
        }

        int i = 0;

        while(i < oddCount.size()){
            if((sumEven/2) % oddCount.size() == 0 ){
                return oddCount.size();
            }
            if(oddCount.get(i) == 1){
                i++;
                continue;
            }

            sumEven += 2;

            oddCount.set(i, oddCount.get(i) - 2);
        }

        return str.length();

    }

    private Map<Character, Integer> getMinimumNumberOfPalindromes(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);

        return map;
    }


}
