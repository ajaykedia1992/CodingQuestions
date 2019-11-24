package Glider.io;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaximalNumber
{
    public static void main(String args[]){
        String number = "123";
        int n = 3;
        MaximalNumber.solve(n, number);
    }

    private static void solve(int n, String str)
    {
        char c [] = str.toCharArray();
        Arrays.sort(c);
        StringBuilder s = new StringBuilder(new String(c));
        s = s.reverse();
        System.out.println(s);
    }
}
