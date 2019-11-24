package Leetcode;

public class MultiplyTwoString {

    public static void main(String args[]){
        String s1 = "15";
        String s2 = "10";
        String result = new MultiplyTwoString().getMultiplication(s1, s2);
        System.out.println(result);
    }

    private String getMultiplication(String s1, String s2) {

        String n1 = new StringBuilder(s1).reverse().toString();
        String n2 = new StringBuilder(s2).reverse().toString();

        int[] d = new int[n1.length() + n2.length() + 1];

        for(int i = 0; i < n1.length(); i++){
            for(int j = 0; j < n2.length(); j++){
                d[i + j] += (int)((n1.charAt(i) - '0') * (n2.charAt(j) - '0'));
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < d.length; i++){
            int mod = d[i] % 10;
            int carry = d[i] / 10;

            if(i + 1 < d.length){
                d[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        while(sb.charAt(0) == '0' && sb.length() > 1){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}
