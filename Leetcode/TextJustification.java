package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static void main(String args[]){
        String[] str = { "This", "is", "an", "example", "of", "text", "justification.", "Please!", "say", "Hello",
                "World" };
        int limit = 16;
        TextJustification textJustification = new TextJustification();
        List<String> result = textJustification.getJustification(str, limit);
        for(String s : result){
            System.out.println(s);
        }
    }

    private List<String> getJustification(String[] str, int limit) {
        if(str == null || str.length == 0){
            throw new IllegalArgumentException("String array is empty");
        }
        List<String> lineString = new ArrayList<>();
        int totalLength = 0;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length; i++){
            String sb = str[i];
            if(totalLength + sb.length() > limit){
                String res = helper(lineString, limit + lineString.size() - totalLength, false);
                result.add(res);
                lineString = new ArrayList<>();
                totalLength = 0;
            }
            lineString.add(sb);
            totalLength += sb.length() + 1;
        }
        if(lineString.size() != 0){
            String res = helper(lineString, limit + lineString.size() - totalLength, true);
            result.add(res);
        }
        return result;
    }

    private String helper(List<String> line, int numberOfSpaces, boolean isLastLine) {

        int spacePerWords = line.size() > 1 ? numberOfSpaces / (line.size() - 1) : numberOfSpaces;
        int extraSpace = line.size() > 1 ? numberOfSpaces % (line.size() - 1) : 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.size(); i++){
            sb.append(line.get(i));
            int spacesBetweenWords = spacePerWords + (extraSpace-- > 0 ? 1 : 0);
            if(isLastLine){
                if(numberOfSpaces > 0) {
                    sb.append(" ");
                }
                numberOfSpaces--;
            } else if(numberOfSpaces > 0) {
                for (int j = 0; j < spacesBetweenWords; j++) {
                    sb.append(" ");
                    numberOfSpaces--;
                }
            }
        }
        if(isLastLine){
            for(int i = 0 ; i < numberOfSpaces; i++){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
