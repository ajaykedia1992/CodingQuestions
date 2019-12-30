/*
https://leetcode.com/problems/intersection-of-two-arrays/
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
 */
package Top50FacebookQuestions;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                temp.add(nums2[i]);
            }
        }

        int[] res = new int[temp.size()];
        int k = 0;
        for (int i : temp) {
            res[k++] = i;
        }
        return res;
    }
}
