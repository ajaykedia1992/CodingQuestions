package Leetcode;

import java.util.HashMap;
import java.util.Map;
// IXVXCM ->
public class RomanToInteger {
    Map<Character, Integer> map = null;

    RomanToInteger(){
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public static void main(String args[]){
        String roman = "CMXIX";
        RomanToInteger r = new RomanToInteger();
        int number = r.getRomanToInteger(roman);
        System.out.println(number);
    }

    private int getRomanToInteger(String roman) {
        if(roman == null || roman.length() == 0){
            throw new IllegalArgumentException();
        }

        char characters[] = roman.toCharArray();
        int n = characters.length;
        int number = 0;
        int count = 0;
        for(int i = 0; i < n - 1;){
            char current = characters[i];
            char next = characters[i + 1];
            if(current == 'I' && (next == 'V' || next == 'X')){
                number += map.get(next) - map.get(current);
                i += 2;
                count += 2;
            }
            else if(current == 'X' && (next == 'L' || next == 'C')){
                number += map.get(next) - map.get(current);
                i += 2;
                count += 2;
            }
            else if(current == 'C' && (next == 'D' || next == 'M')){
                number += map.get(next) - map.get(current);
                i += 2;
                count += 2;
            }else{
                number += map.get(current);
                i += 1;
                count += 1;
            }
        }

        if(count != characters.length){
            number += map.get(characters[count]);
        }
        return number;
    }
}
