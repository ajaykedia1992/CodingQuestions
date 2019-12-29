/*
https://leetcode.com/problems/task-scheduler/
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
You need to return the least number of intervals the CPU will take to finish all the given tasks.
Example:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Note:
1) The number of tasks is in the range [1, 10000].
2) The integer n is in the range [0, 100].
 */
package Top50FacebookQuestions;

import java.util.Arrays;

public class TaskScheduler
{
    public static void main(String args[]){
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        TaskScheduler t = new TaskScheduler();
        System.out.println(t.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {

        int[] dp = new int[26];
        for(char c : tasks){
            dp[c - 'A']++;
        }

        Arrays.sort(dp);
        // A _  A _  A
        int maxValue = dp[25] - 1;
        int totalTimeShouldBe =  maxValue * n;
        for(int i = 24; i >= 0 ;i--){
            if(dp[i] == 0) break;

            totalTimeShouldBe -= Math.min(maxValue, dp[i]);
        }

        // for n = 0, totalTimeShouldBe < 0. So be careful
        return totalTimeShouldBe <= 0 ? tasks.length : totalTimeShouldBe + tasks.length;
    }
}
