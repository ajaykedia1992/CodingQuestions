package Facebook.PreviousInterviews;

import java.util.Stack;

public class ValidParanthesis
{
    public static void main(String args[]){
        System.out.println(new ValidParanthesis().validParanthesis("{[]}"));
        System.out.println(new ValidParanthesis().validParanthesis("([)]"));
    }

    private boolean validParanthesis(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    if(c == ')'){
                        if(stack.peek() == '(') stack.pop();
                        else return false;
                    } else if(c == '}'){
                        if(stack.peek() == '{') stack.pop();
                        else return false;
                    }else if(c == ']'){
                        if(stack.peek() == '[') stack.pop();
                        else return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
}
