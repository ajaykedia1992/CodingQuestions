/*
https://leetcode.com/problems/simplify-path/
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
For more information, see: Absolute path vs relative path in Linux/Unix
Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names.
The last directory name (if it exists) must not end with a trailing /.
Also, the canonical path must be the shortest string representing the absolute path.
Example 1:
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:
Input: "/a/./b/../../c/"
Output: "/c"
Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
 */
package Top50FacebookQuestions;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimplifyPath
{
    public static void main(String args[]){
        String path = "/a//b////c/d//././/..";
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        Deque<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".",""));

        for(String dir : path.split("/")){
            if(dir.contains("..") && !queue.isEmpty()){
                queue.pop();
            }else if(!set.contains(dir)){
                queue.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : queue){
            sb.insert(0, "/").insert(1, str);
        }

        return sb.length() == 0? "/" : sb.toString();
    }
}
