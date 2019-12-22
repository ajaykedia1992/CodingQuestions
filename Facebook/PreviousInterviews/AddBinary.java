package Facebook.PreviousInterviews;

public class AddBinary
{
    public static void main(String args[]){
        String a = "11";
        String b = "1";
        AddBinary addBinary = new AddBinary();
        String res = addBinary.addBinary(a, b);
        System.out.println(res);
    }

    private String addBinary(String a, String b)
    {
        if(a.length() < b.length()){
            return addBinary(b, a);
        }

        int n = a.length();
        int m = b.length();

        int carry = 0;
        StringBuilder s = new StringBuilder();
        int j = m - 1;
        for(int i = n - 1; i > -1; i--){
            if(a.charAt(i) == '1') carry++;
            if(j > - 1 && b.charAt(j--) == '1') carry++;

            if(carry % 2 == 1){
                s.insert(0, 1);
            }else{
                s.insert(0, 0);
            }
            carry /= 2;
        }
        if(carry == 1){
            s.insert(0, 1);
        }

        return s.toString();
    }
}
