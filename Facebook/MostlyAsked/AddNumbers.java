package Facebook.MostlyAsked;

public class AddNumbers
{
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int c = a & b;
            a = a ^ b ;
            b = c << 1;
        }
        return a;
    }

    public static void main(String args[]){
        int a = -2;
        int b = 3;
        System.out.println(new AddNumbers().getSum(a, b));
    }
}
