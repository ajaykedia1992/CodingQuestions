package Facebook.MostlyAsked;

public class ValidParanthesis
{
    public static void main(String args[]){
        String str = "()()(()))";
        System.out.print(new ValidParanthesis().isValid(str));
    }

    private boolean isValid(String str)
    {
        if(str == null || str.length() == 0){
            return true;
        }

        int numberOfBalance = 0;

        for(char c : str.toCharArray()){
            if(c == '('){
                numberOfBalance++;
            }else if (c == ')'){
                numberOfBalance--;
                if(numberOfBalance < 0){
                    return false;
                }
            }
        }
        if(numberOfBalance != 0) return false;
        return true;
    }
}
