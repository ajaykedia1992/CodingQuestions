package GenericClasses;

import java.util.function.Function;

public class FunctionArgument<T> {

    public static void main(String[] args){
        Function<Integer, Integer> function1 = t -> (t - 5);

        Integer value = function1.apply(5);

        System.out.println(value);

    }


}
