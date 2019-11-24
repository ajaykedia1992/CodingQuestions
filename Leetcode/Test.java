package Leetcode;

public class Test
{
    void callMe(){
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(methodName);
    }
    public static void main(String args[]){
        Test t = new Test();
        t.callMe();
    }
}
