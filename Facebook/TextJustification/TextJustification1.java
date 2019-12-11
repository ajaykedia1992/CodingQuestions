package Facebook.TextJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification1
{
    public static void main(String args[]){
        String[] str = { "This", "is", "an", "example", "of", "text", "justification.", "Please!", "say", "Hello",
                "World" };
        List<String> res = new TextJustification1().fullJustify(str, 16);
        for(String r : res){
            System.out.println(r);
        }
    }

    private List<String> fullJustify(String[] str, int maxWidth)
    {
        List<String> res = new ArrayList<>();
        if(str == null || str.length == 0){
            return res;
        }
        List<String> temp = new ArrayList<>();
        int counter = 0;
        for(String word : str){
            if(word.length() + counter > maxWidth){

                res.add(fullJustifyUtil(temp, maxWidth + temp.size() - counter, false));
                counter = 0;
                temp = new ArrayList<>();
            }

            counter += word.length() + 1;
            temp.add(word);
        }

        if(temp.size() > 0){
            res.add(fullJustifyUtil(temp, maxWidth + temp.size() - counter, true));
        }
        return res;
    }

    private String fullJustifyUtil(List<String> temp, int numberOfSpaces, boolean isLastLine)
    {
        StringBuilder s = new StringBuilder();

        int spacePerWord = temp.size() > 1 ? numberOfSpaces / (temp.size() - 1) : numberOfSpaces;
        int extraSpacePerWord = temp.size() > 1 ? numberOfSpaces % (temp.size() - 1) : 0;

        for(String t : temp){
            int spaceRequired = spacePerWord + (extraSpacePerWord-- > 0 ? 1 : 0);
            s.append(t);
            if(isLastLine){
                if(numberOfSpaces > 0) {
                    s.append(" ");
                    numberOfSpaces--;
                }
            }else if(numberOfSpaces > 0){
                for(int  i = 0 ; i < spaceRequired; i++){
                    s.append(" ");
                    numberOfSpaces--;
                }
            }
        }
        if(isLastLine){
            for(int i = 0; i < numberOfSpaces; i++){
                s.append(" ");
            }
        }
        return s.toString();
    }

}
