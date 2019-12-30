/*
https://leetcode.com/problems/goat-latin/
A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
The rules of Goat Latin are as follows:
If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin.
Example 1:
Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:
Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
Notes:
1. S contains only uppercase, lowercase and spaces. Exactly one space between each word.
2. 1 <= S.length <= 150.
 */
package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin
{
    final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')) ;
    public String toGoatLatin(String S) {

        StringBuilder sb = new StringBuilder();

        int k = 1;
        for(String str : S.split(" ")){
            char c = str.charAt(0);
            if(VOWELS.contains(c)){
                sb.append(str);
            }else{
                sb.append(str.substring(1)).append(c);
            }
            sb.append("ma");
            for(int j = 0; j < k; j++){
                sb.append("a");
            }
            sb.append(" ");
            k++;
        }
        return sb.toString().trim();
    }

    public static void main(String args[]){
        String S = "I speak Goat Latin";
        GoatLatin g = new GoatLatin();
        System.out.println(g.toGoatLatin(S));
    }
}
