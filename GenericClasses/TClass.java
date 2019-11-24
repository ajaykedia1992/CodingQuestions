package GenericClasses;

public class TClass <E> {


    public E add (E a) {

        return a;
    }

    public static void main(String args[]){
        int number = 10;
        TClass<Integer> t = new TClass();
        int value = t.add(number);
        System.out.println(value);

    }
}
