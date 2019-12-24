/*
https://leetcode.com/problems/happy-number/
 */
package Facebook.PreviousInterviews.FacebookPremium;

public class HappyNumber
{
    public static void main(String args[]){
        int num = 19;
        HappyNumber h = new HappyNumber();
        System.out.println(h.happyNumber(num));
    }

    private boolean happyNumber(int num)
    {
        int slow = num;
        int fast = getNext(num);
        while(fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int num)
    {
        int total = 0;
        while(num != 0){
            int d = num % 10;
            num /= 10;
            total += d * d;
        }
        return total;
    }
}
