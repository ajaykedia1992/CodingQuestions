package Facebook.Parenthesis;

public class MinimumRemovalToMakeValidString
{
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        int balance = 0;
        int openseen = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                balance++;
                openseen++;
            }
            else if(s.charAt(i) == ')'){
                balance--;
                if(balance < 0){
                    balance = 0;
                    continue;
                }
            }

            str.append(s.charAt(i));
        }

        int openBrackets = openseen - balance;

        StringBuilder res = new StringBuilder();
        for(char c : str.toString().toCharArray()){
            if(c == '('){
                if(openBrackets <= 0){
                    continue;
                }
                openBrackets--;
            }
            res.append(c);
        }

        return res.toString();
    }

    public static void main(String args[]){
        MinimumRemovalToMakeValidString m = new MinimumRemovalToMakeValidString();
        //System.out.print(m.minRemoveToMakeValid("lee(t(c)o)de)"));
        //System.out.print(m.minRemoveToMakeValid("a)b(c)d"));
        System.out.print(m.minRemoveToMakeValid("(a(b(c)d)"));
    }
}
