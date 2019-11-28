package Coderpad.io;

public class ValidAbbrevation
{
    public static void main(String args[]){
        String word = "internationalization";
        String abbr = "i12iz4n";
        boolean isValid = ValidAbbrevation.isValidAbbrevation(word, abbr);
        System.out.println(isValid);
    }

    private static boolean isValidAbbrevation(String word, String abbr){
        if(abbr == null || word == null){
            return false;
        }
        if(abbr.length() > word.length()){
            return false;
        }
        if(abbr == null && word == null){
            return true;
        }

        int ab = 0;
        int wp = 0;

        while(ab < abbr.length()){
            if(Character.isDigit(abbr.charAt(ab))){
                int[] number = getNumber(abbr, ab);
                ab = number[1];
                wp += number[0];
            }else{
                if(wp >= word.length() || abbr.charAt(ab) != word.charAt(wp)){
                    return false;
                }
                ab++;
                wp++;
            }
        }

        if(wp != word.length()){
            return false;
        }
        return true;
    }

    private static int[] getNumber(String abbr, int ab)
    {
        int num = 0;
        while(ab < abbr.length() && Character.isDigit(abbr.charAt(ab))){
            num = num *10 + (abbr.charAt(ab) - '0');
            ab++;
        }
        int[] result = new int[2];
        result[0] = num;
        result[1] = ab;
        return result;
    }
}
