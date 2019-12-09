package Facebook.PhoneDirectory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PhoneCombinationIterative
{
    private final static String[] TABLE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String args[]){

        int[] number = {2, 3, 4};
        List<String> result = new PhoneCombinationIterative().getAllPhoneCombinations(number, number.length);
        System.out.println(result);
    }

    //BFS
    private List<String> getAllPhoneCombinations(int[] number, int length)
    {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while(!queue.isEmpty()){
            String prefix = queue.remove();

            if(prefix.length() == length){
                res.add(prefix);
                continue;
            }

            String words = TABLE[number[prefix.length()]];

            for(int i = 0; i < words.length(); i++){
                char c = words.charAt(i);

                queue.add(prefix + c);
            }
        }

        return res;
    }
}
