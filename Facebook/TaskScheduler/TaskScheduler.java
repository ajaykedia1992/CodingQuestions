/*
https://leetcode.com/problems/task-scheduler/

This questions says that we have a number of tasks and a non-negative number.
if the tasks are same then each task will wait for that non-negative number or the intervals between the same task must be equal to that number or the
combination of task and idle.
Example:

Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

Input: tasks = ['A','A','A','A','B','B','B','C','C'], n = 2
Output: 10
Explantion: A -> B -> C -> A -> B -> C -> A -> B -> idle -> A
So each task has atleast n number of  difference between same task
 */
package Facebook.TaskScheduler;

import java.util.Arrays;

public class TaskScheduler
{
    public static void main(String args[]){
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        TaskScheduler t = new TaskScheduler();
        System.out.println(new TaskScheduler().leastInterval(tasks, n));
    }

    private int leastInterval(char[] tasks, int n)
    {
        if(tasks == null || tasks.length == 0){
            return 0;
        }

        int[] map = new int[26];
        for(char c : tasks){
            map[c - 'A']++;
        }
        Arrays.sort(map);

        int maxValue = map[25] - 1; // last one we will not count it.
        int idleLocation = maxValue * n; // consider initial step we just filling the character which has maximum number of count and each character must
        // have atleast n number of ldle location between them
        for(int i = 24; i >= 0 && map[i] > 0; i--){
            idleLocation -= Math.min(maxValue, map[i]);
        }
        return idleLocation > 0 ? idleLocation + tasks.length : tasks.length;
    }
}
