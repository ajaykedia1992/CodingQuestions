package Glider.io;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DepthOfArray
{
    public static void main(String [] args){
        int n = 2;
        BigInteger[] arr = new BigInteger[]{new BigInteger(String.valueOf(3)), new BigInteger(String.valueOf(1))};
        BigInteger a = new BigInteger(String.valueOf(4));
        BigInteger b = new BigInteger(String.valueOf(1));
        solve1(n, a, b, arr);
    }

    public static void solve(int n, BigInteger a, BigInteger b, BigInteger[] arr) {
        BigInteger value = a.divide(b);
        if(arr.length < 2){
            if(value.equals(arr[0])){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            return;
        }
        int last = arr.length - 1;
        BigInteger v = arr[last];
        last--;
        BigInteger output = new BigInteger("0");
        while(last >= 0){
            output = new BigInteger(String.valueOf(1)).divide(v).add(arr[last]);
            last--;
        }
        if(output.equals(value)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    public static void solve1(int n, BigInteger a, BigInteger b, BigInteger[] arr)
    {
        String result = "";
        BigDecimal depth = new BigDecimal(String.valueOf(0));
        for (int i = 0; i < n - 1; i++) {
            depth = depth.add(new BigDecimal(arr[i])).add(new BigDecimal(String.valueOf(1)).divide(new BigDecimal(arr[i + 1])));
        }

        BigDecimal d =  new BigDecimal(a).divide(new BigDecimal(b));

        if (depth.toBigInteger().equals(d.toBigInteger())) {
            result = "YES";
        }
        else {
            result = "NO";
        }
        System.out.println(result);
    }
}
