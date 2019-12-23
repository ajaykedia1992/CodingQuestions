package Facebook.PreviousInterviews.FacebookPremium;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimplifyPath
{
    public static void main(String args[]){
        String path = "/home//foo//abc/foo/..";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for(String dir : path.split("/")){
            if(dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!set.contains(dir)) stack.push(dir);
        }

        StringBuilder res = new StringBuilder();
        for(String dir : stack){
            res.insert(0,"/").insert(1, dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}
