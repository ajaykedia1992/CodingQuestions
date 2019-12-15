package Facebook.MostlyAsked;

import java.util.Stack;

public class ReverseStack
{
    public static void main(String args[]){
        Stack<Integer> stack = new Stack<Integer>(){{
           add(1);
           add(2);
           add(3);
        }};

        ReverseStack r = new ReverseStack();
        r.getReverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private void getReverse(Stack<Integer> stack)
    {
        if(stack.isEmpty()) {
            return ;
        }
        int value = stack.pop();
        getReverse(stack);
        reverseUtil(stack, value);
    }

    private void reverseUtil(Stack<Integer> stack, int value)
    {
        if(stack.isEmpty()){
            stack.push(value);
            return;
        }
        int v = stack.pop();
        reverseUtil(stack, value);
        stack.push(v);
    }
}
