package Facebook.PhoneDirectory;

import java.util.ArrayList;
import java.util.List;

public class PhoneCombinationRecursive
{
    private final static String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final static List<String> res = new ArrayList<>();
    public static void main(String args[]){

        String number = "234";
        new PhoneCombinationRecursive().getAllPhoneCombinations(number, "");
        System.out.println(res);
    }

    //DFS
    private void getAllPhoneCombinations(String number, String combined)
    {
        if(number.length() == 0){
            res.add(combined);
            return;
        }

        String words = TABLE[Character.getNumericValue(number.charAt(0))];
        for(int i = 0; i < words.length(); i++){
            char c = words.charAt(i);
            getAllPhoneCombinations(number.substring(1), combined + c);

        }
    }
}
