/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
if the given words are sorted lexicographicaly in this alien language.
Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 2:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 */
package Top50FacebookQuestions;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary
{
    public static void main(String args[]){
        String words[] = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(words,order));
    }

    public boolean isAlienSorted(String[] words, String order) {

        if(words.length <= 1) return true;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            map.put(c, i);
        }

        int result = 0;
        for(int i = 1; i < words.length; i++){
            String word1 = words[i - 1];
            String word2 = words[i];
            int count = 0;
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(map.get(c1) < map.get(c2)){
                    result++;
                    break;
                }
                else if(map.get(c1) > map.get(c2)){
                    return false;
                }
                else {
                    count++;
                }
            }
            if(count == word2.length()) return false;
            else{
                result++;
            }
        }

        if(result == words.length) return true;
        return false;
    }
}
