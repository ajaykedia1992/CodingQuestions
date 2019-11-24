package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    Map<Integer, Character> integerToRomanMap = null;

    public IntegerToRoman(){
        integerToRomanMap  = new HashMap<Integer, Character>(){{
            put(1, 'I');
            put(5, 'V');
            put(10, 'X');
            put(50, 'L');
            put(100, 'C');
            put(500, 'D');
            put(1000, 'M');
        }};
    }

    public static void main(String args[]){
        int number = 919;
        IntegerToRoman i = new IntegerToRoman();
        String result = i.getIntegerToRoman(number);
        System.out.println(result);
    }

    private String getIntegerToRoman(int number) {

        if(number <= 0){
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            if (number >= 1000) {
                sb.append(integerToRomanMap.get(1000));
                number -= 1000;
            } else if (number >= 900 && number < 1000) {
                sb.append(integerToRomanMap.get(100)).append(integerToRomanMap.get(1000));
                number -= 900;
            }else if(number >=500 && number < 900){
                sb.append(integerToRomanMap.get(500));
                number -= 500;
            }else if(number >=400 && number < 500){
                sb.append(integerToRomanMap.get(100)).append(integerToRomanMap.get(500));
                number -= 400;
            }else if(number >=100 && number < 400){
                sb.append(integerToRomanMap.get(100));
                number -= 100;
            }else if(number >=90 && number < 100){
                sb.append(integerToRomanMap.get(10)).append(integerToRomanMap.get(100));
                number -= 90;
            }else if(number >=50 && number < 90){
                sb.append(integerToRomanMap.get(50));
                number -= 50;
            }else if(number >=40 && number < 50){
                sb.append(integerToRomanMap.get(10)).append(integerToRomanMap.get(50));
                number -= 40;
            }else if(number >=10 && number < 40){
                sb.append(integerToRomanMap.get(10));
                number -= 10;
            }else if(number >=9 && number < 10){
                sb.append(integerToRomanMap.get(1)).append(integerToRomanMap.get(10));
                number -= 9;
            }else if(number >=5 && number <9){
                sb.append(integerToRomanMap.get(5));
                number -= 5;
            }else if(number >=4 && number < 5){
                sb.append(integerToRomanMap.get(1)).append(integerToRomanMap.get(5));
                number -= 4;
            }else if(number >=1 && number < 4){
                sb.append(integerToRomanMap.get(1));
                number -= 1;
            }else{
                throw new IllegalArgumentException();
            }

        }
        return sb.toString();

    }

}
