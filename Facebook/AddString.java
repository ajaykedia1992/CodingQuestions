package Facebook;

public class AddString
{
    public static void main(String args[]){
        String a = "236";
        String b = "2";
        AddString s = new AddString();
        System.out.println(s.addStrings(a, b));
    }

    public String addStrings(String num1, String num2) {
        if(num1.length() == 0) return num2;
        if(num2.length() == 0 ) return num1;

        if(num1.length() > num2.length()) return addStrings(num2, num1);

        int n1 = num1.length();
        int n2 = num2.length();

        StringBuilder str1 = new StringBuilder(num1).reverse();
        StringBuilder str2 = new StringBuilder(num2).reverse();

        int remaining = n2 - n1;
        if(remaining > 0){
            for(int i = 0; i < remaining; i++){
                str1.append("0");
            }
        }

        int carry = 0;

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < n2; i++){
            int a = Character.getNumericValue(str1.charAt(i));
            int b = Character.getNumericValue(str2.charAt(i));

            int c = a + b;
            if(carry > 0){
                c += carry;
            }
            carry = c / 10;
            c = c % 10;

            res.append(c);

        }

        if(carry > 0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
