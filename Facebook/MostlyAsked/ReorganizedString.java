/*
https://leetcode.com/problems/reorganize-string/
Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
If possible, output any possible result.  If not possible, return the empty string.
Example 1:
Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
 */
package Facebook.MostlyAsked;

import java.util.PriorityQueue;

public class ReorganizedString
{
    public static void main(String args[]){
        String str = "aab";
        String res = new ReorganizedString().reorganizeString(str);
        System.out.print(res);
    }
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) return "";

        int[] map = new int[26];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

        for(char c : S.toCharArray()){
            map[c - 'a']++;
        }

        int N = S.length();
        for(int i = 0; i < map.length; i++){
            if(map[i] > 0){
                if(map[i] > (N + 1)/2){
                    return "";
                }
                heap.add(new int[]{i, map[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(heap.size() >= 2){
            int[] first = heap.poll();
            int[] second = heap.poll();

            sb.append((char)(first[0] + 'a'));
            sb.append((char)(second[0] + 'a'));

            if(--first[1] > 0){
                heap.add(first);
            }
            if(--second[1] > 0){
                heap.add(second);
            }
        }

        while(heap.size() > 0){
            int[] curr = heap.poll();

            sb.append((char)(curr[0] + 'a'));
        }
        return sb.toString();
    }
}
