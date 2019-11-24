package Leetcode;

/*
Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 1, 0, 1, 2, 2, 1, 0]
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortestDistanceToACharacter
{

    public static void main(String args[])
    {
        String s = "loveleetcode";
        char c = 'e';
        ShortestDistanceToACharacter sdtac = new ShortestDistanceToACharacter();
        int[] result = sdtac.shortestToChar(s, c);
        System.out.println(Arrays.toString(result));
    }

    public int[] shortestToChar(String S, char C)
    {
        int[] res = new int[S.length()];
        if (S == null || S.length() == 0) {
            return res;
        }
        int N = S.length();
        int[] left = new int[N];
        int[] right = new int[N];
        char[] charArray = S.toCharArray();
        for (int i = 0; i < N; i++) {
            if (charArray[i] == C) {
                left[i] = i + 1;
            }
            else if (i != 0) {
                left[i] = left[i - 1];
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (charArray[i] == C) {
                right[i] = i + 1;
            }
            else if (i != N - 1) {
                right[i] = right[i + 1];
            }
        }

        List<Integer> leftList = Arrays.stream(left).boxed().collect(Collectors.toList());
        List<Integer> rightList = Arrays.stream(right).boxed().collect(Collectors.toList());
        System.out.println(leftList);
        System.out.println(rightList);
        for (int i = 0; i < N; i++) {
            if (charArray[i] == C) {
                res[i] = 0;
            } else if ((left[i] == 0 && right[i] != 0) || (right[i] == 0 && left[i] != 0)) {
                if (left[i] == 0) {
                    res[i] = Math.abs(i + 1 - right[i]);
                }
                else if (right[i] == 0) {
                    res[i] = Math.abs(i + 1 - left[i]);
                }
            } else {
                res[i] = Math.min(Math.abs(i + 1 - right[i]), Math.abs(i + 1 - left[i]));
            }
        }

        return res;
    }
}
