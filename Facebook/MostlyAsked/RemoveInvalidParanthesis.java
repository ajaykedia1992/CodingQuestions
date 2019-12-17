package Facebook.MostlyAsked;

public class RemoveInvalidParanthesis
{
    public static void main(String args[]){
        String str = "l(e(e((t)c)o))(d)e)";
        RemoveInvalidParanthesis r = new RemoveInvalidParanthesis();
        System.out.println(r.removeInvalid(str));
    }

    private String removeInvalid(String str)
    {
        if(str == null || str.length() == 0){
            return str;
        }

        StringBuilder s = new StringBuilder();
        int balance = 0;
        int openSeen = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                balance++;
                openSeen++;
            }
            else if(str.charAt(i) == ')'){
                balance--;
                if(balance < 0){
                    balance = 0;
                    continue;
                }
            }
            s.append(str.charAt(i));
        }

        int openBracket = openSeen - balance;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toString().toCharArray()){
            if(c == '('){
                if(openBracket <= 0) continue;
                openBracket--;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
