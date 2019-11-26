package ByteByByte;

import java.util.*;

public class NthFibonacciNumber
{
    public static void main(String args[]){
        int n = 10;
        NthFibonacciNumber fibonacciNumber = new NthFibonacciNumber();
        int result = fibonacciNumber.getFibonacciNumber(n);
        System.out.println(result);
    }

    private int getFibonacciNumber(int n)
    {
        if(n < 0){
            throw new IllegalArgumentException();
        }
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);

        return getFibonacciNumberHelper(n, cache);
    }

    private int getFibonacciNumberHelper(int n, int[] cache)
    {
        if(cache[n] > -1){
            return cache[n];
        }
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int result = getFibonacciNumberHelper(n - 1, cache) + getFibonacciNumberHelper(n - 2, cache);
        cache[n] = result;
        return result;
    }
}
