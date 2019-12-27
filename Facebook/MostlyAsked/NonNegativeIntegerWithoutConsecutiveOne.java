/*
Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

Example 1:
Input: 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
Note: 1 <= n <= 10^9
 */
package Facebook.MostlyAsked;

public class NonNegativeIntegerWithoutConsecutiveOne
{
    public static void main(String args[]){
        int num = 5;
        NonNegativeIntegerWithoutConsecutiveOne n = new NonNegativeIntegerWithoutConsecutiveOne();
        System.out.println(n.findIntegers(num));
    }

    public int findIntegers(int num) {
        //one:all bit before cur is less than num and no continues 1 and cur bit is at one;
        //zero:all bit before cur is less than num and no continues 1 and cur bit is at zero;
        int one=0,zero=0,temp;
        boolean isNum=true;
        for(int i=31;i>=0;i--){
            temp = zero;
            zero += one;
            one = temp;
            if(isNum&&((num>>i)&1)==1){
                zero+=1;
            }
            if(((num>>i)&1)==1&&((num>>i+1)&1)==1){
                isNum=false;
            }
        }
        return one+zero+(isNum?1:0);
    }
}
