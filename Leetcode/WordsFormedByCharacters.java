package Leetcode;

public class WordsFormedByCharacters {

    public static void main(String args[]){
        String words[] = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(new WordsFormedByCharacters().countCharacters(words, chars));
    }

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            boolean isSubstring = isSubstringMatch(words[i], chars);
            if(isSubstring){
                count+= words[i].length();
            }
        }

        return count;

    }

    public boolean isSubstringMatch(String word, String chars){
        int[] bank = new int[256];
        int i = 0;
        int length = word.length();
        int j = 0;
        while(j < length){
            ++bank[word.charAt(j++)];
        }

        int count = 0;
        while(i < chars.length()){
            if(bank[chars.charAt(i++)]-- > 0){
                count++;
            }

            if(count == length){
                return true;
            }
        }

        return false;
    }
}
