package Facebook.TextJustification;

import java.util.ArrayList;
import java.util.List;

public class TextJustification
{
    public static void main(String args[]){
        String[] str = { "This", "is", "an", "example", "of", "text", "justification.", "Please!", "say", "Hello",
                "World" };
        List<String> res = new TextJustification().fullJustify(str, 16);
        for(String r : res){
            System.out.println(r);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int currentCount = 0;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> lineList = new ArrayList<>();
        for (String str : words) {
            if (currentCount + str.length() > maxWidth) {
                list.add(makeJustify(lineList, maxWidth + lineList.size() - currentCount, false));
                currentCount = 0;
                lineList = new ArrayList<>();
            }
            currentCount += str.length() + 1;
            lineList.add(str);
        }
        if (lineList.size() != 0) {
            list.add(makeJustify(lineList, maxWidth + lineList.size() - currentCount, true));
        }
        return list;
    }

    public static String makeJustify(ArrayList<String> line, int numberOfSpaces, boolean lastLine) {
        StringBuilder sb = new StringBuilder();
        int spacesPerWord = line.size() > 1 ? numberOfSpaces / (line.size() - 1) : numberOfSpaces;
        int extraSpaces = line.size() > 1 ? numberOfSpaces % (line.size() - 1) : 0;
        for (String str : line) {
            int spacesBetweenWords = spacesPerWord + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(str);
            if (lastLine) {
                if (numberOfSpaces > 0)
                    sb.append(" ");
                numberOfSpaces--;
            } else if (numberOfSpaces > 0)
                for (int i = 0; i < spacesBetweenWords; i++) {
                    sb.append(" ");
                    numberOfSpaces--;
                }
        }
        if (lastLine) {
            for (int i = 0; i < numberOfSpaces; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
