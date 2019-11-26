package ByteByByte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StringDeletion
{
    public static void main(String args[]){
        Set<String> dictionary = new HashSet<String>(){{
            add("a");
            add("aa");
            add("aaa");
        }};
        String query = "abc";
        StringDeletion sd = new StringDeletion();
        int deletedLength = sd.getStringDeletionCount(query, dictionary);
        System.out.println(deletedLength);
    }

    private int getStringDeletionCount(String query, Set<String> dictionary){
        if(query == null || query.length() == 0){
            return -1;
        }
        if(dictionary.size() == 0){
            return query.length();
        }

        Set<String> track = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(query);
        track.add(query);
        while(!queue.isEmpty()){
            String temp = queue.poll();
            track.remove(temp);
            if(dictionary.contains(temp))
                return query.length() - temp.length();
            for(int i = 0; i < temp.length(); i++){
                String s = temp.substring(0,i) + temp.substring(i + 1, temp.length());
                if(!track.contains(s)){
                    queue.add(s);
                    track.add(s);
                }
            }
        }
        return -1;
    }
}
