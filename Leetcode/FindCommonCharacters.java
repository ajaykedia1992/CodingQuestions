package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int min[] = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i<A.length; i++){
            int[] chars = new int[26];
            for(char c : A[i].toCharArray()){
                ++chars[c-'a'];
            }

            for(int j = 0; j<26; j++){
                min[j] = Math.min(min[j], chars[j]);
            }
        }

        for(int i = 0; i<26; i++){
            while(min[i]-- > 0){
                result.add(String.valueOf((char)(i + 'a')));
            }
        }
        return result;
    }

    public static void main(String args[]){
        String[] A = {"bella","label","roller"};
        System.out.println(new FindCommonCharacters().commonChars(A));
    }
}
