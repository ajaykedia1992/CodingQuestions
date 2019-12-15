package Facebook.MostlyAsked;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber
{
    private final static String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String args[]){
        String str = "234";
        List<String> res = new LetterCombinationOfAPhoneNumber().getCombination(str);
        System.out.print(res);
    }

    private List<String> getCombination(String str)
    {
        List<String> result = new ArrayList<>();

        getCombinationUtil("", str, result);
        return result;
    }

    private void getCombinationUtil(String prefix, String str, List<String> result)
    {
        if(str.length() == 0){
            result.add(prefix);
            return;
        }

        String word = TABLE[Character.getNumericValue(str.charAt(0))];
        for(char c : word.toCharArray()){
            getCombinationUtil(prefix + c, str.substring(1), result);
        }

    }

}
