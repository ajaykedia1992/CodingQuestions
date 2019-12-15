/*
https://www.youtube.com/watch?v=NH3UYyQQ2b4
 */
package Facebook.MostlyAsked;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart
{
    public static void main(String args[]){
        String str = "aaabbc";
        String res = new RearrangeStringKDistanceApart().getRearranged(str , 2);
        System.out.print(res);
    }

    private String getRearranged(String str, int k)
    {
        if(str == null || str.length() == 0) return str;

        if(k <= 0 || k > str.length()) return str;

        int[] map = new int[26];
        for(int i = 0; i < str.length(); i++){
            map[str.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

        for(int i = 0; i < 26; i++){
            if(map[i] > 0){
                queue.add(new int[]{i, map[i]});
            }
        }

        StringBuilder s = new StringBuilder();
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < k; i++){
                int[] curr = queue.poll();
                s.append((char)(curr[0] + 'a'));
                list.add(curr[0]);
                if(queue.size() == 0){
                    if(i != k - 1 && s.length() != str.length()) return "";
                    break;
                }
            }
            for (int l : list){
                if(--map[l] > 0)
                queue.add(new int[]{l, map[l]});
            }
        }

        return s.toString();
    }
}
